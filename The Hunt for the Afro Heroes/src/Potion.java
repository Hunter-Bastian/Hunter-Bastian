
public class Potion extends Item {
	private statuses none;
	private String description;
	public Potion() {
		super("Potion", 5, true, 0, 0);
		
		none = new statuses();
		
		description = "quickly downs a shot of groovy red go-go juice! They heal for";
		super.updateStatus(none);
		super.updateDescription(description);
	}
	
	
	
	
}