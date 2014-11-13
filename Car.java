package car;

import java.awt.Graphics;

import constant.global;
import listener.CarListener;

public abstract class Car {
	//the position of left top corner
	protected int left;
	protected int top;
	
	int direction;
	public static final int north=1;
	public static final int south=2;
	public static final int west=3;
	public static final int east=4;
	
	int speed;
	public Thread carThread;
	public CarListener listener;
	
	public Car(int direction){
		this.direction =direction;
		switch(this.direction){
		case north:left=global.CarInitPositonX;
				top=0;
				break;
		case south :left=global.CarInitPositonX;
				top=global.Height;
				break;
		case west: left=0;
				top=global.CarInitPostionY;
				break;
		case east:left=global.Width;
				top=global.CarInitPostionY;
		}
		
	}
	public abstract void move();
	public abstract void stop();
	public abstract void drawMe(Graphics g);
	
	public void drawCar(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}
	
	protected void start(){
		carThread=new Thread(new CarDriver());
		carThread.start();
	}
	
	protected class CarDriver implements Runnable{

		public void run() {
			while(true){
				move();
				listener.CarMove(Car.this);
				try {
					Thread.sleep(speed*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public void addCarListener(CarListener l){
	   	if(l!=null){
    		listener=l;
    	}
    	start();
	}
	
		
public int getDistanceBehind(); //gets distance of car closest behind it
public int getDistanceInfront(); //gets distance of car closest infront of it
public void setPosition(int a); //sets position on road (in this case one lane)
public int getMaxSpeed();
public int getPosition();
void create();

}
