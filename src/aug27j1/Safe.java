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
				if(Game.findItem("safepass")==null)
					Game.print("You reach for the safe, "
							+ "but remember you don't have the passcode.");
				else {
					Game.getLocation().addItem("notebook", new Notebook());
					opened = true;
					Game.print("You open the safe and find a notebook.");
				}
			}
		}
	
	@Override
	public void close() {
		if(Game.getLocation().getRname().equals("attic")) {
			if(closed) 
				Game.print("You already closed the safe silly!");
			else if(Game.findItem("password")==null)
				Game.print("You never opened the safe in the first place!");
			else {
				closed = true;
				Game.print("You close the safe.");
			}
		}
	}
}//end class
