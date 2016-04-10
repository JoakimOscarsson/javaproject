import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.ArrayList;

public class Polygon implements Drawable {
	String ID;
	int x, y, r;
	Color color;
	int[] polyX;
	int[] polyY;
	int polyN;

	/*public Polygon(){
		this.x = 0;
		this.y = 0;
		this.r = 100;
		//this.color = Color.RED;
		this.color = new Color(255, 0, 0);
		
		System.out.println(this.x);
	}*/
	
	public void update(){
		Random rand = new Random();
		
		this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	public Polygon(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = Color.RED;
	}
	
	public Polygon(String ID, int x, int y, int r, Color color) {
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
		
		Random rand = new Random();
		this.polyN = rand.nextInt(10);
		this.polyX = new int[this.polyN];
		this.polyY = new int[this.polyN];		

		for(int i = 0; i < this.polyN; i++) {
			this.polyX[i] = this.x + rand.nextInt(this.r) - this.r / 2;
			this.polyY[i] = this.y + rand.nextInt(this.r) - this.r / 2;
		}
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
		g.fillPolygon(this.polyX, this.polyY, this.polyN);
	}
	
}

