package entity;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;
import observer.subject;

public class PedestrainLight extends Light implements subject
{

	private Thread pedestrainLightThread;
	private List<Observer> observerList;
    public PedestrainLight(){
    	super();
    	observerList=new ArrayList<Observer>(); 
    }
    public PedestrainLight(LightState state){
    	super(state);
    	observerList=new ArrayList<Observer>(); 
    }

	public void drawMe() {
		System.out.println("pedestrain Light's drawme()");
		
	}
    protected class PedestrainLightRegularAction implements Runnable{
		public void run() {
			while(true){
				if(getState() instanceof RedLightState){
					//keep Red State until someone press the button
				}else{
				ChangeState();
				listener.LightChangeState(PedestrainLight.this);
				try {
					Thread.sleep(getState().getTimeLength()*1000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			}
			
		}
    	
    }

    public void start(){
    	pedestrainLightThread=new Thread(new PedestrainLightRegularAction());
    	pedestrainLightThread.start();
    }
	@Override
	public void attach(Observer o) {
		if(o !=null){
			observerList.add(o);
		}
		
	}
	@Override
	public void detach(Observer o) {
		int i=observerList.indexOf(o);
		if(i>0){
			observerList.remove(i);
		}
	}
	@Override
	public void notifyObserver() {
		for(Observer o:observerList){
			o.update();
		}
		
	}


}
