import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Manipulator implements KeyListener{
	private DynamicEntity manipulable = null;
	private Color oldColor;

	
	public void setManipulable(DynamicEntity newManipulable){
		if(manipulable != null){
			manipulable.setColor(oldColor);
		}
		this.oldColor = newManipulable.getColor();
		newManipulable.setColor(new Color(255,0,0));
		this.manipulable = newManipulable;
	}
	
	public void clearManipulable(){
		if(manipulable != null){
			this.manipulable.setColor(oldColor);
			this.manipulable = null;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
		case 37:
			if(manipulable!=null)
				manipulable.addToDx(-0.5);
			break;
		case 38:
			if(manipulable!=null)
				manipulable.addToDy(-0.5);
			break;
		case 39:
			if(manipulable!=null)
				manipulable.addToDx(0.5);
			break;
		case 40:
			if(manipulable!=null)
				manipulable.addToDy(0.5);
			break;	
		}
		//if(e.getKeyCode()==39){
			
		//}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
