package entity;

import constant.global;

public class RedLightState implements LightState {
    int timeLength;
    public RedLightState(){
    	timeLength=global.RedStateTime;
    }
	public void changeState(Light light) {
		System.out.println(light.getClass()+"  now is red light state");
		light.setState(new GreenLightState());
		
	}
	public int getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}
	

}
