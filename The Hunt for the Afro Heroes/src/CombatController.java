import java.util.Scanner;

import javax.swing.JFrame;

public class CombatController {

	Scanner in;
	
	// buffers
	private String output;
	
	private int totalXp;
	
	private int deathCount;
	
	private boolean victory;
	
	private boolean validate;//is the target selected a valid one?
	
	private int targetSelectionBuffer;//holds user input for target selection
	
	private int numActors;//number of total actors 
	
	private int fillBuffer;//holds initiativeTracker index value across two for loops
	
	private actor actorBuffer;//carries actor with high init for sorting- line 86
	
	private int actionEffect;//damage from attack 
	
	private boolean friendlyTarget;
	
	private int currentHero;
	
	private int targetNum;
	
	private int choiceBuffer;
	
	private int abilityNum;

	// combat Actors
	private enemyClass[] enemies;
	private playerClass[] pc;
	private actor targetBuffer;

	// some stage class with a graphic that displays?
	// private Stage stage; **not yet implemented**

	// array of abstract Actor class- will hold both Hero and Enemy objects
	private actor[] initiativeTracker;

	private int turnCount;
	private int currentActor;
	
	//gui
	combat encounter;
	

	// constructor runs the controller
	public CombatController(enemyClass[] enemies, playerClass[] pc, JFrame frame) {
		currentHero = 0;
		victory = false;
		friendlyTarget = false;
		deathCount = 0;
		totalXp = 0;
		in = new Scanner(System.in);
		this.enemies = enemies;
		this.pc = pc;

		initiativeSetup(enemies, pc);
		turnCount = 0;
		currentActor = 0;
		
		encounter = new combat(enemies, pc, frame, initiativeTracker);
		Loading load1 = new Loading(frame);
        load1.panel.setVisible(false);
        encounter.portraitFill(enemies, pc);
        
		
		
		while(!endCombat()) {
		takeTurn();
		}
		return;
		//resultScreen();
		//return;
	}

	public void initiativeSetup(enemyClass[] enemies, playerClass[] pc) {

		numActors = (enemies.length + pc.length);
		initiativeTracker = new actor[numActors];

		fillInitiative();

		sortInitiative();
	}

	// fills the array with actors
	private void fillInitiative() {
		// fill with enemies
		for (fillBuffer = 0; fillBuffer < enemies.length; fillBuffer++) {
			initiativeTracker[fillBuffer] = enemies[fillBuffer];
		}
		// fill with heroes
		for (int i = 0; i < pc.length; i++) {
			initiativeTracker[fillBuffer + i] = pc[i];
		}
	}

	// sort array by initiative values
	private void sortInitiative() {
		for (int i = 0; i < numActors; i++) {
			for (int j = 0; j < numActors; j++) {

				// Tie breaker
				if (initiativeTracker[i].getInitiative() == initiativeTracker[j].getInitiative()) {
					// elevate second element in case of tie
					initiativeTracker[j].setInitiative(initiativeTracker[j].getInitiative() + 1);
				}
				// sort
				if (initiativeTracker[i].getInitiative() < initiativeTracker[j].getInitiative()) {

					actorBuffer = initiativeTracker[i];

					initiativeTracker[i] = initiativeTracker[j];
					initiativeTracker[j] = actorBuffer;
				}
			}
		}
	}

	// manages turn order and calls heroAction() and enemyAction()
	// increments and returns the turnCount
	public void takeTurn() {
		if (currentActor >= initiativeTracker.length) {
			currentActor = 0;
		}
		if(!initiativeTracker[currentActor].isDead() ) {
			targetSelection();
		}
		currentActor++;
	}

	public void targetSelection() {
		//draw the arrow above the current actor
		if (initiativeTracker[currentActor].getPlayerFlag()) {
			
		}
		encounter.updateArrow(currentActor);
		//can allies be targeted? Or just enemies?
		friendlyTarget = false;
		checkForTargets();
		targetNum = 0;
		// if it's the player's turn
		if (initiativeTracker[currentActor].getPlayerFlag()) {
			encounter.displayFight();
			System.out.print("Select your target!\n");
			
			//prints in format-> 1:   EnemyName   Lvl 1   HP 5
			for (int i = 0; i < enemies.length; i++) {
				if (!enemies[i].isDead()) {
					System.out.println(i + 1 + ":   " + enemies[i].getName() + 
							"   Lvl " + enemies[i].getLevel() + 
							"   HP " + enemies[i].getRemainingHealth());
				}
				else {
					System.out.println("X");
				}
			}
			
			//if healing options exist
			targetNum = enemies.length;
			if(friendlyTarget == true) {
				encounter.displayHeal();
				System.out.println("\nAllies: ");
				for (int i = 0; i < pc.length; i++) {
					System.out.println(targetNum + i + 1 + ":   " + pc[i].getName() + 
							"   Lvl " + pc[i].getLevel() + 
							"   HP " + pc[i].getRemainingHealth());
				}
			
				
				while(encounter.getConfirm() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    	targetSelectionBuffer = encounter.getEnemySelected();
				    }
				}
				    
				    
				targetSelectionBuffer = encounter.getEnemySelected();
				int currentHero = 0;
				while(initiativeTracker[currentActor].getName() != pc[currentHero].getName()) {
					currentHero++;
				}
				//attack menu
				encounter.displayActions(pc, currentHero);
				while(encounter.getConfirm() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    }
				}
				abilityNum = encounter.getAbillityNum();
				System.out.println("abilityNum is " + abilityNum);
				if(encounter.getActionType() == 1) {
					healTheHero();
				}
				else {
					damageTheEnemy();
				}
			}
//				if(validateCompleteSelection()) {
//					healTheHero();
//				}
//				else {
//					damageTheEnemy();
//				}
//			}
			
			else {
				while(encounter.getConfirm() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    }
			}
				targetSelectionBuffer = encounter.getEnemySelected();
				while(encounter.getConfirm() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    }
				}
				
				//attack menu
				int currentHero = 0;
				while(initiativeTracker[currentActor].getName() != pc[currentHero].getName()) {
					currentHero++;
				}
				//attack menu
				encounter.displayActions(pc, currentHero);
				
				while(encounter.getConfirm() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    }
				}
				abilityNum = encounter.getAbillityNum();
				//validateTheEnemy();
				targetSelectionBuffer = encounter.getEnemySelected();
				System.out.println("TargetSelectionBuffer is: " + targetSelectionBuffer);
				damageTheEnemy();
				targetSelectionBuffer = encounter.getEnemySelected();
				System.out.println("TargetSelectionBuffer is: " + targetSelectionBuffer);
			}
		}
		// if it's the enemy's turn
		else {
			System.out.println(initiativeTracker[currentActor].getName() +
					"'s turn!");
			
			if(friendlyTarget == true) {
				choiceBuffer = initiativeTracker[currentActor].getChoice(5);
				
				//enemy chooses to attack
				if(choiceBuffer <= 3) {
					validateTheHero();
					damageTheHero();
				}
				//enemy chooses to heal 
				else {
					healTheEnemy();
				}
			}
			else {
				validateTheHero();
				damageTheHero();
			}
		}

	}
	
	public void checkForTargets() {
		for (int i = 0; i < initiativeTracker[currentActor].getKnownAbilities(); i++) {
			if (initiativeTracker[currentActor].abilities[i].isSelfTargetable()) {
				friendlyTarget = true;
			}
		}
		//if hero check items
		if(initiativeTracker[currentActor].getPlayerFlag()) {
			//identify the current hero
			for (int i = 0; i < pc.length; i++) {
				if (initiativeTracker[currentActor].getName() == pc[i].getName()) {
					currentHero = i;
					break;
				}
			}
			
			if ( pc[currentHero].checkBag() == true) {
				friendlyTarget = true;
			}
		}
		
	}

	// returns true when combat ends- transitions back to overworld
	// and applies xp
	public boolean endCombat(){
		deathCount = 0;
		for(int i = 0; i < enemies.length; i++) {
			if(enemies[i].isDead()) {
				deathCount++;
				totalXp += enemies[i].getExperienceValue();
			}	
		}
			if(deathCount == enemies.length) {
				for (int i = 0; i < pc.length; i++) {
					pc[i].gainExperience(totalXp);
				}
				encounter.panel.setVisible(false);
				//in.close();
				victory = true;
				return true;
			}
			
			deathCount = 0;
			
		for (int i = 0; i < pc.length; i++) {
			if(pc[i].isDead()) {
				deathCount++;
			}
		}
		if(deathCount == pc.length) {
			encounter.panel.setVisible(false);
			//in.close();
			return true;
		}
				
		return false;
	}
	
	
	
	public void damageTheEnemy() {
		//get player damage
		actionEffect = initiativeTracker[currentActor].action(false, abilityNum);
		//modify damage
		actionEffect = (actionEffect - 
				enemies[targetSelectionBuffer].getDefense());
		if(actionEffect <= 0) {
			actionEffect = 1;
		}
		//apply damage
		enemies[targetSelectionBuffer].setRemainingHealth(
				enemies[targetSelectionBuffer].getRemainingHealth()- actionEffect);
		//print the end of the cast ability string
		System.out.println(actionEffect + " damage!");
		output = initiativeTracker[currentActor].getTempOutput();
		output+= (" " + actionEffect + " damage!");
		encounter.updatePortraits(enemies, pc);
		encounter.updateText(output);
		while(encounter.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
	}
	public void healTheHero() {
		//how much healing is happening
		actionEffect = initiativeTracker[currentActor].action(true, abilityNum);
		
		pc[targetSelectionBuffer].setRemainingHealth(
				pc[targetSelectionBuffer].getRemainingHealth() + actionEffect);
		
		System.out.println(actionEffect + " health!");
		output = initiativeTracker[currentActor].getTempOutput();
		output+= (" " + actionEffect + " health!");
		encounter.updateText(output);
		while(encounter.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
	}
	
	
	
	public void validateTheEnemy() {
		validate = false;
		while(!validate) {
			System.out.print('>');
			//targetSelectionBuffer = in.nextInt();
			if(targetSelectionBuffer > 0 && targetSelectionBuffer <= enemies.length) {
				if(enemies[targetSelectionBuffer].isDead()) {
					System.out.println("Not a valid target. Select your target!");
				}
				else {
					validate = true;
				}
			}
			else {
				System.out.println("Not a valid target. Select your target!");
			}
		}
	}
	
	public void validateTheHero() {
		validate = false;
		while(!validate) {
			targetSelectionBuffer = initiativeTracker[currentActor].getChoice(pc.length);
			if (targetSelectionBuffer >= 0 && targetSelectionBuffer < pc.length) {
				if (!initiativeTracker[targetSelectionBuffer].isDead()) {
					validate = true;
				}
			}
		}
	}
	
	public void damageTheHero() {
		//get enemy damage
		actionEffect = initiativeTracker[currentActor].action(false, abilityNum);
		//modify damage
		actionEffect = (actionEffect - 
				pc[targetSelectionBuffer].getDefense());
		if(actionEffect <= 0) {
			actionEffect = 1;
		}
		//apply damage
		pc[targetSelectionBuffer].setRemainingHealth(
				pc[targetSelectionBuffer].getRemainingHealth()- actionEffect);
		//print the end of the cast ability string
				output = initiativeTracker[currentActor].getTempOutput();
				output+= (" " + actionEffect + " damage!");
		encounter.updatePortraits(enemies, pc);
		encounter.updateText(output);
		while(encounter.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
	}
	public void healTheEnemy() {
		//get healing amount
		actionEffect = initiativeTracker[currentActor].action(true, abilityNum);
		//apply healing
		initiativeTracker[currentActor].setRemainingHealth(
				initiativeTracker[currentActor].getRemainingHealth() + actionEffect);
		//print the end of the cast ability string
		System.out.println(" " + actionEffect + " health!");
		output = initiativeTracker[currentActor].getTempOutput();
		output+= (" " + actionEffect + " health!");
		encounter.updateText(output);
		while(encounter.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
	}
	
	public boolean validateCompleteSelection() {
		validate = false;
		while(!validate) {
			System.out.print('>');
			targetSelectionBuffer = in.nextInt();
			if(targetSelectionBuffer > 0 && targetSelectionBuffer <= enemies.length+pc.length) {
				
				//if target is an enemy
				if (targetSelectionBuffer <= enemies.length) {
					if (enemies[targetSelectionBuffer-1].isDead()) {
						System.out.println("Not a valid target. Select your target!");
					}
					else {
						validate = true;
					}
				}
				
				//if target is a hero
				else {
					if(pc[targetSelectionBuffer-1-enemies.length].isDead()) {
						System.out.println("Not a valid target. Select your target!");
					}
					else {
						validate = true;
					}
				}
			}
			
			//if the target is outside the correct range
			else {
				System.out.println("Not a valid target. Select your target!");
			}
		}
		
		if(targetSelectionBuffer > enemies.length) {
		return true;
		}
		else {
			return false;
		}
	}

public void resultScreen() {
	if(victory) {
		System.out.println("           88                                                       \r\n" + 
				"            \"\"              ,d                                       \r\n" + 
				"                            88                                       \r\n" + 
				"8b       d8 88  ,adPPYba, MM88MMM ,adPPYba,  8b,dPPYba, 8b       d8  \r\n" + 
				"`8b     d8' 88 a8\"     \"\"   88   a8\"     \"8a 88P'   \"Y8 `8b     d8'  \r\n" + 
				" `8b   d8'  88 8b           88   8b       d8 88          `8b   d8'   \r\n" + 
				"  `8b,d8'   88 \"8a,   ,aa   88,  \"8a,   ,a8\" 88           `8b,d8'    \r\n" + 
				"    \"8\"     88  `\"Ybbd8\"'   \"Y888 `\"YbbdP\"'  88             Y88'     \r\n" + 
				"                                                            d8'      \r\n" + 
				"                                                           d8'     ");
		
		
	}
		
		else {
			System.out.println("\r\n" + 
					"        _.---,._,'\r\n" + 
					"       /' _.--.<\r\n" + 
					"         /'     `'\r\n" + 
					"       /' _.---._____\r\n" + 
					"       \\.'   ___, .-'`\r\n" + 
					"           /'    \\\\             .\r\n" + 
					"         /'       `-.          -|-\r\n" + 
					"        |                       |\r\n" + 
					"        |                   .-'~~~`-.\r\n" + 
					"        |                 .'         `.\r\n" + 
					"        |                 |  R  I  P  |\r\n" + 
					"  jgs   |                 |           |\r\n" + 
					"        |                 |           |\r\n" + 
					"         \\              \\\\|           |//\r\n" + 
					"   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			
		}
	
	}
}