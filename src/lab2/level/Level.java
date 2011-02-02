
package lab2.level;

import java.util.Observable;
import java.util.Vector;

public class Level extends Observable {
	
	Vector<Room> listRoom = new Vector<Room>();
	
	public boolean place(Room r, int x, int y)  {  //�ndra tillbaka void till boolean n�r denna ska anv�ndas.
		
		if(listRoom.size()==0){	//S�tter ut f�rsta rummet
			listRoom.add(r);	
			r.cordx = x;
			r.cordy = y;
			return true;
		}
		//Room foo = listRoom.get(0);

			for(int index=0; index<listRoom.size(); index++){ //lopar igenom alla rum
				if (
						(	//om x kordinaten d�r vi vill placera ut det nya rummet inom den..
						(x<(listRoom.get(index).cordx + listRoom.get(index).dimx)) //�stra kanten och..
						&&
						(x>listRoom.get(index).cordx) //den v�stra kanten.. 
						)
						&&	//samtidigt som den �r inom den �r inom den..
						(
						(y<(listRoom.get(index).cordy + listRoom.get(index).dimy))	//s�dra kanten och..
						&&
						(y>listRoom.get(index).cordy) //den nordliga kanten p� ett annat rumm
						)
					){//med andra ord om den befinner sig inuti ett annat rum s� returneras false
					return false;
				}
			}
			//Om det nya rummet inte inkr�ktar p� n�tt annat rum s� placeras det ut
			listRoom.add(r);	
			r.cordx = x;
			r.cordy = y;
			return true;
		}
		
		/**Create a Vector with an initial size 
		* Vector v = new Vector(300);
		* To Add elements to the end of a Vector
		* v.add(s); // adds s to the end of the Vector v
		*/
	
	
	public void firstLocation(Room r) {
			
	}
	
}
