package net.lkrnac.unusualmockingexamples.finalmethod.powermockito;

import net.lkrnac.unusualmockingexamples.finalmethod.Bike;

/**
 * Used for demonstrating mocking static method by PowerMock
 */
public class Rider {
	private Bike bike;

	/**
	 * Creates instance of class used for testing
	 * 
	 * @param bike
	 *            bike to ride on
	 */
	public Rider(Bike bike) {
		this.bike = bike;
	}

	/**
	 * Method used to demonstrate final method mocking
	 * 
	 * @return gear number
	 */
	public int prepareForUphill() {
		int gear = bike.getGear();
		for (int idx = 0; idx < 2; idx++) {
			bike.shiftGear(true);
			gear++;
		}
		return gear;
	}
}
