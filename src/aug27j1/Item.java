package aug27j1;
import java.io.Serializable;

public class Item implements Serializable{
	private String itemName;
	private boolean canCarry;
	
	public Item(String iN) {
		itemName = iN;
		canCarry = true;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String iN) {
		itemName = iN;
	}
	public String toString() {
		return itemName;
	}
	
	public void setCarry(boolean b) {
		canCarry = b;
	}
	
	public boolean getCarry() {
		return canCarry;
	}
	
	public void use() {
		Game.print("You cannot use this item!");
	}
}
