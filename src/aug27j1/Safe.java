package aug27j1;

public class Safe extends Item {
	private boolean opened;
	private boolean closed;

	public Safe() {
		super("safe");
		opened = false;
		closed = false;
	}
	
	@Override
	public void open() {
		
			if(opened) {
				Game.print("You open the safe, but find nothing inside.");
			}
			else if(!opened) {
				Game.getLocation().addItem("notebook", new Notebook());
				opened = true;
				Game.print("You open the safe and find a notebook.");
			}
		}
	
	@Override
	public void close() {
		if(Game.getLocation().getRname().equals("attic")) {
			if(closed) {
				Game.print("You already closed the safe silly!");
			}
			else {
				closed = true;
				Game.print("You close the safe.");
			}
		}
		else {
			Game.print("There is no safe to close here!");
		}
	}
	
}//end class
