

//specific for mage class of player characters

public class Warrior extends playerClass {
	//creates the ability array
	private ability[] warriorAbilities;
	//determines physical strength of the character
	private int strength;
	//determines magical strength of the character
	private int magic;
	//determines hit points of the character
	private int health;
	//determines physical strength of the character
	private int defense;
	
	//modifiers
	private int strMod;
	private int magMod;
	private int hpMod;
	private int defMod;
	
	//marks the place in the mageAbilities Array
	private int numAbilities = 0;
	
	private int init;
	private String name;
	private int l;
	//default constructor for new character creation
	public Warrior() {
		
		super();
		warriorAbilities = new ability[4];
		String job = "Warrior";
		name = "Triton";
		l = 1;
		strength = 6;
		magic = 1;
		health = 10;
		defense = 2;	
		init = 1;
		
		strMod = 2;
		magMod = 1;
		hpMod = 10;
		defMod = 1;
		
		addAbility(2, "Barber Sweep", 1, toStringBarberSweep(), false, -1, -1, 0);
		addAbility(3, "Caesar Cut", 1, toStringCaesarCut(), false, -1, -1, 0);
		addAbility(4, "Hair Metal", 1, toStringHairMetal(), false, 3, 25, 2);
		addAbility(5, "Bearded Dragon", 1, toStringBeardedDragon(), false, 0, 25, 2);
		
		updateActorFields(job, init, warriorAbilities, name, l, strength,
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
//Parameterized constructor-> used to copy character progress into new instances
	public Warrior(int init, String n, int l, int strength, int magic, int health, int defense, int experience) {
		super();
		String job = "Warrior";
		this.name = n;
		this.l = l;
		this.strength = strength;
		this.magic = magic;
		this.health = health;
		this.defense = defense;	
		this.init = init;
		addAbility(2, "Barber Sweep", 1, toStringBarberSweep(), false, -1, -1, 0);
		addAbility(3, "Caesar Cut", 1, toStringCaesarCut(), false, -1, -1, 0);
		addAbility(4, "Hair Metal", 1, toStringHairMetal(), false, 3, 25, 2);
		addAbility(5, "Bearded Dragon", 1, toStringBeardedDragon(), false, 0, 25, 2);
		
		updateActorFields(job, init, warriorAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
	//method to add  an ability to the list
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			warriorAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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

public String toStringBarberSweep() {
	String barberSweepDescription = name + " bellows and launches a sweeping blow dealing ";
	return barberSweepDescription;
}
public String toStringCaesarCut() {
	String caesarCutDescription = name + " swings and cuts with the fury of an Emperor dealing ";
	return caesarCutDescription;
}
public String toStringHairMetal() {
	String hairMetalDescription = name + " channels the icy frost to unleash a manenificent blow dealing ";
	return hairMetalDescription;
}
public String toStringBeardedDragon() {
	String beardedDragonDescription = name + " unleashes a fiery blow blessed by a Dragon's Beard dealing ";
	return beardedDragonDescription;
}

}