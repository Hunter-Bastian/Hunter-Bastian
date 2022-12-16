public class Hairizzle extends enemyClass {
	//creates the ability array
		private ability[] hairizzleAbilities;
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
	public Hairizzle(int l) {
		super();
		
		String job = " ";
		
		this.name = "Hairizzle";
		
		init = 1;
		
		//assuming l stands for level? 
		this.l = l;
		
		//set base stats
		numAbilities = 4;
		strength = 2 + l;
		magic = 2 + l;
		health = 20 + 2*l;
		defense = 2 + l;	
		init = 2 + l;		
		
		strMod = 2;
		magMod = 2;
		hpMod = 2;
		defMod = 2;
		
		experienceValue = 5 * l;
		
		addAbility(2, "Hair Drill", 1, toHairDrill(), false, -1, -1, 0);
		addAbility(3, "Fearsome Presense", 2, toFearsomePresense(), false, 2, 25, 2);
		addAbility(4, "Hairy Fist", 1, toHairyFist(), false, -1, -1, 0);
		addAbility(5, "Sonic Screech", 1, toSonicScreech(), false, 2, 25, 2);
		
		updateActorFields(job, init, hairizzleAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
		updateEnemyFields(experienceValue);
	}
	
	//Default constructor sets enemy to level 1
	public Hairizzle() {
		super();
		
		hairizzleAbilities = new ability[4];
		
		String job = " ";
		
		this.name = "Hairizzle";
		
		init = 1;
		
		this.l = 1;
		
		
		//set base stats
		numAbilities = 0;
		strength = 2 + l;
		magic = 2 + l;
		health = 20 + 2*l;
		defense = 2 + l;	
		init = 2 + l;		
		
		strMod = 2;
		magMod = 2;
		hpMod = 2;
		defMod = 2;
		
		experienceValue = 5 * l;
		
		addAbility(2, "Hair Drill", 1, toHairDrill(), false, -1, -1, 0);
		addAbility(3, "Fearsome Presense", 2, toFearsomePresense(), false, 2, 25, 2);
		addAbility(4, "Hairy Fist", 1, toHairyFist(), false, -1, -1, 0);
		addAbility(5, "Sonic Screech", 1, toSonicScreech(), false, 2, 25, 2);
		
		updateActorFields(job, init, hairizzleAbilities, name, l, strength
				, magic, health, defense, defMod, hpMod, strMod, magMod);
		updateEnemyFields(experienceValue);
	}
	
	//adds abilities to the ability array
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			hairizzleAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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
	public String toHairDrill() {
		String hairDrillDescription = name + " shapes his hair into drills and strikes for ";
		return hairDrillDescription;
	}
	public String toFearsomePresense() {
		String fearsomePresense = name + " terrifies his enemey with a stunning presense for ";
		return fearsomePresense;
	}
	public String toHairyFist() {
		String hairyFistDescription = name + " punches with a bushy fist for ";
		return hairyFistDescription;
	}
	public String toSonicScreech() {
		String sonicScreechDescription = name + " unleashes an unnatural scream dealing ";
		return sonicScreechDescription;
	}
}


