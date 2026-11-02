package aug27j1;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Game {
	private static Room location = World.buildWorld();
	private static ArrayList<Item> items = new ArrayList<>();
	public static HashMap<String, String> rooms = new HashMap<>();
	private static Interface gameInterface;

	
	public static void runGameGUI(String com) {
		// Clean up the player's command
		com = com.toLowerCase().trim();
		com = com.replaceAll("\\b(the|to)\\b", "");
		com = com.replaceAll("\\s+", " ").trim();
		if (com.isEmpty()) {
			return;
		}
		String[] cmd = com.split(" ");
		String command = cmd[0];

		
		switch (command) {
		case "i":
			print("Your items: " + items);
			break;
		case "take":
			if (cmd.length < 2) {print("Take what?");} 
			else {takeItem(cmd[1]);}
			break;
		case "go":
			if (cmd.length < 2) {print("Go where?");}
			else {move(cmd[1]);}
			break;
		case "save":
			print("Saving game");
			saveFile();
			break;
		case "load":
			print("Loading previous save");
			loadFile();
			break;
		case "exit":
			print("Goodbye!");
			break;
		case "c":
			print("c - lists the game's commands");
			print("i - shows inventory");
			print("take ___ - checks if item is in room and available to be picked up");
			print("go ___ - goes east,west,north,south,up, or down");
			print("use ___ - checks if you own the item, and then uses it");
			print("save - saves your game");
			print("loads - loads your previously saved game");
			print("exit - exits the game");
			break;
		case"use":
			if (cmd.length < 2) {print("Use what?");}
			else {useItem(cmd[1]);}
			break;
		default:
			print("Error: Not a valid command!");
			break;
		}
	}//end runGameGUI

	
	//Checks the direction you're going 
	public static void move(String d) {
		switch (d) {
		case "east":
			if (location.getExit(0) == null) print("No Room");
			else if (location.getExit(0).getLocked()) print("This room is locked!");
			else location = location.getExit(0);
			break;
		case "west":
			if (location.getExit(1) == null) print("No Room");
			else if (location.getExit(1).getLocked()) print("This room is locked!");
			else location = location.getExit(1);
			break;
		case "north":
			if (location.getExit(2) == null) print("No Room");
			else if (location.getExit(2).getLocked()) print("This room is locked!");
			else location = location.getExit(2);
			break;
		case "south":
			if (location.getExit(3) == null) print("No Room");
			else if (location.getExit(3).getLocked()) print("This room is locked!");
			else location = location.getExit(3);
			break;
		case "up":
			if (location.getExit(4) == null) print("No Room");
			else if (location.getExit(4).getLocked()) print("This room is locked!");
			else location = location.getExit(4);
			break;
		case "down":
			if (location.getExit(5) == null) print("No Room");
			else if (location.getExit(5).getLocked()) print("This room is locked!");
			else location = location.getExit(5);
			break;
		default:
			Game.print("Error: Not a valid direction!");
		}
	}// end move

	
	// Checks the Item you're taking
	public static void takeItem(String i) {
		if (location.getItem(i) == null) {
			print("Error: No " + i + " in this room!");
		}

		else if (location.getItem(i).getCarry() == false) {
			print("Error: This item is too heavy to carry!");
		}

		else {
			items.add(location.getItem(i));
			print("You took: " + i);
			location.removeItem(i);
		}
	}// end takeItem
	
	//Check if you can use an item
	public static void useItem(String i) {
		boolean has = false;
		for(Item item:items){
			if(item.getItemName().equals(i)){
				has = true;
				item.use();
				break;
			}
		}
		if(!has)
			print("You don't have the "+i+"!");
	}

	
	// Reads room and description from text file
	public static void readRooms() {
		try {
			Scanner fileScan = new Scanner(new File("descriptions.txt"));
			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				String rN = line;
				String rD = "";
				line = fileScan.nextLine();
				while (!line.equals("#")) {
					rD += line + " ";
					line = fileScan.nextLine();
				}
				rooms.put(rN, rD);
			}
			fileScan.close();
		} catch (Exception ex) { // File not found exception
			ex.printStackTrace();
		}
	}//end readRooms
	
	
	//Save file Method
	public static void saveFile() {
		try {
			File saveFile = new File("saveFile.txt");
			saveFile.createNewFile(); // creates a new file
			ObjectOutputStream outStream = new ObjectOutputStream(new
			FileOutputStream(saveFile));
			outStream.writeObject(location);
			outStream.writeObject(items);
			outStream.writeObject(rooms);
			outStream.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}//end saveFile
	
	
	//Load file Method
	public static void loadFile() {
		try {
			File saveFile = new File("saveFile.txt");
			ObjectInputStream inStream = new ObjectInputStream(new
			FileInputStream(saveFile));
			location = (Room) inStream.readObject();
			items = (ArrayList<Item>) inStream.readObject();
			Room.saverooms = (ArrayList<Room>) inStream.readObject();
			inStream.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}//end loadFile
	

	//Print for Game class 
	public static void print(Object s) {
		if (gameInterface != null) {
			gameInterface.showMessage(String.valueOf(s));
		} else {
			System.out.println(s);
		}
	}//end print
	
	
	public static void setInterface(Interface gui) {
		gameInterface = gui;
	}
	public static Room getLocation() {
		return location;
	}

	
	//Main 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			readRooms();
			new Interface();
		});
	}
}// end all
