package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import constant.global;
import listener.CarListener;
import listener.LightListener;
import listener.PedestrainListener;
import view.ShowPanel;
import FactoryMethod.FactoryMethod;
import car.Car;
import entity.Light;
import entity.Pedestrain;
import entity.PedestrainLight;
import entity.TrafficLight;

public class Controller extends KeyAdapter implements LightListener,CarListener,PedestrainListener{
	private Pedestrain pedestrain;
	private List<Car> carList;
	private List<Light> lightList;
//	private List<TrafficLight> trafficLightList;
//	private List<PedestrainLight> pedestrainLightList;
	private ShowPanel showPanel;
	private FactoryMethod factoryMethod;
	
	public Controller(FactoryMethod factory,ShowPanel showPanel){
		this.factoryMethod=factory;
		this.showPanel=showPanel;
		carList=new ArrayList<Car>();
		lightList=new ArrayList<Light>();
		
	}
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:pedestrain.moveForward();break;
		case KeyEvent.VK_DOWN:pedestrain.moveBack();break;
		case KeyEvent.VK_LEFT:pedestrain.moveLeft();break;
		case KeyEvent.VK_RIGHT:pedestrain.moveRight();break;
		case KeyEvent.VK_BACK_SPACE:pedestrain.pressButton();
		}
		showPanel.display(carList, pedestrain, lightList);
	}

	public void LightChangeState(Light light) {
		showPanel.display(carList, pedestrain, lightList);
		
	}
	public void CarMove(Car car){
		showPanel.display(carList, pedestrain, lightList);
	}

	@Override
	public void pressButton() {
		findNearestPedestrainLight().notifyObserver();
   		
	}
	public PedestrainLight findNearestPedestrainLight(){
		int tempDistance;
		Light minPedestrainLight;
		minPedestrainLight=lightList.get(0);
		//System.out.println(minPedestrainLight.getClass());
		//tempDistance=calcultorDistance(pedestrain,minPedestrainLight);          //java.lang.ClassCastException  
		                                                                        //should make sure use get(index) get a correct Light subclass
		tempDistance=global.Max;

		for(Light l:lightList){
			if(l instanceof PedestrainLight){
				if(tempDistance>calcultorDistance(pedestrain,l)){
					tempDistance=calcultorDistance(pedestrain,l);
					minPedestrainLight=l;
				}
				return (PedestrainLight) minPedestrainLight;
			}
		}
		return null;
	}
	public int calcultorDistance(Pedestrain p,Light l){
		int distance;
		if(l==null){
			distance= global.Max;
		}
		else{
			distance=Math.abs((p.getLeft()-l.getLeft())*(p.getLeft()-l.getLeft())-(p.getTop()-l.getTop())*(p.getTop()-l.getTop()));
		}
		return distance;
	}
	public void newSimulator(){
		Light l=factoryMethod.CreateLight("TrafficLight",this);
		lightList.add(l);
		System.out.println(l.getClass());
	//	lightList.add(factoryMethod.CreateLight("TrafficLight",this));
	/*	Light light=factoryMethod.CreateLight("PedestrainLight",this);
		System.out.println(light.getClass());
		lightList.add(light);*/
		PedestrainLight pedelight= (PedestrainLight) factoryMethod.CreateLight("PedestrainLight",this);
		pedelight.attach( (TrafficLight) l);
		lightList.add(pedelight);
		carList.add(factoryMethod.CreateCar("Fast",Car.east,this));
		carList.add(factoryMethod.CreateCar("slow", Car.north,this));
		pedestrain=factoryMethod.CreatePedestrain(this);
		
	//	pedestrain.pressButton();
	}
}
