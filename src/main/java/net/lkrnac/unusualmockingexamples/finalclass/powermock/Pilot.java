package net.lkrnac.unusualmockingexamples.finalclass.powermock;

import net.lkrnac.unusualmockingexamples.finalclass.Plane;

/**
 * Used to demonstrate mocking of final class by PowerMock
 */
public class Pilot {
	private Plane plane;

	/**
	 * Creates testing class to demonstrate mocking on
	 * 
	 * @param plane
	 *            instance of testing class
	 */
	public Pilot(Plane plane) {
		this.plane = plane;
	}

	/**
	 * Testing method to demonstrate final class mocking on
	 * 
	 * @return status
	 */
	public boolean readyForFlight() {
		plane.startEngine(Plane.ENGINE_ID_LEFT);
		plane.startEngine(Plane.ENGINE_ID_RIGHT);
		return plane.verifyAllSystems();
	}
}
