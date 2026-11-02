package aug27j1;

public class Flashlight extends Item{
	private boolean foundKey;
	public Flashlight() {
		super("flashlight");
		foundKey = false;
	}
	
	@Override
	public void use() {
		if(Game.getLocation().getRname().equals("Bedroom")) {
			if(foundKey) {
				Game.print("Nothing interesting here.");
			}
			else {
				Game.print("You see a key lying on the floot");
				Game.getLocation().addItem("officekey", new OfficeKey());
			}
			
		}
		else {
			Game.print("");
		}
	}
}
