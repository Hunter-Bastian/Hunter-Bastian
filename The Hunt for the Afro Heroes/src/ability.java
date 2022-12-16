import java.util.Random;
public class ability{
	private	int damage; //positive numbers do damage to a target, negative numbers heal self q
	private String abilityName;
	private String description;
	private int invPos;
	//valid values are 0, 1, and 2.
	//0 represents Item use
	//1 represents physical while 2 represents magical
	//any other values will default to physical damage
	private int abilityType;
	private int statusType;
	/*
	-1 = no status
	0 = burn
	1 = poison
	2 = paralysis
	3 = freeze
	*/
	private int statusChance;
	//statusChance/100.  Int must be between 0 and 100.
	private int statusDuration;
	//duration in turns
	//default
	private boolean selfTargetable;
	public ability(){
		this .abilityType = 0;
		this.abilityName = "";
		this.damage = 0;
		this.description ="";
		this.statusType = -1;
		this.statusChance = -1;
		this.statusDuration = 0;
		this.selfTargetable = false;
		invPos = 0;
	}
	//parameterized
	public ability(String abilityName, int damage, int abilityType, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		this.abilityType = abilityType;
		this.abilityName = abilityName;
		this.damage = damage;
		this.description = description;
		if(statusType < -1 || statusType > 3){
			this.statusType = -1;
		}
		else{
			this.statusType = statusType;
		}
		if(statusChance < -1 || statusChance > 100){
			this.statusChance = -1;
		}
		else{
			this.statusChance = statusChance;
		}
		if(statusDuration < 0){
			this.statusDuration = 0;
		}
		else{
			this.statusDuration = statusDuration;	
		}
		this.selfTargetable = selfTargetable;
		invPos = 0;
	}
	
	//mutators/getters
	public int getInvPos() {
		return invPos;
	}
	public void setInvPos(int invPos) {
		this.invPos = invPos;
	}
	
	public boolean isSelfTargetable() {
		return selfTargetable;
	}
	
	public int getAbilityType() {
		return abilityType;
	}
	public void setAbilityType(int abilityType) {
		this.abilityType = abilityType;
	}
	public int getDamage(){
		return damage;
	}
	public String getAbilityName(){
		return abilityName;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public void setAbilityName(String abilityName){
		this.abilityName = abilityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatusType(){
		return statusType;
	}
	public void setStatusType(int statusType){
		this.statusType = statusType;
	}
	public int getStatusChance(){
		return statusChance;
	}
	public void setStatusChance(int statusChance){
		this.statusChance = statusChance;
	}
	public void statusDice(actor targetActor){
		if(statusChance <= 0){
			return;
		}
		if(statusChance == 100){
			targetActor.updateStatuses(statusType, statusDuration, true);
			return;
		}
		Random dice = new Random();
		int diceBuffer = dice.nextInt(100);
		if(diceBuffer <= this.statusChance){
			targetActor.updateStatuses(statusType, statusDuration, true);
		}
	}
}