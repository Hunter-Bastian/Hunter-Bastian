import java.util.Random;
public abstract class enemyClass extends actor {
	private int experienceValue;
	private int chosenAbility;
	
	private int numViolentActions;
	private int numHealingActions;
	
	private int knownAbilities;
	
	private ability[] violentActions;
	private ability[] healingActions;
//getters and setters
	public void setExperienceValue(int experienceValue) {
		this.experienceValue = experienceValue;
	}
	public int getExperienceValue() {
		return experienceValue;
	}
	
	
//enemy specific function
	public void assembleViolentActions(){
		numViolentActions = 0;
		 for ( int i = 0; i < knownAbilities; i++) {
			 if ( !abilities[i].isSelfTargetable()) {
					violentActions[numViolentActions] = abilities[i];
					numViolentActions++;
				}
		 }
	}
	
	public void assembleHealingActions(){
		numHealingActions = 0;
		 for ( int i = 0; i < knownAbilities; i++) {
			 if ( abilities[i].isSelfTargetable()) {
					healingActions[numHealingActions] = abilities[i];
					numHealingActions++;
				}
		 }
	}
	
	
	//randomly chooses an ability to use
	public int action(boolean friendlyAction, int choice) {
		
		if (friendlyAction == false) {
			chosenAbility = getChoice(numViolentActions);
			return castAbility(violentActions[chosenAbility]);
		}
		else {
			chosenAbility = getChoice(numHealingActions);
			return castAbility(healingActions[chosenAbility]);
		}
	}
	
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
//Default Constructor	
	public enemyClass() {
		super(false);
		knownAbilities = 1;
		chosenAbility = 0;
		
		violentActions = new ability[4];
		violentActions[0] = null;
		violentActions[1] = null;
		violentActions[2] = null;
		violentActions[3] = null;
		
		numViolentActions = 0;
		
		healingActions = new ability[4];
		healingActions[0] = null;
		healingActions[1] = null;
		healingActions[2] = null;
		healingActions[3] = null;
		
		numHealingActions = 0;
		
		
	}
	
	public void updateEnemyFields(int experienceValue) {
		setExperienceValue(experienceValue);
		
		updateKnownAbilities(knownAbilities);
		
		assembleViolentActions();
		assembleHealingActions();
	}
	
}
