package net.lkrnac.unusualmockingexamples.finalmethod;

/**
 * Used for demonstrating stubbing of static method by PowerMock
 */
public class Bike {
	/**
	 * Void final method to be mocked
	 * 
	 * @param easier
	 *            flag indicating shift to easier of harder gear
	 * 
	 */
	public final void shiftGear(boolean easier) {
		throw new UnsupportedOperationException("Fail if not mocked! [easier="
				+ easier + "]");
	}

	/**
	 * Method with return value to be mocked
	 * 
	 * @return gear number
	 */
	public final int getGear() {
		throw new UnsupportedOperationException("Fail if not mocked!");
	}
}
