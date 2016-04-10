import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
	ArrayList<Drawable> things = new ArrayList<Drawable>();
	
	public MainPanel() {
		setBackground(Color.BLACK);
	}/*
	
	public void paintComponent(Graphics2D g) {
		super.paintComponent(g);
		//g.drawLine(0, 300, 300, 300);
		//g.drawLine(300, 0, 300, 300);
		
		for(Drawable i:things) {
			i.paint(g);
		}
	}*/
}
