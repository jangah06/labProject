package aug27j1;

public class Brother extends NPC{
	
	int convoNumber = 0;
	public Brother() {
		super("brother");
	}
	
	@Override
	public void give(Item i) {
		if(!i.getItemName().equals("$20.50"))
			say("What?! That's not what I asked for!");
		
		else if(convoNumber!=1) {
			Game.items.remove(i);
			say("Thanks I guess??");
			convoNumber = 11;
		}
			
		else {
			Game.items.add(new Item("safepass"));
			Game.items.remove(i);
			say("Thanks for the free cash (heheh)! Here, the password's all yours.");
			convoNumber = 11;
		}
	}
	
	public void talk() {
		switch(convoNumber) {
		case 0:
			talk0();
			break;
		default:
			talkfinal();
			break;
		}
	}
	
	public void talk0() {
		say("Yeah what dya want?!");
		String[] s = { "Do you know the combination to the safe?", 
				"Why are you in here?",
				"Nevermind. I shouldn't have come here..." };// end array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("No, but for $20.50 I will!");
			convoNumber = 1;
			break;
		case 2:
			say("I just wanted a little late night snack. "
					+ "Is there something wrong with that?");
			convoNumber = 2;
			break;
		case 3:
			say("Uhh ok.");
			convoNumber = 3;
			break;
		default:
			say("Whaa?");
		}
	}
	
	public void talkfinal() {
		switch (convoNumber) {
		case 1:
			say("Yeah, where's my money at?!");
			break;
		case 2:
			say("I'm not giving you anything. Get you own food!");
			break;
		case 3:
			say("Are you good?");
			break;
		case 11:
			say("Ya got anymore money you wanna give to me?");
			break;
		}
	}

}//end all
