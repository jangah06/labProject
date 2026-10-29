package aug27j1;

public class World {
	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room", "This is a small living room with a couch and coffee table.");
		Room office = new Room("Office", "This is where you do all your work.");
		Room kitchen = new Room("Kitchen", "This is where you make food (can I have some?).");
		Room bedroom = new Room("Bedroom", "This is the place where you go to sleep :).");
		Room attic = new Room("Attic", "This is the place where you store your unwanted items.");
		Room garage = new Room("Garage", "This is where you park your car and have random items.");
		
		//Exits
		livingRoom.addExit(office, 1);
		livingRoom.addExit(kitchen, 0);
		livingRoom.addExit(bedroom, 2);
		
		office.addExit(livingRoom,0);//east
		
		kitchen.addExit(livingRoom, 1);//west
		kitchen.addExit(garage, 3);
		
		bedroom.addExit(attic, 4); // 4=up
		bedroom.addExit(livingRoom, 3); // 3=south
		
		attic.addExit(bedroom, 5);//down
		
		garage.addExit(kitchen, 2);//north
		
		//Items
		bedroom.addItem("officekey", new OfficeKey());
		livingRoom.addItem("tool", new Tool());
		livingRoom.addItem("musicbox", new Item("musicbox"));
		kitchen.addItem("knife", new Item("knife"));
		kitchen.addItem("mysteriousorb", new Item("mysteriousorb"));
		Item couch = new Item("couch");
		couch.setCarry(false);
		livingRoom.addItem("couch", couch);
		
		//Locked Rooms
		office.setLocked(true);
		attic.setLocked(true);
		garage.setLocked(true);
		return livingRoom;
	}
}// end all
