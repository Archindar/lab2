
package lab2.level;

import java.util.Observable;
import java.util.Vector;

public class Level extends Observable {
	
	Vector<Room> listRoom = new Vector<Room>();
	
	public boolean place(Room r, int x, int y)  {  //�ndra tillbaka void till boolean n�r denna ska anv�ndas.
		r.cordx = x;
		r.cordy = y;
		
		if(listRoom.size() == 0){	//S�tter ut f�rsta rummet
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
					//med andra ord om den befinner sig inuti ett annat rum s� returneras false
					return false;
				}
			}
			//Om det nya rummet inte inkr�ktar p� n�tt annat rum s� placeras det ut
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
		if(	//om x kordinaten d�r vi vill placera ut det nya rummet inom den..
				(
				(x <= r.cordx + r.dimx) //�stra kanten och..
				&&
				(x >= r.cordx) //den v�stra kanten.. 
				)
				&&	//samtidigt som den �r inom den �r inom den..
				(
				(y <= r.cordy + r.dimy)	//s�dra kanten och..
				&&
				(y >= r.cordy) //den nordliga kanten p� ett annat rumm
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
