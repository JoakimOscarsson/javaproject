import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Star implements Drawable {
	int x, y, r, rmax;
	boolean growing;
	Color color;
	
	public Star(int x, int y, int r) {
		Random rand = new Random();
		
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	public Star(int x, int y, int r, Color color) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
		this.rmax = r;
		this.growing = false;
	}
	
	public void update(){
		if (this.growing == true) {
			this.r = this.r + 5;
			if (this.r >= this.rmax - 10) {
				this.growing = false;
			}
		}
		else if (this.growing == false) {
			this.r = this.r - 5;
			if (this.r <= 5) {
				this.growing = true;
			}
		}
	}
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void setR(int r){
		this.r=r;
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
	
	public void paint(Graphics g) {
		int o = this.r / 2;
		g.setColor(this.color);
		g.drawLine(this.x - o, this.y - o + this.r, this.x - o + this.r / 2, this.y - o);
		g.drawLine(this.x - o + this.r / 2, this.y - o, this.x - o + this.r, this.y - o + this.r);
		g.drawLine(this.x - o + this.r, this.y - o + this.r, this.x - o, this.y - o+ this.r / 3);
		g.drawLine(this.x - o, this.y - o + this.r / 3, this.x - o + this.r, this.y - o + this.r / 3);
		g.drawLine(this.x - o + this.r, this.y - o + this.r / 3, this.x - o, this.y - o + this.r);
	}
	

}
