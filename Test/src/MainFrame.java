import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	JPanel panel;
	Model model;
	View view;
	Controller controller;
	
	public MainFrame() {
		this.model = new Model();
		this.view = new View(this.model);
		this.controller = new Controller(this.model, this.view);
				
		this.setSize(1920, 1080);
		this.setTitle("Thing Blobber");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(this.view);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
		
		
	}
	
}
