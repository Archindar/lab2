package lab2.level;

import java.awt.Color;


public class Room {
	int name;
	Room RNorth = null;
	Room RSouth = null;
	Room RWest = null;
	Room REast = null;
	Color Rcolor;
	int dimx;
	int dimy;
	int cordx;
	int cordy;
	boolean player = false;
	
	private static int numberofrooms=0;

	public Room(int dx, int dy, Color color) {
		this.Rcolor = color;
		this.dimx = dx;
		this.dimy = dy;
		numberofrooms=numberofrooms+1;
		this.name=numberofrooms;
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
