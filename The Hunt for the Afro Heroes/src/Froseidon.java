public class Froseidon extends enemyClass {
	//creates the ability array
		private ability[] froseidonAbilities;
		//determines physical strength of the character
		private int strength;
		//determines magical strength of the character
		private int magic;
		//determines hit points of the character
		private int health;
		//determines physical strength of the character
		private int defense;
		//determines the experience points awarded upon defeat
		private int experienceValue;
		//marks the place in the mageAbilities Array
		private int numAbilities;
		
		private int strMod;
		private int magMod;
		private int defMod;
		private int hpMod;
		
		private int init;
		
		private int l;
		
		private String name;
//Parameterized constructor	for setting custom levels
	public Froseidon(int l) {
		super();
		
		String job = "Boss";
		
		this.name = "Froseidon";
		
		init = 1;
		
		//assuming l stands for level? 
		this.l = l;
		
		//set base stats
		numAbilities = 4;
		strength = 3 + l;
		magic = 3 + l;
		health = 30 + 2*l;
		defense = 3 + l;	
		init = 3 + l;		
		
		strMod = 3;
		magMod = 3;
		hpMod = 3;
		defMod = 3;
		
		experienceValue = 5 * l;
		
		addAbility(3, "Evil Monologe", 2, toEvilMonolouge(), false, 3, 50, 3);
		addAbility(4, "Trident Strike", 1, toTridentStrike(), false, -1, -1, 0);
		addAbility(5, "Curse of Baldness", 2, toCurseOfBaldness(), false, -1, -1, 0);
		addAbility(6, "Thunder Strike", 2, toThunderStrike(), false, 2, 75, 3);
		
		updateActorFields(job, init, froseidonAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
		updateEnemyFields(experienceValue);
	}
	
	//Default constructor sets enemy to level 1
	public Froseidon() {
		super();
		
		froseidonAbilities = new ability[4];
		
		String job = "Boss";
		
		this.name = "Froseidon";
		
		init = 1;
		
		this.l = 1;
		
		
		//set base stats
		numAbilities = 0;
		strength = 3 + l;
		magic = 3 + l;
		health = 30 + 2*l;
		defense = 3 + l;	
		init = 3 + l;		
		
		strMod = 3;
		magMod = 3;
		hpMod = 3;
		defMod = 3;
		
		experienceValue = 5 * l;
		
		addAbility(3, "Evil Monologe", 2, toEvilMonolouge(), false, 3, 50, 3);
		addAbility(4, "Trident Strike", 1, toTridentStrike(), false, -1, -1, 0);
		addAbility(5, "Curse of Baldness", 2, toCurseOfBaldness(), false, -1, -1, 0);
		addAbility(6, "Thunder Strike", 2, toThunderStrike(), false, 2, 75, 3);
		
		updateActorFields(job, init, froseidonAbilities, name, l, strength
				, magic, health, defense, defMod, hpMod, strMod, magMod);
		updateEnemyFields(experienceValue);
	}
	
	//adds abilities to the ability array
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			froseidonAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
			numAbilities++;
		}
	}
//getters and setters
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

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int getExperienceValue() {
		return experienceValue;
	}
	public void setExperienceValue(int experienceValue) {
		this.experienceValue = experienceValue;
	}
	//level up method
	public void levelUp(int experience, int strength, int magic, int health, int defense, int level) {
		if (experience <= 100) {
		//removes experience needed for a level up
			experience = experience - 100;
		//recycles experience over 100 into the next level
			if(experience < 0) {
				experience = experience * -1;
			}
			//stat increases from the level up
			strength = strength + 1;
			magic = magic + 1;
			health = health + 10;
			defense = defense +1;
			level = level + 1;
			if(level == 5) {
				strength = strength + 5;
				magic = magic + 5;
				health = health + 50;
				defense = defense +1;
			if (level >= 5) {
				level = 5;
			}
			}
		}
	}
	


	//toString methods for ability description
	public String toEvilMonolouge() {
		String evilMonologeDescription = name + " drones on and on about his evil scheme for ";
		return evilMonologeDescription;
	}
	public String toTridentStrike() {
		String tridentStrikeDescription = name + " impales his foe with his trident for ";
		return tridentStrikeDescription;
	}
	public String toCurseOfBaldness() {
		String curseOfBaldnessDescription = name + " curses his foes to a life of Baldness for ";
		return curseOfBaldnessDescription;
	}
	public String toThunderStrike() {
		String thunderStrikeDescription = name + " unleashes a thunderclap dealing ";
		return thunderStrikeDescription;
	}
}




