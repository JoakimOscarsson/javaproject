
public class Farg {
	int r,g,b;
	
	
	
	public Farg(int R, int G, int B){
		this.setRGB(R, G, B);
	}
	
	
	
	
	public void setR(int r){
		this.r = r;
	}
	public void setG(int g){
		this.g = g;
	}
	public void setB(int b){
		this.b = b;
	}
	public void setRGB(int r,int g,int b){
		this.setR(r);
		this.setG(g);
		this.setB(b);
	}
	public int getR(){
		return this.r;
	}
	public int getG(){
		return this.g;
	}
	public int getB(){
		return this.b;
	}
	public int[] getRGB(){
		int[] tmp = {this.r,this.g,this.b};
		return tmp;
	}
}
