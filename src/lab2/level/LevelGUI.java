package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LevelGUI implements Observer {

	private Level lv;
	private Display d;
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		this.lv.addObserver(this);
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		d = new Display(lv,640,480);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		d.repaint();
	}
	
	private class Display extends JPanel {
		
		private Level lv;
		public Display(Level fp, int x, int y) {
			this.lv=fp;
			
			addKeyListener(new Listener());
			
			setBackground(Color.lightGray);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i=0; i < this.lv.numRooms(); i++){
				drawRoom(g, this.lv.getRoom(i));
				drawConnections(g, this.lv.getRoom(i));
			}	
		}
		
		private void drawRoom(Graphics g, Room r) {
			g.setColor(r.Rcolor);
			g.fillRect(r.cordx, r.cordy,
					r.dimx, r.dimy);
	        if (lv.playerLokation==r) { 
	        	g.setColor(Color.red); }
	        else { 
	        	g.setColor(Color.black); 
	        } 
	        g.drawRect(r.cordx, r.cordy,
					r.dimx, r.dimy);
	        String name = Integer.toString(r.name);
	        g.drawString(name, r.cordx-2+r.dimx/2,r.cordy+r.dimy/2+5);
		}
		
		private void drawConnections(Graphics g, Room r){
			if(r.RNorth!=r){
				drawConNorth(g, r);
			}
			if(r.REast!=r){
				drawConEast(g, r);
			}
			if(r.RSouth!=r){
				drawConSouth(g, r);
			}
			if(r.RWest!=r){
				drawConWest(g, r);
			}
		}
		
		private void drawConNorth(Graphics g, Room r){
			g.setColor(Color.BLACK);
			String str = Integer.toString(r.RNorth.name); 
			g.drawString(str, r.cordx-2 + r.dimx/2, r.cordy + 13);
		}
		
		private void drawConSouth(Graphics g, Room r){
			g.setColor(Color.BLACK);
			String str = Integer.toString(r.RSouth.name); 
			g.drawString(str, r.cordx - 2 + r.dimx/2, r.cordy + r.dimy-3);
		}
		
		private void drawConWest(Graphics g, Room r){
			g.setColor(Color.BLACK);
			String str = Integer.toString(r.RWest.name); 
			g.drawString(str, r.cordx + 3, r.cordy + r.dimy/2+5);
		}
		
		private void drawConEast(Graphics g, Room r){
			g.setColor(Color.BLACK);
			String str = Integer.toString(r.REast.name);
			g.drawString(str, r.cordx + r.dimx - 9, r.cordy + r.dimy/2+5);
		}
		

	 	private class Listener implements KeyListener {

	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 			lv.changeRoom(Character.toString(event.getKeyChar()));
	 		}
	 	}

	}
}
