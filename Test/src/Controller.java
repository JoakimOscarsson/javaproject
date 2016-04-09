import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Controller implements MouseListener, MouseMotionListener, ActionListener {
	Model model;
	View view;
	Timer screenRefreshRate;
	Timer modelRefreshRate;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		
		//Timers:
		screenRefreshRate = new Timer(10,this);
		screenRefreshRate.start();
	}
	
	
	public void addRandomThing(MouseEvent e) {
		//System.out.println("pressed");
		int x = e.getX();
		int y = e.getY();
		
		this.model.addRandomThing(x, y);
	}
	
	public void mousePressed(MouseEvent e) {
		int btn = e.getButton();
		
		if (btn == 1) {
			addRandomThing(e);
		}
		else {
			this.model.clearList();
		}
				
		view.repaint();
	}
	
	public void mouseReleased(MouseEvent e) {
		//System.out.println("released");
	}

	public void mouseEntered(MouseEvent e) {
		//System.out.println("entered");
	}

	public void mouseExited(MouseEvent e) {
		//System.out.println("exited");
	}
	
	public void mouseClicked(MouseEvent e) {
		//System.out.println("clicked");
	}
	
	public void mouseMoved(MouseEvent e) {
		//System.out.println("moved");
	}
	
	public void mouseDragged(MouseEvent e) {
		addRandomThing(e);
		view.repaint();
		//System.out.println("bahs");
	}
	
	public void actionPerformed(ActionEvent e){
		ArrayList<Drawable> objs = this.model.getThings();
		for(Drawable i:objs) {
			i.update();
		}
		this.view.repaint();
	}
}

