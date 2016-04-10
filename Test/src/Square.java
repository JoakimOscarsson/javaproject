import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Square implements Drawable {
	private String ID;
	int x, y, r;
	Color color;

	/*public Square(){
		this.x = 0;
		this.y = 0;
		this.r = 100;
		//this.color = Color.RED;
		this.color = new Color(255, 0, 0);
		
		System.out.println(this.x);
	}*/
	/*
	public Square(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = Color.RED;
	}*/
	
	public void update(){
		
	}
	
	public Square(String ID, int x, int y, int r, Color color) {
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
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
		g.fillRect(this.x - this.r / 2, this.y - this.r / 2, this.r, this.r);
	}
	
}

