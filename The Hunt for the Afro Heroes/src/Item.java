
import java.util.Random;
public abstract class Item extends ability{
	//member variable
	private String name;
	
	private String description;
	
	private int effect;//healing or damage
	
	private boolean friendlyTargetable;//true means it targets allies, false targets enemies
	
	private int duration;//how long does the effect last
	
	private int statusChance;//likelihood to proc a status;
	
	private statuses status;//the status that is potentially caused by this item
	
	public boolean statusProc;
	
	private Random rand;
	private int chanceBuffer;
	

	
	//constructor
	public Item() {
		super();
		name = "";
		description = "";
		effect = 0;
		friendlyTargetable = true;
		duration = 0;//instantaneous
		statusChance = 0;
		chanceBuffer = 0;
		statusProc = false;
		status = new statuses();
		rand = new Random();
	}
	public Item(String name, int effect, boolean friendlyTargetable, int duration,
			int statusChance) {
		super(name, effect, 0, "", friendlyTargetable, -1, -1, 0);
		this.name = name;
		description = "";
		this.effect = effect;
		this.friendlyTargetable = friendlyTargetable;
		this.duration = duration;
		this.statusChance = statusChance;
		status = new statuses();
	}
	
	public void updateStatus(statuses status) {
		this.status = status;
	}
	public void updateDescription(String description) {
		this.description = description;
		super.setDescription(description);
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getEffect() {
		return effect;
	}
	public boolean friendlyTarget() {
		return friendlyTargetable;
	}
	public int getDuration() {
		return duration;
	}
	
	public void calculateStatus() {
		if (statusProc == false) {
			chanceBuffer = rand.nextInt(100);
			if (chanceBuffer <= statusChance) {
				statusProc = true;
			}
		}
	}
}