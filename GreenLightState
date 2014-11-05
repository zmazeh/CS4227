package entity;

import constant.global;

public class GreenLightState implements LightState {
    int timeLength;
    
    public GreenLightState(){
    	timeLength=global.GreenStateTime;
    }
	public void changeState(Light light) {
		System.out.println(light.getClass()+"now is green light state");
		light.setState(new YellowLightState());
		
	}
	public int getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}

}
