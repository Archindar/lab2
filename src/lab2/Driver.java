package lab2;

import java.awt.Color;
import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;


public class Driver {

	public void run() {
		//System.out.print("This is a print-out from the driver.");
		Room R1 = new Room(200, 400, Color.blue);
		Room R2 = new Room(300, 300, Color.cyan);
		Room R3 = new Room(100, 400, Color.gray);
		Room R4 = new Room(600, 400, Color.yellow);
		Room R5 = new Room(400, 100, Color.magenta);
		
		R1.connectEastTo(R3);
		R1.connectNorthTo(R2);
		R1.connectWestTo(R5);
		R1.connectSouthTo(R4);
		R2.connectEastTo(R3);
		R2.connectNorthTo(R1);
		R2.connectWestTo(R4);
		R2.connectSouthTo(R1);
		R3.connectEastTo(R5);
		R3.connectNorthTo(R1);
		R3.connectWestTo(R2);
		R3.connectSouthTo(R4);
		R4.connectEastTo(R5);
		R4.connectNorthTo(R2);
		R4.connectWestTo(R3);
		R4.connectSouthTo(R1);
		R5.connectEastTo(R2);
		R5.connectNorthTo(R2);
		R5.connectWestTo(R5);
		R5.connectSouthTo(R2);
		
		
	}

}