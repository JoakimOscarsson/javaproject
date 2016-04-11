import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball implements DynamicEntity {
	int r,speed;
	double x,y,dx,dy;
	Color color;
	private String ID;

	public Ball(String ID){
		this(ID,0,0,100);
	}
	

	public Ball(String ID, double x, double y, int r) {
		this(ID,x,y,r,Color.BLUE);
	}
	
	public Ball(String ID, double x, double y, int r, Color color) {
		Random rand = new Random();
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;

		this.speed = Math.abs((200 - this.r) / 60) + 2;
		double theta = Math.toRadians(rand.nextInt(359)) + 1;
		this.dx = Math.cos(theta)*this.speed;
		this.dy = Math.sin(theta)*this.speed;
		
		
		

	}
	
	public void printMe(){
		//System.out.println("X = " + this.x + ", Y = " + this.y + ", r = " + this.r);
	}
	
	public double getDx(){
		return this.dx;
	}
	
	public double getDy(){
		return this.dy;
	}
	
	
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setR(int r){
		this.r = r;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
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
		g.fillOval((int)this.x - this.r / 2, (int)this.y - this.r / 2, this.r, this.r);
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	//@Override
	//public double getAngle() {
	//	return this.theta;
	//}

	@Override
	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}

	//@Override
	//public void setAngle(double newAngle) {
	//	this.theta = newAngle;
	//}

	@Override
	public void updateX(double deltaX) {
		this.x += deltaX;
		this.dx = deltaX;
	}

	@Override
	public void updateY(double deltaY) {
		this.y += deltaY;
		this.dy = deltaY;
	}
	
	public void addToDx(double deltaX){
		this.dx += deltaX;
	}
	public void addToDy(double deltaY){
		this.dy += deltaY;
	}
	public void update(){
		/*
		this.x += (int)(this.speed * Math.cos(this.theta));
		this.y += (int)(this.speed * Math.sin(this.theta));
		*/
	}


	@Override
	public Color getColor() {
		return this.color;
	}


	@Override
	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	
	
}
