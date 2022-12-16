public class Mage extends playerClass {
	//creates the ability array
	private ability[] mageAbilities;
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
	public Mage() {
		
		super();
		mageAbilities = new ability[4];
		
		String job = "Mage";
		name = "Hairy Potter";
		l = 1;
		strength = 1;
		magic = 4;
		health = 10;
		defense = 1;	
		init = 1;
		
		strMod = 1;
		magMod = 2;
		hpMod = 10;
		defMod = 1;
		
		addAbility(2, "Fireball", 2, toStringFireball(), false, 0, 25, 2);
		addAbility(3, "Thunderbolt", 2, toStringThunderbolt(), false, 2, 25, 2);
		addAbility(4, "Ice Storm", 2, toStringIceStorm(), false, 3, 25, 2);
		addAbility(5, "Antimatter Singularity Vortex", 2, toStringAntimatterSingularityVortex(), false, -1, -1, 0);
		
		updateActorFields(job, init, mageAbilities, name, l, strength,
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
//Parameterized constructor-> used to copy character progress into new instances
	public Mage(int init, String n, int l, int strength, int magic, int health, int defense, int experience) {
		super();
		String job = "Mage";
		this.name = n;
		this.l = l;
		this.strength = strength;
		this.magic = magic;
		this.health = health;
		this.defense = defense;	
		this.init = init;
		addAbility(2, "Fireball", 2, toStringFireball(), false, 0, 25, 2);
		addAbility(3, "Thunderbolt", 2, toStringThunderbolt(), false, 2, 25, 2);
		addAbility(4, "Ice Storm", 2, toStringIceStorm(), false, 3, 25, 2);
		addAbility(5, "Antimatter Singularity Vortex", 2, toStringAntimatterSingularityVortex(), false, -1, -1, 0);
		
		updateActorFields(job, init, mageAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
	//method to add  an ability to the list
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			mageAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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

public String toStringFireball() {
	String fireballDescription = name + " casts a Fireball dealing ";
	return fireballDescription;
}
public String toStringThunderbolt() {
	String thunderboltDescription = name + " casts Thunderbolt dealing ";
	return thunderboltDescription;
}
public String toStringIceStorm() {
	String iceStormDescription = name + " casts Ice Storm dealing ";
	return iceStormDescription;
}
public String toStringAntimatterSingularityVortex() {
	String asmDescription = name + " casts a massive Antimatter Singularity Vortex dealing ";
	return asmDescription;
}

}