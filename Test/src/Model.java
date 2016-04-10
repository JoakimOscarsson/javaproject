import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model  implements Runnable, ActionListener {
	private Thread engine;
	private boolean running = false;
	private int delay = 33;
	private int fps;
	private ConcurrentHashMap<String,Drawable> things = new ConcurrentHashMap<String,Drawable>();
	
	
	public Model(){

	}
	
	private void calculateMovement(Drawable obj){
		
	}
	
	public void run(){
		long lastDataFrameTime = System.nanoTime();
		int dataFrames = 0;
		
		while(this.running){
			//Move objects
			for(Drawable i : things.values() ){
				calculateMovement(i);
			}
			
			
			//Calc dataFPS
			dataFrames++;
			if(System.nanoTime() - lastDataFrameTime >= 1000000000L){
				this.fps = dataFrames;
				dataFrames = 0;
				lastDataFrameTime = System.nanoTime();
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
		 this.engine = new Thread(this);
		 this.engine.start();
	 }
	
	public int[] getDataFPS(){
		int[] out = {this.fps,1000/delay};
		return out;
	}
	 
	public ConcurrentHashMap<String,Drawable> getThings(){
		return this.things;
	}
	
	
	public void addThing(Drawable thing) {
		things.put(thing.getID(), thing);
	}


	public void addRandomThing(int x, int y) {
		Random rand = new Random();
		Drawable thing;
		String newID = Integer.toString(getHashSize()+1);
		
		//int shape = rand.nextInt(4);
		int shape = rand.nextInt(3);
		int size = 30 + rand.nextInt(470);
		int R = rand.nextInt(255);
		int G = rand.nextInt(255);
		int B = rand.nextInt(255);
		
		shape = 0;
		
		switch (shape) {
			case 0:
				thing = new Ball(newID, x, y, size, new Color(R, G, B));
				break;
			case 1:
				thing = new Star(newID, x, y, size, new Color(R, G, B));
				break;
			case 2:
				thing = new Polygon(newID, x, y, size, new Color(R, G, B));
				break;
			/*case 3:
				thing = new Square(x, y, size, new Color(R, G, B));
				break;*/
			default:
				thing = new Polygon(newID, x, y, size, new Color(R, G, B));
				break;
		}
		
		this.addThing(thing);
		//System.out.println(things.toString());
	}
	
	public void clearList() {
		this.things.clear();
	}
	
	public int getHashSize(){
		return this.things.size();
	}
	

	
	
	public void actionPerformed(ActionEvent e){
		//for(Drawable i:this.things) {
			//i.update();
		//}
	}
}


