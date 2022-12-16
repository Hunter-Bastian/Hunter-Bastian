public class Rogue extends playerClass {
	//creates the ability array
	private ability[] rogueAbilities;
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
	public Rogue() {
		
		super();
		rogueAbilities = new ability[4];
		
		String job = "Rogue";
		name = "Dr Stabs-a-lot";
		l = 1;
		strength = 4;
		magic = 1;
		health = 10;
		defense = 1;	
		init = 3;
		
		strMod = 2;
		magMod = 1;
		hpMod = 10;
		defMod = 1;
		
		addAbility(2, "Blinding Smoke", 1, toStringBlindingSmoke(), false, -1, -1, 0);
		addAbility(3, "Poison Vial", 1, toStringPoisonVial(), false, 1, 25, 2);
		addAbility(4, "Fan O' Knives", 1, toStringFanOKnives(), false, -1, -1, 0);
		addAbility(4*l, "Stabity Stab", 1, toStringStabityStab(), false, -1, -1, 0);
		
		updateActorFields(job, init, rogueAbilities, name, l, strength,
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
//Parameterized constructor-> used to copy character progress into new instances
	public Rogue(int init, String n, int l, int strength, int magic, int health, int defense, int experience) {
		super();
		String job = "Rogue";
		this.name = n;
		this.l = l;
		this.strength = strength;
		this.magic = magic;
		this.health = health;
		this.defense = defense;	
		this.init = init;
		addAbility(2, "Blinding Smoke", 1, toStringBlindingSmoke(), false, -1, -1, 0);
		addAbility(3, "Poison Vial", 1, toStringPoisonVial(), false, 1, 25, 2);
		addAbility(4, "Fan O' Knives", 1, toStringFanOKnives(), false, -1, -1, 0);
		addAbility(4*l, "Stabity Stab", 1, toStringStabityStab(), false, -1, -1, 0);
		
		updateActorFields(job, init, rogueAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
	//method to add  an ability to the list
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			rogueAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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

public String toStringBlindingSmoke() {
	String blindingSmokeDescription = name + " throws a smoke bomb dealing ";
	return blindingSmokeDescription;
}
public String toStringPoisonVial() {
	String poisonVialDescription = name + " uses a healing touch restoring ";
	return poisonVialDescription;
}
public String toStringFanOKnives() {
	String fanOKnivesDescription = name + " throws a fan full of knives dealing ";
	return fanOKnivesDescription;
}
public String toStringStabityStab() {
	String stabityStabDescription = name + " goes into a frenzy and stabs repeatedly dealing ";
	return stabityStabDescription;
}

}