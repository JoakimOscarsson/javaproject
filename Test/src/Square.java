import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Square extends Ball implements DynamicEntity {
	private String ID;
	int x, y, r;
	Color color;

	public Square(String ID){
		this(ID,0,0,100);
	}
	
	public Square(String ID,int x, int y, int r) {
		this(ID,x,y,r,Color.BLUE);
	}
	
	public Square(String ID, int x, int y, int r, Color color) {
		super(ID,x,y,r,color);
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
		
	}
	
	
	@Override
	public void paint(Graphics2D g) {
		g.setColor(this.color);
		g.fillRect(this.x - this.r / 2, this.y - this.r / 2, this.r, this.r);
	}
	
}

