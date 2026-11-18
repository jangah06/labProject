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
		String[] s = { "Why are you able to talk?", "Do you know how to get to the garage?",
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
		String[] s = { "But you're just a common house cat!", "Wow, you're really, truly amazing!", "Shush it." };// end
																													// array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("I'm that and so much more you fool!");
			convoNumber = 4;
			break;
		case 2:
			say("Why thank you human!");
			convoNumber = 5;
			break;
		case 3:
			say("*Hiss*");
			convoNumber = 6;
			break;
		default:
			say("Come again?");
		}
	}

	public void talk2() {
		say("What do you want now?");
		String[] s = { "Are there any other secrets I should know about?", "Wow, you're really, truly amazing!",
				"Shush it." };// end array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("I'm that and so much more you fool!");
			convoNumber = 7;
			break;
		case 2:
			say("Why thank you human!");
			convoNumber = 8;
			break;
		case 3:
			say("*Hiss*");
			convoNumber = 9;
			break;
		default:
			say("Come again?");
		}
	}

	public void talk3() {
		say("What do you want now?");
		String[] s = { "Are there any other secrets I should know about?", "Wow, you're really, truly amazing!",
				"Shush it." };// end array

		int option = getResponse(s);

		switch (option) {
		case 1:
			say("I'm that and so much more you fool!");
			convoNumber = 10;
			break;
		case 2:
			say("Why thank you human!");
			convoNumber = 11;
			break;
		case 3:
			say("*Hiss*");
			convoNumber = 12;
			break;
		default:
			say("Come again?");
		}
	}

	public void talkfinal() {
		switch (convoNumber) {
		case 4:
			say("I'm that and so much more you fool!");
			break;
		case 5:
			say("Why thank you human!");
			break;
		case 6:
			say("*Hiss*");
			break;
		case 7:
			say("I'm that and so much more you fool!");
			break;
		case 8:
			say("Why thank you human!");
			break;
		case 9:
			say("*Hiss*");
			break;
		case 10:
			say("I'm that and so much more you fool!");
			break;
		case 11:
			say("Why thank you human!");
			break;
		case 12:
			say("*Hiss*");
			break;
		default:
			say("Come again?");
		}
	}

}// end Larry
