package entity;

import java.awt.Graphics;

import car.Car;
import listener.PedestrainListener;
import constant.global;

public class Pedestrain {  
	//the position of left top corner
	private int left;
	private int top;
	private PedestrainListener listener;
	public Pedestrain(){
		left=15;
		top=0;
	}
  public void moveLeft(){
	  System.out.println("pedestrain move left");
	  left-=global.PedestrainSize;
  }
  public void moveRight(){
	  System.out.println("pedestrain  move right");
	  left+=global.PedestrainSize;
  }
  public void moveForward(){
	  System.out.println("pedestrain forward");
	  top-=global.PedestrainSize;
  }
  public void moveBack(){
	  System.out.println("pedestrain move back");
	  top+=global.PedestrainSize;
  }
  public void drawMe(Graphics g){
	  System.out.println("pedestrain drawMe");
	  drawPedestrain(g,left,top,global.PedestrainSize,global.PedestrainSize);
  }
  
	public void drawPedestrain(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}
  public void pressButton(){
	  System.out.println("pedestrain just press the button");
	  listener.pressButton();
  }
  public void  addPedestrainListener(PedestrainListener l){
	  if(l!=null){
		  listener=l;
	  }
  }

public int getLeft() {
	return left;
}
public void setLeft(int left) {
	this.left = left;
}
public int getTop() {
	return top;
}
public void setTop(int top) {
	this.top = top;
}

}
