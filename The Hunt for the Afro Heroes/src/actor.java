import java.util.Random;

//base abstract class that forms both player characters and enemies
public abstract class actor {
	
	private Random rand;
	
	//common fields
	protected ability[] abilities;
	private int initiative;
	private String name;
	private int level;
	private boolean playerFlag;
	private int remainingHealth;
	private statuses actorStatuses = new statuses();
	private String job;
	private String tempOutput;
	
	//stats
	private int knownAbilities;
	
	private int strength;//determines physical strength of the character
	
	private int magic;//determines magical strength of the character
	
	private int health;//determines hit points of the character
	
	private int defense;//determines resistance to damage
	
	//statModifiers (used when leveling up)
	private int strMod;
	
	private int magMod;
	
	private int hpMod;
	
	private int defMod;

	//getters and setters
	public String getJob() {
		return job;
	}
	
	public boolean getPlayerFlag() {
		return playerFlag;
	}
	public void setPlayerFlag(boolean flag) {
		this.playerFlag = flag;
	}
	
	
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int intiative) {
		this.initiative = intiative;
	}
	
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}
	
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getRemainingHealth() {
		return remainingHealth;
	}
	public void setRemainingHealth(int remainingHealth) {
		if (remainingHealth < 0) {
			this.remainingHealth = 0;
		}
		//health != 0  clause necessary or game will terminate to victory immediately 
		else if (remainingHealth > health && health != 0) {
			this.remainingHealth = health;
		}
		else{
			this.remainingHealth = remainingHealth;
		}
	}
	
	
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	

	public void setStrMod(int strMod) {
		this.strMod = strMod;
	}
	public int getStrMod() {
		return strMod;
	}
	
	
	public void setMagMod(int magMod) {
		this.magMod = magMod;
	}
	public int getMagMod() {
		return magMod;
	}
	
	
	public void setHpMod(int hpMod) {
		this.hpMod = hpMod;
	}
	public int getHpMod() {
		return hpMod;
	}
	
	
	public void setDefMod(int defMod) {
		this.defMod = defMod;
	}
	public int getDefMod() {
		return defMod;
	}
	
	public void updateKnownAbilities(int knownAbilities) {
		this.knownAbilities = knownAbilities;
	}
	public int getKnownAbilities() {
		return knownAbilities;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	public int getAbilityCount() {
		return abilities.length;
	}
	
	public boolean isDead() {
		if (remainingHealth == 0) {
			return true;
		}
		return false;
	}
	//rng
	public int getChoice(int numChoices) {
		return rand.nextInt(numChoices);
	}
	
	//ability text and damage without respect to defense
	public int castAbility(ability ability) {
		tempOutput = ability.getDescription();
		return ability.getDamage();
	}
	public String getTempOutput() {
		return tempOutput;
	}
	
	//handles ability selection
	public abstract int action(boolean friendlyAction, int choice);
	
    //default constructor is mostly empty, all fields are specified by class/enemy type
	public actor(boolean playerFlag) {
		this.playerFlag = playerFlag;
		job = " ";
		setInitiative(0);
		setName("");
		setLevel(0);
		setStrength(0);
		setMagic(0);
		setHealth(0);
		setRemainingHealth(1);
		setDefense(0);
		
		setDefMod(0);
		setHpMod(0);
		setStrMod(0);
		setMagMod(0);
		rand = new Random();
		
		knownAbilities = 1;
		
	};
	
	//used to set all actor fields after inherited classes have set their fields
	public void updateActorFields(String job, int initiative, ability[] abilities,
			String name, int level, int strength, int magic, int health, int defense,
			int defMod, int hpMod, int strMod, int magMod) {
		//set common fields
		this.job = job;
		setInitiative(initiative);
		setName(name);
		setLevel(level);
		setStrength(strength);
		setMagic(magic);
		setHealth(health);
		setRemainingHealth(health);
		setDefense(defense);
		
		//set modifiers
		setDefMod(defMod);
		setHpMod(hpMod);
		setStrMod(strMod);
		setMagMod(magMod);

		
		//create and replicate ability array
		this.abilities = new ability[abilities.length];
		this.abilities = abilities;
	}

	public void updateStatuses(int location, int statusDuration, boolean status){
		actorStatuses.SetStatus(location, statusDuration, status);
	}
}