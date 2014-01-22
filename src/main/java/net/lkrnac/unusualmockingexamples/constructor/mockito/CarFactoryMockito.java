package net.lkrnac.unusualmockingexamples.constructor.mockito;

import net.lkrnac.unusualmockingexamples.constructor.Car;

/**
 * Class to demonstrate how to make constructor testable by Mockito
 */
public class CarFactoryMockito {
	/**
	 * Tiny method that wraps constructor. Is partially mocked by test.
	 * 
	 * @param type
	 *            type of the car
	 * @param color
	 *            color of the car
	 * @return created car
	 */
	Car carFactoryMethod(String type, String color) {
		return new Car(type, color);
	}

	/**
	 * Method to demonstrate how to make constructor testable by Mockito
	 * 
	 * @param type
	 *            type of the car
	 * @param color
	 *            color of the car
	 * @return created instance by constructor
	 */
	public Car constructCar(String type, String color) {
		carFactoryMethod(type, color);
		// ... other logic needed to be tested ...
		return carFactoryMethod(type, color);
	}
}
