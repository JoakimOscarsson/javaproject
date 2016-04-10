import java.awt.Graphics;
import java.awt.Graphics2D;

public interface DynamicEntity {
	public String getID();
	public void paint(Graphics2D g);
	public void update();
	public int getSpeed();
	//public double getAngle();
	public void setSpeed(int newSpeed);
	//public void setAngle(double newAngle);
	public void updateX(double deltaX);
	public void updateY(double deltaY);
	public double getX();
	public double getY();
	public double getDx();
	public double getDy();
	public int getR();
}
