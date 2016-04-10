import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model  implements Runnable{
	private Thread engine;
	private boolean running = false;
	private int delay = 33;
	private int fps;
	private ConcurrentHashMap<String,DynamicEntity> things = new ConcurrentHashMap<String,DynamicEntity>(1000);
	
	//temporary solution:
	int[] boudary = {800,640};
	
	
	public Model(){

	}
		
		
	public void run(){
		long lastDataFrameTime = System.nanoTime();
		int dataFrames = 0;
		
		while(this.running){
			//Move objects
			for(DynamicEntity i : things.values() ){
				calculateMovement(i);
				i.update();
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
	 
	public ConcurrentHashMap<String,DynamicEntity> getThings(){
		return this.things;
	}
	
	
	public void addThing(DynamicEntity thing) {
		things.put(thing.getID(), thing);
	}


	public void addRandomThing(int x, int y) {
		Random rand = new Random();
		DynamicEntity thing;
		String newID = Integer.toString(getHashSize()+1);
		
		//int shape = rand.nextInt(4);
		int shape = rand.nextInt(3);
		int size = 30 + rand.nextInt(120);
		int R = rand.nextInt(255);
		int G = rand.nextInt(255);
		int B = rand.nextInt(255);
		
		//shape = 0;
		
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
				thing = new Square(newID, x, y, size, new Color(R, G, B));
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
	
	private void calculateMovement(DynamicEntity obj){
		double angle = obj.getAngle();
		System.out.println("inc. anlge= "+angle);
		int speed = obj.getSpeed();
		
		//calculate deltas
		int dx = (int)(speed*Math.cos(angle));
		int dy = (int)(speed*Math.sin(angle));
		
		//Check X boundaries:
		if((obj.getX()-obj.getR()/2+dx <= 0) || (obj.getX()+obj.getR()/2+dx >= this.boudary[0])){
			//fix angle:
			angle = (angle-2*angle+Math.PI)%(2*Math.PI);
			obj.setAngle(angle);
			System.out.println("stuck in X");
		}else{
			//Move in X
			obj.updateX(dx);
		}
		
		//Check Y boundaries:
		if((obj.getY()-obj.getR()/2+dy <= 0) || (obj.getY()+obj.getR()/2+dy >= this.boudary[1])){
			//fix angle:
			double tmp = angle;
			angle = (Math.PI-angle+Math.PI)%(2*Math.PI);
			obj.setAngle(angle);
			System.out.println("stuck in Y");
			System.out.println(Math.toDegrees(tmp) + "->" + Math.toDegrees(angle));

		}else{
			//Move in Y
			System.out.println("nope!");
			obj.updateY(dy);
		}
	}

}


