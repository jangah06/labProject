package aug27j1;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class NPC implements Serializable{
private String name;
	public NPC(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void say(String s) {
		Game.print(name.toUpperCase()+"\n"+s);
	}
	
	public void talk() {
		Game.print("You can't talk to them.");
	}
	
	public int getResponse(String[] s) {
		for(int i=0;i<s.length;i++) {
			Game.print((i+1)+") "+s[i]);
		}
		String input = JOptionPane.showInputDialog(null, "Dialogue Option: ");
		int num = Integer.parseInt(input);
		return num;
	}

}//end NPC
