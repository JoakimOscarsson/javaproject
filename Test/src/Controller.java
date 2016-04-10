import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Controller implements MouseListener, MouseMotionListener{
	Model model;
	View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		
		
		
		//Init Listeners
		this.view.addMouseListener(this);
		this.view.addMouseMotionListener(this);
		



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

}

