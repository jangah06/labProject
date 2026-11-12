package aug27j1;

public class Larry extends NPC{
	public Larry() {
		super("larry");
	}

	@Override
	public void talk() {
		say("Hello! I'm the talking cat Larry!");
		String[] s = {
			"Why are you able to talk?",
			"Do you know how to get to the garage?",
			"You're one ugly animal!"
		};//end array
		int option = getResponse(s);
		switch(option) {
			case 1:
				say("Because I was born to shine baby!");
				break;
			case 2:
				say("No, but I heard there's a notebook somewhere with a special password.");
				break;
			case 3:
				say("What the heck man!");
				break;
			default:
				say("Come again?");
		}
	}
	
}//end Larry
