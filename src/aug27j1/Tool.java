package aug27j1;

public class Tool extends Item {
	//private boolean usedTool;

	public Tool() {
		super("tool");
		//usedTool = false;
	}

	@Override
	public void use() {
		if (Game.getLocation().getRname().equals("Bedroom")) {
			if (!Game.getLocation().getLocked()) {
				Game.print("The attic door is already open!");
			} else {
				Game.getLocation().getExit(4).setLocked(false);
				//usedTool = true;
				Game.print("The attic door finally budged, and a ladder fell down for you to use!");
			}
		} else
			Game.print("Are you crazy? You can't use the tool here!");
	}
}
