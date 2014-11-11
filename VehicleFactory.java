
public class VehicleFactory extends AbstractFactory {

	public Vehicle getVehicle(String car){
		if (car == null){
			return null;
		}
		
		if(car.equalsIgnoreCase("SlowCar")){
			return new SlowCar();
		}
		else if(car.equalsIgnoreCase("FastCar")){
			return new FastCar();
		}
		return null;
	}
	
	Driver getDriver(String driver){
		return null;
	}
}
