package lab2.level;

import java.awt.Color;


public class Room {
	
	Room RNorth;
	Room RSouth;
	Room RWest;
	Room REast;
	Color Rcolor;
	
	int dimx;
	int dimy;
	int screenx;
	int screeny;
	
	public Room(int dx, int dy, Color color) {
		this.Rcolor = color;
		this.dimx = dx;
		this.dimy = dy;

		
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
