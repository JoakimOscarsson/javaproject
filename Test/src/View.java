import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	private int delay = 33;
	private int fps;

	public View(Model model) {
		this.model = model;
	}
		
	public void run(){
		long lastFrameTime = System.nanoTime();
		int frames = 0;
		
		while(this.running){
			this.g = (Graphics2D) this.getBufferStrategy().getDrawGraphics();
			render();
			this.g.dispose();
			this.getBufferStrategy().show();

			//Calc FPS
			frames++;
			if(System.nanoTime() - lastFrameTime >= 1000000000L){
				this.fps = frames;
				frames = 0;
				lastFrameTime = System.nanoTime();
			}
			
			//sleep
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
		
	public void render(){
		//Background
		this.g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//Objects
		
		for (DynamicEntity i : model.getThings().values() ){
			i.paint(this.g);
		}
		//Foreground
		g.setColor(Color.yellow);
		g.setFont(new Font("dialog",Font.PLAIN,12));
		g.drawString("FPS: "+this.fps+"("+1000/this.delay+")/"+this.model.getDataFPS()[0]+"("+this.model.getDataFPS()[1]+")", 5, 15);
	}
	
	public void setScreenFPS(int targetFPS){
		this.delay = 1000/targetFPS;
	}
	

}
