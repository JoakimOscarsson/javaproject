import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
	ArrayList<Drawable> things = new ArrayList<Drawable>();
	
	public MainPanel() {
		setBackground(Color.BLACK);
		things.add(new Ball(100, 100, 50));
		things.add(new Ball(100, 300, 10));
		things.add(new Ball(400, 600, 100));
		things.add(new Star(300, 300, 50));
		things.add(new Star(200, 300, 10));
		things.add(new Star(400, 600, 100));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawLine(0, 300, 300, 300);
		//g.drawLine(300, 0, 300, 300);
		
		for(Drawable i:things) {
			i.paint(g);
		}
	}
}
