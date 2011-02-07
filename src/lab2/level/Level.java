
package lab2.level;

import java.util.Observable;
import java.util.Vector;

public class Level extends Observable {
	
	Vector<Room> listRoom = new Vector<Room>();
	
	public boolean place(Room r, int x, int y)  {  //Ändra tillbaka void till boolean när denna ska användas.
		r.cordx = x;
		r.cordy = y;
		
		if(listRoom.size() == 0){	//Sätter ut första rummet
			listRoom.add(r);	
			r.cordx = x;
			r.cordy = y;
			return true;
		}
		//Room foo = listRoom.get(0);
		
			for(int i=0; i < listRoom.size(); i++){ //lopar igenom alla rum
				if (inside(listRoom.get(i), x, y) || inside(listRoom.get(i), x+r.dimx, y+r.dimy)
						|| inside(listRoom.get(i), x+r.dimx, y) || inside(listRoom.get(i), x, y+r.dimy)
								|| inside(r, listRoom.get(i).cordx, listRoom.get(i).cordy)){
					//med andra ord om den befinner sig inuti ett annat rum så returneras false
					return false;
				}
			}
			//Om det nya rummet inte inkräktar på nått annat rum så placeras det ut
			listRoom.add(r);	
			r.cordx = x;
			r.cordy = y;
			return true;
	}
	
	public Room getroom(int nr){
		return listRoom.elementAt(nr);
	}
		
		/**Create a Vector with an initial size 
		* Vector v = new Vector(300);
		* To Add elements to the end of a Vector
		* v.add(s); // adds s to the end of the Vector v
		*/
	
	
	public void firstLocation(Room r) {
			
	}
	
	private boolean inside(Room r, int x, int y){
		if(	//om x kordinaten där vi vill placera ut det nya rummet inom den..
				(
				(x <= r.cordx + r.dimx) //östra kanten och..
				&&
				(x >= r.cordx) //den västra kanten.. 
				)
				&&	//samtidigt som den är inom den år inom den..
				(
				(y <= r.cordy + r.dimy)	//södra kanten och..
				&&
				(y >= r.cordy) //den nordliga kanten på ett annat rumm
				)
			)
			{
			return true;
		}
		else{
			return false;
		}
	}
	
	private int eastWall(int index){
		return listRoom.get(index).cordx + listRoom.get(index).dimx;
	}
	
	private int westWall(int index){
		return listRoom.get(index).cordx;
	}
	
	private int northWall(int index){
		return listRoom.get(index).cordy;
	}
	
	private int southWall(int index){
		return listRoom.get(index).cordy + listRoom.get(index).dimy;
	}
	
}
