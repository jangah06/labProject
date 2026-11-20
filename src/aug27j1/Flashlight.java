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
				Game.print("You see a your dad's officekey "
						+ "mysteriously lying on the floor. On your dresser"
						+ " you see the $20.50 you planned to use to buy"
						+ " a game for your Xbox.");
				Game.getLocation().addItem("officekey", new OfficeKey());
				Game.getLocation().addItem("$20.50", new Item("$20.50"));
				foundKey = true;
			}
			
		}
		else {
			Game.print("You turn the flashlight on and off for fun.");
		}
	}
}
