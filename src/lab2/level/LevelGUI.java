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
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
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
				drawRoom(g, i);
				drawConnections(g, this.lv.getRoom(i));
			}	
		}
		
		private void drawRoom(Graphics g, int i) {
			g.setColor(this.lv.getRoom(i).Rcolor);
			g.fillRect(this.lv.getRoom(i).cordx, this.lv.getRoom(i).cordy,
					this.lv.getRoom(i).dimx, this.lv.getRoom(i).dimy);
	        if (this.lv.getRoom(i).player == true) { 
	        	g.setColor(Color.red); }
	        else { 
	        	g.setColor(Color.black); 
	        } 
	        g.drawRect(this.lv.getRoom(i).cordx, this.lv.getRoom(i).cordy,
					this.lv.getRoom(i).dimx, this.lv.getRoom(i).dimy);
		}
		
		private void drawConnections(Graphics g, Room r){
			
		}
		
		private void drawConNorth(Graphics g, Room r){
			g.setColor(Color.BLACK);
			String str = "3"; //ska vara numret på det rum som kopplingen går till
			g.drawString(str, r.cordx + r.dimx/2, r.cordy+10);
		}
		

	 	private class Listener implements KeyListener {

	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 		}
	 	}

	}
}
