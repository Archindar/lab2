package lab2.level;

import java.awt.Color;


public class Room {
	
	Room RNorth;
	Room RSouth;
	Room RWest;
	Room REast;
	
	public Room(int dx, int dy, Color color) {

	}

	public void connectNorthTo(Room r) {
		this.RNorth = r;
	}
	public void connectEastTo(Room r) {
		this.REast = r;
	}
	public void connectSouthTo(Room r) {
		this.RSouth = r;
	}
	public void connectWestTo(Room r) {
		this.RWest = r;
	}
}
