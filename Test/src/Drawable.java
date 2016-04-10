import java.awt.Graphics;
import java.awt.Graphics2D;

public interface Drawable {
	public String getID();
	public void paint(Graphics2D g);
	public void update();
}
