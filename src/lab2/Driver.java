package lab2;

import java.awt.Color;
import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;


public class Driver {

	Level level = new Level();
	
	public void run() {	
		//Alla rum skapas med sina egenskaper och placeras sedan ut med metoden place,
		// den testar om det nya rummet får plats på leveln och returnerar true om 
		// den får det och false annars.
		System.out.println(level.place(new Room(100, 50, Color.magenta), 5, 5));
		System.out.println(level.place(new Room(150, 70, Color.blue), 120, 5));
		System.out.println(level.place(new Room(80, 60, Color.cyan), 5, 105));
		System.out.println(level.place(new Room(100, 200, Color.gray), 120, 120));
		System.out.println(level.place(new Room(100, 150, Color.yellow), 230, 150));
		//Alla kopplingar mellan rummen görs nedan.
		//1
		level.getRoom(0).connectEastTo(level.getRoom(1));
		level.getRoom(0).connectWestTo(level.getRoom(1));
		level.getRoom(0).connectNorthTo(level.getRoom(4));
		level.getRoom(0).connectSouthTo(level.getRoom(2));
		//2
		level.getRoom(1).connectEastTo(level.getRoom(0));
		level.getRoom(1).connectWestTo(level.getRoom(0));
		level.getRoom(1).connectNorthTo(level.getRoom(2));
		level.getRoom(1).connectSouthTo(level.getRoom(4));
		//3
		level.getRoom(2).connectEastTo(level.getRoom(3));
		level.getRoom(2).connectWestTo(level.getRoom(1));
		level.getRoom(2).connectNorthTo(level.getRoom(0));
		//4
		level.getRoom(3).connectEastTo(level.getRoom(4));
		level.getRoom(3).connectWestTo(level.getRoom(2));
		//5
		level.getRoom(4).connectWestTo(level.getRoom(3));
		level.getRoom(4).connectNorthTo(level.getRoom(1));
		level.getRoom(4).connectSouthTo(level.getRoom(0));
		//Initieringarna som behövs för att starta leveln. Efter det reutneras 
		// metoden så att det inte ska gå att placera fler rum i leveln.
		level.firstLocation(level.getRoom(0));
		LevelGUI Lgui = new LevelGUI(this.level, "Laboration 2");
		return;
	}
}