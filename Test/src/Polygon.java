import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;

public class Polygon implements Drawable {
	int x, y, r;
	Color color;
	int[] polyX;
	int[] polyY;
	int polyN;

	public Polygon(){
		this.x = 0;
		this.y = 0;
		this.r = 100;
		//this.color = Color.RED;
		this.color = new Color(255, 0, 0);
		
		System.out.println(this.x);
	}
	
	public void update(){
		
	}
	
	public Polygon(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = Color.RED;
	}
	
	public Polygon(int x, int y, int r, Color color) {
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
	
	public static void main(String[] args) {
		Polygon Polygon = new Polygon();
	}
	
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillPolygon(this.polyX, this.polyY, this.polyN);
	}
	
}

