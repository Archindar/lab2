
package lab2.level;

import java.util.Observable;
import java.util.Vector;

public class Level extends Observable {
	
	
	public boolean place(Room r, int x, int y)  { 
		int xtot;
		int ytot;
		
		/**Create a Vector with an initial size 
		* Vector v = new Vector(300);
		* To Add elements to the end of a Vector
		* v.add(s); // adds s to the end of the Vector v
		*/
		
		if ((xtot < x) && (ytot < y)) {
			return true;
		else {
			return false;
			}
		}
			
		}
	}
	
	public void firstLocation(Room r) {
			
	}
	
}
