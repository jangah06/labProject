package aug27j1;

public class Notebook extends Item{
	private boolean read;
	public Notebook() {
		super("notebook");
		read = false;
	}

	@Override
	public void read() {
		if(read) {
			Game.print("You read the notebook, but find no new information.");
		}
		else {
			Game.items.add(new Item("password"));
			read = true;
			Game.print("You read the notebook and find the password to something.");
		}
	}//end read
}//end class
