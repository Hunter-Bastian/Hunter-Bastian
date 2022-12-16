

public class Hacker extends playerClass {
	//creates the ability array
	private ability[] hackerAbilities;
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
	public Hacker() {
		
		super();
		hackerAbilities = new ability[4];
		String job = "Hacker";
		name = "Hackerman";
		l = 1;
		strength = 1;
		magic = 10;
		health = 10;
		defense = 1;	
		init = 1;
		
		strMod = 1;
		magMod = 4;
		hpMod = 10;
		defMod = 1;
		
		addAbility(2, "l33t Speak", 2, toStringL33tSpeak(), false, -1, -1, 0);
		addAbility(3, "Execessive UI", 2, toStringExcessiveUI(), false, -1, -1, 0);
		addAbility(4, "Skull GIF", 2, toStringSkullGIF(), false, -1, -1, 0);
		addAbility(15, "Hack the Pentagon", 2, toStringHackThePentagon(), false, 0, 50, 2);
		
		updateActorFields(job, init, hackerAbilities, name, l, strength,
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
//Parameterized constructor-> used to copy character progress into new instances
	public Hacker(int init, String n, int l, int strength, int magic, int health, int defense, int experience) {
		super();
		String job = "Hacker";
		this.name = n;
		this.l = l;
		this.strength = strength;
		this.magic = magic;
		this.health = health;
		this.defense = defense;	
		this.init = init;
		addAbility(2, "l33t Speak", 2, toStringL33tSpeak(), false, -1, -1, 0);
		addAbility(3, "Execessive UI", 2, toStringExcessiveUI(), false, -1, -1, 0);
		addAbility(4, "Skull GIF", 2, toStringSkullGIF(), false, -1, -1, 0);
		addAbility(15, "Hack the Pentagon", 2, toStringHackThePentagon(), false, 0, 50, 2);
		
		updateActorFields(job, init, hackerAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
	//method to add  an ability to the list
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			hackerAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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


public String toStringL33tSpeak() {
	String holySmiteDescription = name + " speaks in outdated l33t speak blowing their enemies mind dealing ";
	return holySmiteDescription;
}
public String toStringExcessiveUI() {
	String healDescription = name + " damages the mind of their foe with a UI that is excessive dealing  ";
	return healDescription;
}
public String toStringSkullGIF() {
	String shieldBonkDescription = name + " throws a laptop with a skull gif that explodes dealing ";
	return shieldBonkDescription;
}
public String toStringHackThePentagon() {
	String hhgDescription = name + " hacks into the Pentagon and launches a projectile that explodes with the force of a split atom dealing ";
	return hhgDescription;
}

}
