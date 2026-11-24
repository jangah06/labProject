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
				Game.print("You already opened the safe silly!");
			}
			else if(!opened) {
				if(Game.findItem("safepass")==null)
					Game.print("You reach for the safe, "
							+ "but remember you don't have the passcode.");
				else if(Game.findItem("notebook")==null){
					Game.getLocation().addItem("notebook", new Notebook());
					opened = true;
					closed = false;
					Game.print("You open the safe and find a notebook.");
				}
				else
					Game.print("You open the safe, but find nothing inside.");
					opened = true;
					closed = false;
			}
		}
	
	@Override
	public void close() {
		if(closed) 
			Game.print("You already closed the safe silly!");
		else if(!closed) {
			if(Game.findItem("notebook")==null)
				Game.print("You never opened the safe in the first place!");
			else {
				closed = true;
				opened = false;
				Game.print("You close the safe.");
			}
		}	
	}
}//end class
