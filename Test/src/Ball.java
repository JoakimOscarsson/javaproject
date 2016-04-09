import java.awt.Color;
import java.awt.Graphics;

public class Ball implements Drawable {
	int x, y, r,dx,dy;
	Color color;

	public Ball(){
		this.x = 0;
		this.y = 0;
		this.r = 100;
		//this.color = Color.RED;
		this.color = new Color(255, 0, 0);
		this.dx = 10;
		this.dy = 0;
		
		System.out.println(this.x);
	}
	
	public void update(){
		this.x += this.dx;
		this.y += this.dy;
	}
	
	public Ball(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = Color.RED;
		this.dx = 10;
		this.dy = 0;
	}
	
	public Ball(int x, int y, int r, Color color) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
		this.dx = 10;
		this.dy = 0;
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
	
	
	public static void main(String[] args) {
		Ball ball = new Ball();
	}
	
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x - this.r / 2, this.y - this.r / 2, this.r, this.r);
	}
	
}
