package entity;

import listener.LightListener;


public abstract class Light {
	private LightState state;
	public LightListener listener;
	
	public int left;
	public int top;
	
	//constructor
	public Light(){
		state=new RedLightState();
	}
	public Light(LightState s){
		state=s;
	}
	
	public  void ChangeState(){
		state.changeState(this);
	}
	
	public LightState getState() {
		return state;
	}
	public void setState(LightState state) {
		this.state = state;
	}	
	public abstract void drawMe();
	
	public abstract void start();
	
    public  void addLightListener(LightListener l){
    	if(l!=null){
    		listener=l;
    	}
    	start();
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
