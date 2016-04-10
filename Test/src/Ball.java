import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball implements DynamicEntity {
	int x, y, r,speed;
	double theta;
	Color color;
	private String ID;

	public Ball(String ID){
		this(ID,0,0,100);
	}
	

	public Ball(String ID, int x, int y, int r) {
		this(ID,x,y,r,Color.BLUE);
	}
	
	public Ball(String ID, int x, int y, int r, Color color) {
		Random rand = new Random();
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;

		this.theta = Math.toRadians(rand.nextInt(359)) + 1;
		this.speed = Math.abs((500 - this.r) / 60) + 2;

	}
	
	public void printMe(){
		//System.out.println("X = " + this.x + ", Y = " + this.y + ", r = " + this.r);
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setR(int r){
		this.r = r;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getR(){
		return this.r;
	}
	
	
	public String getID(){
		return this.ID;
	}
	
	
	public void paint(Graphics2D g) {
		g.setColor(this.color);
		g.fillOval(this.x - this.r / 2, this.y - this.r / 2, this.r, this.r);
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public double getAngle() {
		return this.theta;
	}

	@Override
	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}

	@Override
	public void setAngle(double newAngle) {
		System.out.println(this.theta);
		this.theta = newAngle;
		System.out.println(this.theta);
	}

	@Override
	public void updateX(int deltaX) {
		this.x += deltaX;
	}

	@Override
	public void updateY(int deltaY) {
		this.y += deltaY;
	}
	
	public void update(){
		/*
		this.x += (int)(this.speed * Math.cos(this.theta));
		this.y += (int)(this.speed * Math.sin(this.theta));
		*/
	}
	
	
}
