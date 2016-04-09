public class boll {
	float x,y,r;
	farg color;
		
	
	
	public boll(){
		this.x = 2;
		this.y = 2;
		this.r = 3;
		this.color = new farg(255,0,0);
		
		System.out.println(this.x);
	}
	
	public void printMe(){
		System.out.println("X = "+this.x+", Y = "+this.y+", r = "+this.r);
	}
	
	public void setX(float x){
		this.x=x;
	}
	public void setY(float y){
		this.y=y;
	}
	public void setR(float r){
		this.r=r;
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public float getR(){
		return this.r;
	}
	
	public void setColor(farg newColor){
		this.color = newColor;
	}


	
	
	
	public static void main(String[] args) {
		System.out.println("hello world");
		boll boll1 = new boll();
		boll1.printMe();
		boll1.setR(5);
		boll1.printMe();
		boll1.setColor(new farg(50,50,50));
	}
	
}
