
package lab2.level;

import java.awt.Color;


public class Room { 
	
	public Room(int dx, int dy, Color color) {
		//color.blue var ej statisk, blev då ett error. Men om man använde
		//Color.blue tyckte eclipse att den var statisk.
		Room RNorth = new Room(50, 50, Color.blue); 
	}

	public void connectNorthTo(Room r) {
		
	}
	public void connectEastTo(Room r) {
		
	}
	public void connectSouthTo(Room r) {
		
	}
	public void connectWestTo(Room r) {
		
	}
}
