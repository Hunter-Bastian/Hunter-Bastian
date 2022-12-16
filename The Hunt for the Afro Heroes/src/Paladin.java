

public class Paladin extends playerClass {
	//creates the ability array
	private ability[] paladinAbilities;
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
	public Paladin() {
		
		super();
		paladinAbilities = new ability[4];
		
		String job = "Paladin";
		name = "Sir Jellyfish the Shocking";
		l = 1;
		strength = 4;
		magic = 1;
		health = 10;
		defense = 2;	
		init = 1;
		
		strMod = 2;
		magMod = 1;
		hpMod = 10;
		defMod = 2;
		
		addAbility(3, "Holy Smite", 1, toStringHolySmite(), false, -1, -1, 0);
		addAbility(-2, "Heal", 1, toStringHeal(), true, -1, -1, 0);
		addAbility(4, "Shield Bonk", 1, toStringShieldBonk(), false, -1, -1, 0);
		addAbility(7, "Holy Hand Grenade", 1, toStringHolyHandGrenade(), false, -1, -1, 0);
		
		updateActorFields(job, init, paladinAbilities, name, l, strength,
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
//Parameterized constructor-> used to copy character progress into new instances
	public Paladin(int init, String n, int l, int strength, int magic, int health, int defense, int experience) {
		super();
		this.name = n;
		String job = "Paladin";
		this.l = l;
		this.strength = strength;
		this.magic = magic;
		this.health = health;
		this.defense = defense;	
		this.init = init;
		addAbility(2, "Holy Smite", 1, toStringHolySmite(), false, -1, -1, 0);
		addAbility(-2, "Heal", 1, toStringHeal(), true, -1, -1, 0);
		addAbility(4, "Shield Bonk", 1, toStringShieldBonk(), false, -1, -1, 0);
		addAbility(7, "Holy Hand Grenade", 1, toStringHolyHandGrenade(), false, -1, -1, 0);
		
		updateActorFields(job, init, paladinAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
	//method to add  an ability to the list
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			paladinAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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

public String toStringHolySmite() {
	String holySmiteDescription = name + " prays for his God to smite and then strikes dealing ";
	return holySmiteDescription;
}
public String toStringHeal() {
	String healDescription = name + " uses a healing touch restoring ";
	return healDescription;
}
public String toStringShieldBonk() {
	String shieldBonkDescription = name + " slams his shield into his enemy dealing ";
	return shieldBonkDescription;
}
public String toStringHolyHandGrenade() {
	String hhgDescription = name + " lobs an explosive relic dealing ";
	return hhgDescription;
}

}