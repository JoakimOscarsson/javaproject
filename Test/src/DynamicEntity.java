import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public interface DynamicEntity {
	public String getID();
	public void paint(Graphics2D g);
	public void update();
	public int getSpeed();
	public void setSpeed(int newSpeed);
	public void updateX(double deltaX);
	public void updateY(double deltaY);
	public double getX();
	public double getY();
	public double getDx();
	public double getDy();
	public int getR();
	public Color getColor();
	public void setColor(Color newColor);
	public void addToDx(double deltaX);
	public void addToDy(double deltaY);
}
