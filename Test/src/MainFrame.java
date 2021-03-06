import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	//JPanel panel;
	Model model;
	View view;
	Controller controller;
	
	public MainFrame() {
		
		//Init Frame:
		this.setIgnoreRepaint(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Thing Blobber");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//Init model:
		this.model = new Model();
		this.model.start();
		this.model.setTargetDataFPS(60);
		
		//Init View:
		this.view = new View(this.model);
		this.view.setPreferredSize(new Dimension(800,640));
		this.add(view);
		this.pack();
		this.view.createBufferStrategy(2);
		this.view.start();
		this.view.setTargetScreenFPS(60);
		
		//Init Controller:
		this.controller = new Controller(this.model, this.view);
		this.addKeyListener(this.controller.manipulator);
		this.view.addKeyListener(this.controller.manipulator);

	}
	
	public static void main(String[] args) {
		new MainFrame();
		
		
	}
	
}
