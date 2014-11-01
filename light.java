package LightAndLightState;

import FactoryMethod.Product;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class Light implements Product{ 
	public LightState state;
	public Light(){
		state=new RedLight();
	}
	public Light(LightState s){
		state=s;
	}
//	public virtual ~Light()=0;
	public void ChangeState(){
		getState().changeState(this);	
	}
	
	public LightState getState() {
		return state;
	}
	public void setState(LightState state) {
		this.state = state;
	}	

}
