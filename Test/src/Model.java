import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class Model {
	ArrayList<Drawable> things = new ArrayList<Drawable>();
	
	public ArrayList<Drawable> getThings() {
		return things;
	}
	
	public void addThings(Drawable thing) {
		things.add(thing);
	}

	public void addRandomThing(int x, int y) {
		Random rand = new Random();
		Drawable thing;
		
		int shape = rand.nextInt(4);
		int size = 30 + rand.nextInt(470);
		int R = rand.nextInt(255);
		int G = rand.nextInt(255);
		int B = rand.nextInt(255);
		
		switch (shape) {
			case 0:
				thing = new Ball(x, y, size, new Color(R, G, B));
				break;
			case 1:
				thing = new Star(x, y, size, new Color(R, G, B));
				break;
			case 2:
				thing = new Square(x, y, size, new Color(R, G, B));
				break;
			case 3:
				thing = new Polygon(x, y, size, new Color(R, G, B));
				break;
			default:
				thing = new Ball(x, y, size, new Color(R, G, B));
				break;
		}
		
		things.add(thing);
		//System.out.println(things.toString());
	}
	
	public void clearList() {
		this.things.clear();
	}
}


