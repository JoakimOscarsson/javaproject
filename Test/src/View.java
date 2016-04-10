import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

public class View extends Canvas implements Runnable {
	Model model;
	//private BufferStrategy bs;
	private Graphics2D g;
	private boolean running = false;
	private Thread screen;

	public View(Model model) {
		this.model = model;
	}
	
	
	public void run(){
		while(this.running){
			this.g = (Graphics2D) this.getBufferStrategy().getDrawGraphics();
			render();
			this.g.dispose();
			this.getBufferStrategy().show();
		}
	}
	
	public void start(){
		if(this.running){
			return;
		}
		this.running = true;
		this.screen = new Thread(this);
		this.screen.start();
	}
	
	//public void setBufferStrategy(BufferStrategy bs){
	//	this.bs = bs;
	//}
	
	public void render(){
		//Background
		this.g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//Objects
		
		for (Drawable i : model.getThings().values() ){
			i.paint(this.g);
		    //do something with them
		}
		
		/*for(Drawable i:model.getThings()) {
			i.paint(this.g);
		}*/
		
		
	}
	
	//public Dimension getSize(){
	//	return this.size;
	//}
	//public void setSize(Dimension size){
	//	this.size = size;
	//}
	
	
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		//g.drawLine(0, 300, 300, 300);
		//g.drawLine(300, 0, 300, 300);
		

	}

	public void setScreenFPS(int targetFPS){
		
	}
	

}
