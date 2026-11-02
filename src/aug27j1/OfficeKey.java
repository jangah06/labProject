package aug27j1;

public class OfficeKey extends Item {
	//private boolean usedKey;

	public OfficeKey() {
		super("OfficeKey");
		//usedKey = false;
	}

	@Override
	public void use() {
		if (Game.getLocation().getRname().equals("Living Room")) {
			if (!Game.getLocation().getExit(1).getLocked()) {
				Game.print("The office door is already unlocked!");
			} else {
				Game.getLocation().getExit(1).setLocked(false);
				//usedKey = true;
				Game.print("The office door makes a creaking sound and a dusty "
						+ "scent fills your nostrils");
			}
		} else
			Game.print("The Office Key doesn't seem to work for this.");
	}
}
