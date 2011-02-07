package lab2;

import java.awt.Color;
import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;


public class Driver {

	Level level = new Level();
	
	public void run() {		
		System.out.println(level.place(new Room(100, 50, Color.magenta), 0, 0));
		System.out.println(level.place(new Room(150, 70, Color.blue), 105, 0));
		System.out.println(level.place(new Room(75, 42, Color.cyan), 0, 105));
		level.place(new Room(100, 400, Color.gray), 0, 0);
		level.place(new Room(600, 400, Color.yellow), 0, 0);
		level.firstLocation(level.getRoom(0));
		LevelGUI Lgui = new LevelGUI(this.level, "test");
		return;
	}
}