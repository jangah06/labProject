package aug27j1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class Room implements Serializable{
	private String roomName;
	private Room directions[];
	private HashMap<String, Item> items;
	public static ArrayList<Room> saverooms= new ArrayList<>();
	private boolean locked;
	
	public Room(String rN, String rD) {
		roomName = rN;
		directions = new Room[6];
		items = new HashMap<>();
		saverooms.add(this);
		locked = false;
		}
	// Get Methods
	public String getRname() {
		return roomName;
	}

	public String getRdesc(String rN) {
		return Game.rooms.get(rN);
	}
	
	public Room getExit(int a){
		return directions[a];
	}
	
	public boolean getLocked() {
		return locked;
	}
	// Set Methods
	public void setroomName(String rN) {
		roomName = rN;
	}

	public void setroomDesc(String rN, String rD) {
		Game.rooms.put(rN,rD);
	}
	// Add Method
	public void addExit(Room r, int a) {
		directions[a] = r;
	}
	// String method
	public String toString() {
		String s = roomName + "\n" + Game.rooms.get(roomName);
		return s;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	//For item class
	public void addItem(String iN, Item i) {
		items.put(iN, i);
	}
	public Item getItem(String i) {
		return items.get(i);
	}
	
	public void removeItem(String i) {
		items.remove(i);
	}
}// end all
