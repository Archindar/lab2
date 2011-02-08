
package lab2.level;

import java.util.Observable;
import java.util.Vector;

public class Level extends Observable {
	
	private Vector<Room> listRoom = new Vector<Room>();
	
	public boolean place(Room r, int x, int y) {
		r.cordx = x;
		r.cordy = y;
		
		if(listRoom.size() == 0){	//Sätter ut första rummet
			listRoom.add(r);	
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
			return true;
	}
	
	public Room getRoom(int nr){
		return listRoom.elementAt(nr);
	}
	
	public int numRooms(){
		return listRoom.size();
	}
	
	public void firstLocation(Room r) {
		r.player = true;
		}
	
	void changeRoom(Room r) {
		for (int i=0; i < this.numRooms(); i++){
			getRoom(i).player = false;
		}
		r.player = true;	
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
	
	
	
//	private int right(int index){
//		return listRoom.get(index).cordx + listRoom.get(index).dimx;
//	}
//	
//	private int left(int index){
//		return listRoom.get(index).cordx;
//	}
//	
//	private int top(int index){
//		return listRoom.get(index).cordy;
//	}
//	
//	private int bottom(int index){
//		return listRoom.get(index).cordy + listRoom.get(index).dimy;
//	}
	
}
