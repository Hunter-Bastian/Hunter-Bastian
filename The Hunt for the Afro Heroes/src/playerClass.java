import java.util.Scanner;

//base for player characters
public abstract class playerClass extends actor {

	private int knownAbilities;
	private int listedAbilities;
	private Scanner in;
	private int selectionBuffer;
	private boolean actionTakenFlag;
	private int experience;
	
	private Item[] inventory;
	private boolean bagFull;
	private int invTracker;
	
	private int abilityNum;
	private int itemsListed;
	private int itemEffectBuffer;
	
	private ability[] friendlyActions;
	private int numFriendlyActions;
	
	private ability[] violentActions;
	private int numViolentActions;
	
	
//getters and setters
	//player specific methods
	
	public void gainExperience(int experience) {
		this.experience += experience;
		if(this.experience > 100) {
		//	levelUp();
			this.experience -= 100;
		}
	}
	//level up occurs at 100 experience points
		public void levelUp() {
				//stat increases from the level up
				setStrength(getStrength() + getStrMod());
				setMagic(getMagic() + getMagMod());
				setHealth(getHealth() + getHpMod());
				setDefense(getDefense() + getDefMod());
				setLevel(getLevel() +1);
				if (getLevel() <= 4) {
					knownAbilities++;
				}
			}
	
	public void unlockAbility(int abilityIndex) {
		
	}

	public void assembleFriendlyActions() {
		numFriendlyActions = 0;
		for ( int i = 0; i < knownAbilities; i++) {
			if ( abilities[i].isSelfTargetable()) {
				friendlyActions[numFriendlyActions] = abilities[i];
				numFriendlyActions++;
			}
		}
		for ( int i = 0; i < invTracker; i++) {
			if ( inventory[i].isSelfTargetable()) {
				friendlyActions[numFriendlyActions] = inventory[i];
				numFriendlyActions++;
			}
		}
	}
	
	public void assembleViolentActions() {
		numViolentActions = 0;
		 for ( int i = 0; i < knownAbilities; i++) {
			 if ( !abilities[i].isSelfTargetable()) {
					violentActions[numViolentActions] = abilities[i];
					numViolentActions++;
				}
		 }
		 for ( int i = 0; i < invTracker; i++) {
				if ( !inventory[i].isSelfTargetable()) {
					violentActions[numViolentActions] = inventory[i];
					numViolentActions++;
				}
			}
			 
		
	}
	
	public int action(boolean friendlyAction, int choice) {
		System.out.println(getName() + "   HP: " + getRemainingHealth());
		listedAbilities = 1;
		itemsListed = 0;
		
		
		if (friendlyAction == true) {
			assembleFriendlyActions();
			
			//list magic actions
			System.out.println("Magic: ");
			for (int i = 0; i < numFriendlyActions; i++) {
				if(friendlyActions[i].getAbilityType() == 2) {
					System.out.println(listedAbilities + " " + friendlyActions[i].getAbilityName());
					listedAbilities++;
				}
			}
			System.out.println("Items: ");
			for (int i = 0; i < numFriendlyActions; i++) {
				if (friendlyActions[i].getAbilityType() == 0) {
					System.out.println( (listedAbilities) + " " + friendlyActions[i].getAbilityName());
					itemsListed++;
					listedAbilities++;
				}
			}
			
			abilityNum = listedAbilities - itemsListed;
			//user selects their action
			actionTakenFlag = false;
			while(!actionTakenFlag) {
//				System.out.print("\nSelect an action ");
//				selectionBuffer = in.nextInt();
				
				//validate input
				if( choice >=0 && choice < (listedAbilities) ) {
					actionTakenFlag = true;
					}
			}
			
			//if the chosen action is an ability
			if (choice < abilityNum-1) {
				
				//adds magical bonus for magical actions
				if (friendlyActions[choice].getAbilityType() == 2) {
					return castAbility(friendlyActions[choice]) + getMagic();
				}
				return 0;//shouldn't happen but makes the compiler happy
			}
				
			//if the chosen action is an item
			else {
				return useItem(friendlyActions[choice]);
			}
			
		}
		
		
		else {
			assembleViolentActions();
			
			//list physical actions
			System.out.println("Fight: ");
			for ( int i = 0; i < numViolentActions; i++) {
				if(violentActions[i].getAbilityType() == 1)
				{
				System.out.println(listedAbilities + " " + violentActions[i].getAbilityName());
				listedAbilities++;
				}
			}
			
			System.out.print('\n');
			//list magic actions
			System.out.println("Magic: ");
			for (int i = 0; i < numViolentActions; i++) {
				if(violentActions[i].getAbilityType() == 2) {
					System.out.println(listedAbilities + " " + violentActions[i].getAbilityName());
					listedAbilities++;
				}
			}
			
			if (!isBagEmpty()) {
				System.out.println("Items: ");
				for (int i = 0; i < numViolentActions; i++) {
					if (violentActions[i].getAbilityType() == 0) {
						System.out.println( (listedAbilities) + " " + violentActions[i].getAbilityName());
						itemsListed++;
						listedAbilities++;
					}
				}
			}
			
			abilityNum = listedAbilities - itemsListed;
			//user selects their action
			actionTakenFlag = false;
			while(!actionTakenFlag) {
//				System.out.print("\nSelect an action ");
//				selectionBuffer = in.nextInt();
				
				//validate input
				if( choice >=0 && choice < (listedAbilities) ) {
					actionTakenFlag = true;
					}
			}
			
			//if the chosen action is an ability
			if (choice < abilityNum-1) {
				//adds physical damage for physical attacks
				if(violentActions[choice].getAbilityType() != 2 &&
						violentActions[choice].getAbilityType() != 0) {
					return castAbility(violentActions[choice]) + getStrength();
				}
				//adds magical damage for magical attacks
				else if (violentActions[choice].getAbilityType() == 2) {
					return castAbility(violentActions[choice]) + getMagic();
				}
			}
				//if the chosen action is an item
				else {
					return useItem(violentActions[choice]);
				
				}
			}
		return 0;//really should never happen
	}
	
	
	public void addItem(Item item) {
		if(bagFull == false) {
			inventory[invTracker] =  item;
			inventory[invTracker].setInvPos(invTracker);
			invTracker++;
			
			if (invTracker >= 2) {
				bagFull = true;
			}
		}
	}
	
	public int useItem(ability item) {
		if(!isBagEmpty()) {
			System.out.print(getName() + " " + item.getDescription()
					+ " ");
			
			itemEffectBuffer = item.getDamage();
			inventory[item.getInvPos()] = null;
			if ( item.getInvPos() < 2) {
				inventoryResort();
				}
			this.castAbility(item);
			return itemEffectBuffer;
			}
			return 0;
		}
	
	public void inventoryResort() {
		for (int i = 0; i < inventory.length-1; i++) {
			if (inventory[i+1] != null) {
				inventory[i] = inventory[i+1];
				inventory[i+1] = null;
				
				inventory[i].setInvPos(i);
			}
		}
		invTracker--;
	}
	
	public boolean isBagEmpty() {
		if (invTracker > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int getInvTracker() {
		return invTracker;
	}
	
	public boolean checkBag() {
		for (int i = 0; i < invTracker; i++) {
			if (inventory[i].friendlyTarget()) {
				return true;
			}
		}
		return false;
	}
	
	public String getViolentActionName(int i) {
		return violentActions[i].getAbilityName();
	}
	public String getFriendlyActionName(int i) {
		return friendlyActions[i].getAbilityName();
	}
	public int getNumViolentActions() {
		return numViolentActions;
	}
	public int getNumFriendlyActions() {
		return numFriendlyActions;
	}
	public int getViolentAbilityType(int i) {
		return violentActions[i].getAbilityType();	
	}
	public int getFriendlyAbilityType(int i) {
		return friendlyActions[i].getAbilityType();	
	}
//Parameterized Constructor	
	public playerClass() {
		super(true);
		in = new Scanner(System.in);
		knownAbilities = 1;
		
		bagFull = false;
		inventory = new Item[3];
		inventory[0] = null;
		inventory[1] = null;
		inventory[2] = null;
		invTracker = 0;
		itemsListed = 0;
		
		friendlyActions = new ability[4];
		friendlyActions[0] = null;
		friendlyActions[1] = null;
		friendlyActions[2] = null;
		friendlyActions[3] = null;
		
		numFriendlyActions = 0;
		
		violentActions = new ability[7];
		violentActions[0] = null;
		violentActions[1] = null;
		violentActions[2] = null;
		violentActions[3] = null;
		violentActions[4] = null;
		violentActions[5] = null;
		violentActions[6] = null;
		
		numViolentActions = 0;
	}
}