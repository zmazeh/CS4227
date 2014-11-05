package entity;



public interface LightState {
	public void changeState(Light light);
	public int getTimeLength() ;
	public void setTimeLength(int timeLength);
}
