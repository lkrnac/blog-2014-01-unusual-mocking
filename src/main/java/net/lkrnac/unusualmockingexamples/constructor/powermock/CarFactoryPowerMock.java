package net.lkrnac.unusualmockingexamples.constructor.powermock;

import net.lkrnac.unusualmockingexamples.constructor.Car;

/**
 * Class to demonstrate constructor mocking by PowerMock
 */
public class CarFactoryPowerMock {
	/**
	 * Method used to demonstrate mocking of constructor by PowerMock
	 * 
	 * @param type
	 *            type of the car
	 * @param color
	 *            color of the car
	 * @return constructed car
	 */
	public Car constructCar(String type, String color) {
		new Car(type, color);
		return new Car(type, color);
	}
}
