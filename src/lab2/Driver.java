package lab2;

import java.awt.Color;
import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	Level level = new Level();
	
	public void run() {
		System.out.println(level.place(new Room(100, 100, Color.magenta), 0, 0));
		System.out.println(level.place(new Room(150, 400, Color.blue), 105, 0));
		System.out.println(level.place(new Room(300, 300, Color.cyan), 0, 405));
		level.place(new Room(100, 400, Color.gray), 0, 0);
		level.place(new Room(600, 400, Color.yellow), 0, 0);
		level.firstLocation();
		LevelGUI Lgui = new LevelGUI(this.level, "Laboration 2");
	}

}