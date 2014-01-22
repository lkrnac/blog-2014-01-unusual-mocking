package net.lkrnac.unusualmockingexamples.staticmethod.mockito;

import java.util.Collection;

import net.lkrnac.unusualmockingexamples.staticmethod.Athmosphere;

/**
 * Used to demonstrate workaround when static mocking is needed
 */
public class HumanityMockito {
	/**
	 * Is used as testing target to demostrate static mocking workaround
	 * 
	 * @param greenHouseGasesList
	 *            list of greenhouse gases amounts to release into atmosphere
	 * @return greenhouse gases levels in atmosphere
	 */
	public double revageAthmoshere(Collection<Integer> greenHouseGasesList) {
		for (int greenhouseGases : greenHouseGasesList) {
			releaseGreenHouseGases(greenhouseGases);
		}
		return monitorRevageOfAthmosphere();
	}

	/**
	 * Void method with default access modifier to be mocked. Wraps static method call.
	 * 
	 * @param volume
	 *            volume of greenhouse gases to release
	 */
	void releaseGreenHouseGases(int volume) {
		Athmosphere.releaseGreenhouseGases(volume);
	}

	/**
	 * Method with return value and default access modifier to be mocked. Wraps static method call.
	 * 
	 * @return greenhouse gases level
	 */
	double monitorRevageOfAthmosphere() {
		return Athmosphere.getGreenhouseGassesLevel();
	}
}
