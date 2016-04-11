import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

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
			for(DynamicEntity i : this.things.values() ){
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
	
	public void setTargetDataFPS(int targetFPS){
		this.delay = 1000/targetFPS;
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
		//double angle = obj.getAngle();
		boolean moveX = true;
		boolean moveY = true;
		
		//calculate deltas
		double dx = obj.getDx();
		double dy = obj.getDy();
		
		
		//Check dynamical objects:
		Rectangle r1 = new Rectangle((int)(obj.getX()-obj.getR()/2+dx), (int)(obj.getY()-obj.getR()/2+dy), obj.getR(), obj.getR());
		//Check if close:
		for(DynamicEntity i : this.things.values() ){		
			if (obj.getID() != i.getID()){
				double dx2 =  i.getDx();
				double dy2 =  i.getDy();
				Rectangle r2 = new Rectangle((int)(i.getX()-i.getR()/2+dx2), (int)(i.getY()-i.getR()/2+dy2), i.getR(), i.getR());
				if(r1.intersects(r2)){
					//Check for collision:
					double d = Math.sqrt( Math.pow( (obj.getX()+dx) - (i.getX()+dx2) , 2) + Math.pow( (obj.getY()+dy) - (i.getY()+dy2) , 2) );
					if(d <= (obj.getR()+i.getR())/2){
						//calculate new speeds
						double tmp_dx = dx, tmp_dy = dy;
						dx = (dx * (obj.getR() - i.getR()) + (2 * i.getR() * dx2)) / (obj.getR() + i.getR());
						dy = (dy * (obj.getR() - i.getR()) + (2 * i.getR() * dy2)) / (obj.getR() + i.getR());
						dx2 = (dx2 * (i.getR() - obj.getR()) + (2 * obj.getR() * tmp_dx)) / (obj.getR() + i.getR());
						dy2 = (dy2 * (i.getR() - obj.getR()) + (2 * obj.getR() * tmp_dy)) / (obj.getR() + i.getR());
						
						//Update collided
						i.updateX(dx2);
						i.updateY(dy2);
					}
				}				
			}
		}
		
		
		//Check X boundaries:
		if((obj.getX()-obj.getR()/2+dx <= 0) || (obj.getX()+obj.getR()/2+dx >= this.boudary[0])){
			dx = -dx;
		}

		
		//Check Y boundaries:
		if((obj.getY()-obj.getR()/2+dy <= 0) || (obj.getY()+obj.getR()/2+dy >= this.boudary[1])){
			dy = -dy;
		}
		obj.updateX(dx);
		obj.updateY(dy);
	}
	
	public DynamicEntity select(int x,int y){
		for(DynamicEntity i : this.things.values() ){
			double d = Math.sqrt( Math.pow( x - i.getX() , 2) + Math.pow( y - i.getY() , 2) );
			if(d <= (i.getR()/2) ){
				return i;
			}
		}
		return null;
	}

}


