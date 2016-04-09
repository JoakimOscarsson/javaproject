import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class View extends JPanel implements ActionListener {
	Model model;
	Timer screenRefreshRate;

	public View(Model model) {
		this.model = model;
		
		setBackground(Color.BLACK);
		
		this.screenRefreshRate = new Timer(10,this);
		this.screenRefreshRate.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawLine(0, 300, 300, 300);
		//g.drawLine(300, 0, 300, 300);
		
		for(Drawable i:model.getThings()) {
			i.paint(g);
		}
	}

	public void actionPerformed(ActionEvent e){
		this.repaint();
	}

}
