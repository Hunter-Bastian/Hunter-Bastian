
public class HairsprayGrenade extends Item{
	private String description;
	private statuses burn;
	
	public HairsprayGrenade() {
		super("Hairspray Grenade", 12, false, 0, 65);
		burn = new statuses();
		description = "pulls the pin on a can of hairspray and lobs it. It explodes! Dealing";
		
		super.updateStatus(burn);
		super.updateDescription(description);
	}

}