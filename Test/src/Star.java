import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Star extends Ball implements DynamicEntity {
	private String ID;
	int rmax;
	boolean growing;
	
	public Star(String ID, int x, int y, int r) {
		this(ID,x,y,r,Color.BLUE);
	}
	
	public Star(String ID, int x, int y, int r, Color color) {
		super(ID,x,y,r,color);
		this.rmax = r;
		this.growing = false;
	}
	
	@Override
	public void updateX(int deltaX) {
		//Do nothing
	}

	@Override
	public void updateY(int deltaY) {
		//Do nothing
	}
	
	@Override
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
	
	@Override
	public void paint(Graphics2D g) {
		int o = this.r / 2;
		g.setColor(this.color);
		g.drawLine(this.x - o, this.y - o + this.r, this.x - o + this.r / 2, this.y - o);
		g.drawLine(this.x - o + this.r / 2, this.y - o, this.x - o + this.r, this.y - o + this.r);
		g.drawLine(this.x - o + this.r, this.y - o + this.r, this.x - o, this.y - o+ this.r / 3);
		g.drawLine(this.x - o, this.y - o + this.r / 3, this.x - o + this.r, this.y - o + this.r / 3);
		g.drawLine(this.x - o + this.r, this.y - o + this.r / 3, this.x - o, this.y - o + this.r);
	}
	

}
