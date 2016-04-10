import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.ArrayList;

public class Polygon extends Ball implements DynamicEntity {
	int[] polyX;
	int[] polyY;
	int polyN;


	

	
	public Polygon(String ID){
		this(ID,0,0,100,Color.BLUE);
		
	}
	public Polygon(String ID, double x, double y, int r) {
		this(ID,x,y,r,Color.BLUE);
	}
	
	public Polygon(String ID, double x, double y, int r, Color color) {
		super(ID,x,y,r,color);
		Random rand = new Random();
		this.polyN = rand.nextInt(10);
		this.polyX = new int[this.polyN];
		this.polyY = new int[this.polyN];		

		for(int i = 0; i < this.polyN; i++) {
			this.polyX[i] = (int)this.x + rand.nextInt(this.r) - this.r / 2;
			this.polyY[i] = (int)this.y + rand.nextInt(this.r) - this.r / 2;
		}
	}
	
	@Override
	public void updateX(double deltaX) {
		//Do nothing
	}

	@Override
	public void updateY(double deltaY) {
		//Do nohting
	}
	
	@Override
	public void update(){
		Random rand = new Random();
		
		this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	@Override
	public void paint(Graphics2D g) {
		g.setColor(this.color);
		g.fillPolygon(this.polyX, this.polyY, this.polyN);
	}
	
}

