package net.lkrnac.unusualmockingexamples.staticmethod;

/**
 * Used to demonstrate static method mocking
 */
public final class Athmosphere {
	/**
	 * Avoid instantiation
	 */
	private Athmosphere() {
	}

	/**
	 * Static void method to demonstrate static mocking
	 * 
	 * @param volume
	 *            volume of released green house gases in cubic meters
	 */
	public static void releaseGreenhouseGases(int volume) {
		throw new UnsupportedOperationException("Fail if not mocked! [volume="
				+ volume + "]");
	}

	/**
	 * Static method with return value to demonstrate static mocking
	 * 
	 * @return ocean ice area in square meters
	 */
	public static double getGreenhouseGassesLevel() {
		throw new UnsupportedOperationException("Fail if not mocked!");
	}
}
