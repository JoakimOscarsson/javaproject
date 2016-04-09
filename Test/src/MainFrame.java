import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	JPanel panel;
	
	public MainFrame(JPanel mp) {
		this.panel = mp;
		this.setSize(1920, 1080);
		this.setTitle("Amazing Java");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(this.panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame(new MainPanel());
	}
	
}
