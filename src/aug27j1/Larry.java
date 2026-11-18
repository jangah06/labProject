package aug27j1;

public class Larry extends NPC {
	int convoNumber = 0;

	public Larry() {
		super("larry");
	}

	@Override
	public void talk() {
		switch (convoNumber) {
		case 0:
			talk0();
			break;
		case 1:
			talk1();
			break;
		case 2:
			talk2();
			break;
		case 3:
			talk3();
			break;
		default:
			talkfinal();
		}
	}

	public void talk0() {
		say("Hello! I'm the talking cat Larry!");
		String[] s = { "Why are you able to talk?", 
				"Do you know how to get to the garage?",
				"You're one ugly animal!" };// end array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("Because I was born to shine baby!");
			convoNumber = 1;
			break;
		case 2:
			say("No, but I heard there's a notebook somewhere with a special password.");
			convoNumber = 2;
			break;
		case 3:
			say("What the heck man!");
			convoNumber = 3;
			break;
		default:
			say("Come again?");
		}
	}

	public void talk1() {
		say("I'm a rockstar!");
		String[] s = { "But you're just a common house cat!", 
				"Wow, you're really, truly amazing!", 
				"Shush it." };// end array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("I'm that and so much more you fool!");
			convoNumber = 11;
			break;
		case 2:
			say("Why thank you human!");
			convoNumber = 12;
			break;
		case 3:
			say("*Hiss*");
			convoNumber = 13;
			break;
		default:
			say("Come again?");
		}
	}

	public void talk2() {
		say("What do you want now?");
		String[] s = { "Are there any other secrets I should know about?", 
				"Do you want a treat?",
				"Meow" };// end array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("I'll have to think about that.");
			convoNumber = 21;
			break;
		case 2:
			say("Yes *meow*!");
			convoNumber = 22;
			break;
		case 3:
			say("Are you mocking me?");
			convoNumber = 23;
			break;
		default:
			say("Come again?");
		}
	}

	public void talk3() {
		say("Why were you so rude to me?");
		String[] s = { "Sorry it was a joke.", 
				"Sorry I just couldn't help but point out the obvious!",
				"Why you gotta be so rude? Don't you know I'm human too? "
				+ "I'm gonna marry her anyway (marry that girl)." };// end array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("You're stupid, joking!");
			convoNumber = 31;
			break;
		case 2:
			say("I was gonna tell you a little extra info about the garage, "
					+ "but I've changed my mind!");
			convoNumber = 32;
			break;
		case 3:
			say("I haven't heard that song in a while.");
			convoNumber = 33;
			break;
		default:
			say("Come again?");
		}
	}

	public void talkfinal() {
		switch (convoNumber) {
		case 11:
			say("Foolish human!");
			break;
		case 12:
			say("Give me more and more praise *meow*!");
			break;
		case 13:
			say("Get away from me!");
			break;
		case 21:
			say("I'm still thinking...");
			break;
		case 22:
			say("Wnere are the treats at?");
			break;
		case 23:
			say("I'm a human and I go 'bleh'.");
			break;
		case 31:
			say("Hahahaha");
			break;
		case 32:
			say("Get lost stupid!");
			break;
		case 33:
			say("I've had enough of your singing for today.");
			break;
		}
	}

}// end Larry
