

public class Archer extends playerClass {
	//creates the ability array
	private ability[] archerAbilities;
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
	public Archer() {
		
		super();
		archerAbilities = new ability[4];
		String job = "Archer";
		name = "Birdeye";
		l = 1;
		strength = 1;
		magic = 1;
		health = 10;
		defense = 1;	
		init = 1;
		
		strMod = 1;
		magMod = 1;
		hpMod = 10;
		defMod = 1;
		
		addAbility(2, "Porcupine Shot", 1, toStringPorcupineShot(), false, -1, -1, 0);
		addAbility(3, "Cobra Shot", 1, toStringCobraShot(), false, 1, 25, 2);
		addAbility(4, "Blazing Arrow", 1, toStringBlazingArrow(), false, 0, 25, 2);
		addAbility(5, "Bad Hare Day", 1, toStringBadHareDay(), false, -1, -1, 0);
		
		updateActorFields(job, init, archerAbilities, name, l, strength,
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
//Parameterized constructor-> used to copy character progress into new instances
	public Archer(int init, String n, int l, int strength, int magic, int health, int defense, int experience) {
		super();
		String job = "Archer";
		this.name = n;
		this.l = l;
		this.strength = strength;
		this.magic = magic;
		this.health = health;
		this.defense = defense;	
		this.init = init;
		addAbility(2, "Porcupine Shot", 1, toStringPorcupineShot(), false, -1, -1, 0);
		addAbility(3, "Cobra Shot", 1, toStringCobraShot(), false, 1, 25, 2);
		addAbility(4, "Blazing Arrow", 1, toStringBlazingArrow(), false, 0, 25, 2);
		addAbility(5, "Bad Hare Day", 1, toStringBadHareDay(), false, -1, -1, 0);
		
		updateActorFields(job, init, archerAbilities, name, l, strength, 
				magic, health, defense, defMod, hpMod, strMod, magMod);
	}
	//method to add  an ability to the list
	public void addAbility(int damage, String abilityName, int type, String description, boolean selfTargetable, int statusType, int statusChance, int statusDuration){
		if(numAbilities<4 && numAbilities>=0){
			archerAbilities[numAbilities] = new ability(abilityName, damage, type, description, selfTargetable, statusType, statusChance, statusDuration);
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
public String toStringPorcupineShot() {
	String porcupineShotDescription = name + " angers a small animal and fires in frenzy dealing ";
	return porcupineShotDescription;
}
public String toStringCobraShot() {
	String cobraShotDescription = name + " fires an arrow dipped in an cobra venom dealing ";
	return cobraShotDescription;
}
public String toStringBlazingArrow() {
	String blazingArrowDescription = name + " fires a lit roman candle attached to an arrow dealing ";
	return blazingArrowDescription;
}
public String toStringBadHareDay() {
	String bhdDescription = name + " fires a footless rabbit dealing ";
	return bhdDescription;
}


}