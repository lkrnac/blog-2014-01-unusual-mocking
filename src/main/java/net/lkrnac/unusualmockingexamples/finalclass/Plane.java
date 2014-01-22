package net.lkrnac.unusualmockingexamples.finalclass;

/**
 * Used to demonstrate final class mocking by PowerMock
 */
public final class Plane {
	/**
	 * ID of right engine
	 */
	public static final int ENGINE_ID_RIGHT = 2;
	/**
	 * ID of left engine
	 */
	public static final int ENGINE_ID_LEFT = 1;

	/**
	 * Method with return value to mock
	 * 
	 * @return verifies systems of the plane
	 */
	public boolean verifyAllSystems() {
		throw new UnsupportedOperationException("Fail if not mocked!");
	}

	/**
	 * Void method to mock
	 * 
	 * @param engineId
	 *            ID of engine to start
	 * 
	 */
	public void startEngine(int engineId) {
		throw new UnsupportedOperationException(
				"Fail if not mocked! [engineId=" + engineId + "]");
	}
}
