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
			for (int i=0; i < this.lv.listRoom.size(); i++){
				g.setColor(this.lv.listRoom.get(i).Rcolor);
				g.fillRect(this.lv.listRoom.get(i).cordx, this.lv.listRoom.get(i).cordy,
						this.lv.listRoom.get(i).dimx, this.lv.listRoom.get(i).dimy);
	            g.setColor(Color.white);
	            g.drawRect(this.lv.listRoom.get(i).cordx, this.lv.listRoom.get(i).cordy,
						this.lv.listRoom.get(i).dimx, this.lv.listRoom.get(i).dimy);
			}
			
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
