import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class View extends JPanel {
	Model model;

	public View(Model model) {
		this.model = model;
		
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawLine(0, 300, 300, 300);
		//g.drawLine(300, 0, 300, 300);
		
		for(Drawable i:model.getThings()) {
			i.paint(g);
		}
	}


}
