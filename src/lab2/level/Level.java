
package lab2.level;

import java.util.Observable;
import java.util.Vector;

public class Level extends Observable {
	
	private Vector<Room> listRoom = new Vector<Room>();
	Room playerLocation;
	
	public boolean place(Room r, int x, int y) {
		r.cordx = x;
		r.cordy = y;
		
		if(listRoom.size() == 0){	//S�tter ut f�rsta rummet i leveln.
			listRoom.add(r);	
			return true;
		}
		//Loopar igenom alla rum och testar om n�got av de gamla rummen som finns i vektorn �r inom det nya
		// rummets koordinater. Den testar �ven om det nya rummet r�kar vara i ett av de gamla. Alla 
		// testningar g�rs genom metoden inside.
			for(int i=0; i < listRoom.size(); i++){ 
				if (inside(listRoom.get(i), x, y) || inside(listRoom.get(i), x+r.dimx, y+r.dimy)
						|| inside(listRoom.get(i), x+r.dimx, y) || inside(listRoom.get(i), x, y+r.dimy)
								|| inside(r, listRoom.get(i).cordx, listRoom.get(i).cordy)
								|| inside(r, listRoom.get(i).cordx+listRoom.get(i).dimx, listRoom.get(i).cordy)
								|| inside(r, listRoom.get(i).cordx, listRoom.get(i).cordy+listRoom.get(i).dimy)
								|| inside(r, listRoom.get(i).cordx+listRoom.get(i).dimx, listRoom.get(i).cordy+listRoom.get(i).dimy)){
					//Om n�got av de statements ovan uppfylls returneras false och det nya rummet s�tts inte ut.
					r.deleteRoom();
					return false;
				}
			}
			//Om det nya rummet inte inkr�ktar p� n�tt annat rum s� placeras det ut och returnerar true.
			listRoom.add(r);	
			return true;
	}
	private boolean inside(Room r, int x, int y){
		if(	//x �r koordinaten d�r vi vill placera ut det nya rummet inom leveln.
				(
				(x <= r.cordx + r.dimx) //�stra kanten testas
				&&
				(x >= r.cordx) //V�stra kanten 
				)
				&&	//samtidigt som den �r inom den �r inom den..
				(
				(y <= r.cordy + r.dimy)	//S�dra kanten
				&&
				(y >= r.cordy) //Norra kanten
				)
			)
			{
			return true;
		}
		else{
			return false;
		}
	}
	
	public Room getRoom(int nr){
		return listRoom.elementAt(nr);
	}
	
	public int numRooms(){
		return listRoom.size();
	}
	
	public void firstLocation(Room r) {
		this.playerLocation = r;
		}
	
	void changeRoom(String dir) {
		if(dir.equalsIgnoreCase("w")) {
			movePlayer(this.playerLocation.RNorth);
		}
		if(dir.equalsIgnoreCase("s")) {
			movePlayer(this.playerLocation.RSouth);
		}
		if(dir.equalsIgnoreCase("a")) {
			movePlayer(this.playerLocation.RWest);
		}
		if(dir.equalsIgnoreCase("d")) {
			movePlayer(this.playerLocation.REast);
		}
	}
	
	private void movePlayer(Room r) {
		this.playerLocation = r;
		this.setChanged();
		this.notifyObservers();
	}
}
