public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("Vehicle")) {
			return new VehicleFactory();
		} else if (choice.equalsIgnoreCase("Driver")) {
			return new DriverFactory();
		}
		return null;
	}
}
