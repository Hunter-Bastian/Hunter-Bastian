public class Naughtilus extends enemyClass {
	//creates the ability array
		private ability[] naughtilusAbilities;
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
	public Naughtilus(int l) {
		super();
		
		String job = " ";
		this.name = "Naughtilus";
		
		init = 1;
		
		//assuming l stands for level? 
		this.l = l;
		
		//set base stats
		numAbilities = 4;
		strength = 1 + l;
		magic = 2 + l;
		health = 10 + 2*l;
		defense = 2 + l;	
		init = 1 + l;		
		
		strMod = 1;
		magMod = 1;
		hpMod = 2;
		defMod = 1;
		
		experienceValue = 5 * l;
		
		addAbility(1, "Shell Smash", 1, toShellSmash(),false, -1, -1, 0);
		addAbility(-2, "Heal", 2, toHeal(), true, -1, -1, 0);
		addAbility(3, "Ink Leak", 1, toInkLeak(), false, -1, -1, 0);
		addAbility(4, "Blue Shell", 1, toBlueShell(), false, -1, -1, 0);
		
		updateActorFields(job, init, naughtilusAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
		updateEnemyFields(experienceValue);
	}
	
	//Default constructor sets enemy to level 1
	public Naughtilus() {
		super();
		
		naughtilusAbilities = new ability[4];
		
		String job = " ";
		
		this.name = "Naughtilus";
		
		init = 1;
		
		this.l = 1;
		
		
		//set base stats
		numAbilities = 0;
		strength = 1 + l;
		magic = 1 + l;
		health = 10 + 2*l;
		defense = 1 + l;	
		init = 1 + l;		
		
		strMod = 1;
		magMod = 1;
		hpMod = 2;
		defMod = 1;
		
		experienceValue = 5 * l;
		
		addAbility(1, "Shell Smash", 1, toShellSmash(),false, -1, -1, 0);
		addAbility(-2, "Heal", 2, toHeal(), true, -1, -1, 0);
		addAbility(3, "Ink Leak", 1, toInkLeak(), false, -1, -1, 0);
		addAbility(4, "Blue Shell", 1, toBlueShell(), false, -1, -1, 0);
		
		updateActorFields(job, init, naughtilusAbilities, name, l, strength
				, magic, health, defense, defMod, hpMod, strMod, magMod);
		updateEnemyFields(experienceValue);
	}
	
	//adds abilities to the ability array
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			naughtilusAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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
	public String toShellSmash() {
		String shellSmashDescription = name + " strikes with his shell for ";
		return shellSmashDescription;
	}
	public String toHeal() {
		String healDescription = name + " heals for ";
		return healDescription;
	}
	public String toInkLeak() {
		String inkLeakDescription = name + " sprays his enemy for ";
		return inkLeakDescription;
	}
	public String toBlueShell() {
		String blueShellDescription = name + " launches his shell fast enough to destroy a golf cart dealing ";
		return blueShellDescription;
	}
}