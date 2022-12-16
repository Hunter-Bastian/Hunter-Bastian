public class statuses{
	private boolean[] statusList = new boolean[4]; //Indicates whether the entity has a specific status effect.
	private String[] statusNames = {"Burn", "Paralysis", "Poison", "Freeze"}; //Status effect labels
	private int[] statusDurations = {0,0,0,0}; //Duration of status in turns
	private boolean freezeActed = false; //Prevents a double deduction of strength and magic within the freeze status effect
	public statuses(){ //default constructor
		statusList[0] = false;
		statusList[1] = false;
		statusList[2] = false;
		statusList[3] = false;
	}
	public statuses(boolean Stat1, boolean Stat2, boolean Stat3, boolean Stat4){ //parameterized constructor
		statusList[0] = Stat1;
		statusList[1] = Stat2;
		statusList[2] = Stat3;
		statusList[3] = Stat4;
		for(int i = 0; i < 4; i++){
			if(statusList[i] = true){
				statusDurations[i] = 2;
			}
		}
	}
	//Accessors and Mutators
	public boolean GetStatus(int location){
		return statusList[location];
	}
	public void SetStatus(int location, int duration, boolean newStatus){
		statusList[location] = newStatus;
		if(newStatus = true){
			statusDurations[location] = duration;
		}
	}
	public String GetStatusName(int location){
		return statusNames[location];
	}
	public int GetDuration(int location){
		return statusDurations[location];
	}
	//To String
	public String ToString(){
		String outputString = "";
		for(int i = 0; i < 4; i++){
			if(statusList[i] == true){
				outputString.concat("The User has ");
				outputString.concat(GetStatusName(i));
				outputString.concat("\n");
			}
		}
		return outputString;
	}
	//Deducts status duration, and sets status to false if the status has run its course
	private void statusTicker(int location){
		statusDurations[location]--;
			if(statusDurations[location] <= 0){
				statusDurations[location] = 0;
				statusList[location] = false;
			}
	}
	//all the status effects ingame
	public void Burn(actor inputActor){
		if(statusList[0] == true){
			inputActor.setHealth(inputActor.getHealth()-1);
			statusTicker(0);
		}
	}
	public void Paralysis(actor inputActor){
		if(statusList[1] == true){
			inputActor.setInitiative(inputActor.getInitiative()-1);
			statusTicker(1);
		}
	}
	public void Poison(actor inputActor){
		if(statusList[2] == true){
			inputActor.setHealth(inputActor.getHealth()*(19/20));
			statusTicker(2);
		}
	}
	public void Freeze(actor inputActor){
		if(statusList[3] == true){
			inputActor.setInitiative(inputActor.getInitiative()-2);
			if(freezeActed == false){ //deducts freeze for the first time, will not be called if freeze has already done this
				inputActor.setStrength(inputActor.getStrength()*(3/4));
				inputActor.setMagic(inputActor.getMagic()*(3/4));
				freezeActed = true;
			}
			statusTicker(3);
			if(statusList[3] == true){ //retroactively returns the initial strength and magic stats
				freezeActed = false;
				inputActor.setStrength(inputActor.getStrength()*(4/3));
				inputActor.setMagic(inputActor.getMagic()*(4/3));
			}
		}
	}
	//runs through all the status effects, triggering if true.
	public void StatusRun(actor inputActor){
		Burn(inputActor);
		Paralysis(inputActor);
		Poison(inputActor);
		Freeze(inputActor);
	}
}

