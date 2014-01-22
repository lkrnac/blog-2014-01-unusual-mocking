package net.lkrnac.unusualmockingexamples.staticmethod.powermock;

import java.util.Collection;

import net.lkrnac.unusualmockingexamples.staticmethod.Athmosphere;

/**
 * Used to demonstrate static mocking by PowerMock
 */
public class HumanityPowerMock {
	/**
	 * Method used to demonstrate static mocking
	 * 
	 * @param greenHouseGasesList
	 *            list of greenhouse gases amounts to release into atmosphere
	 * @return greenhouse gases levels in atmosphere
	 */
	public double revageAthmoshere(Collection<Integer> greenHouseGasesList) {
		for (int greenhouseGases : greenHouseGasesList) {
			Athmosphere.releaseGreenhouseGases(greenhouseGases);
		}
		return Athmosphere.getGreenhouseGassesLevel();
	}
}
