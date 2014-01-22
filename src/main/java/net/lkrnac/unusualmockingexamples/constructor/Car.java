package net.lkrnac.unusualmockingexamples.constructor;

/**
 * Used to demonstrate mocking of constructor
 */
public class Car {
	/**
	 * Used for constructor mocking demostration
	 * 
	 * @param type
	 *            type of the car
	 * @param color
	 *            color of the car
	 */
	public Car(String type, String color) {
		throw new UnsupportedOperationException("Fail if not mocked! [type="
				+ type + ", color=" + color + "]");
	}
}
