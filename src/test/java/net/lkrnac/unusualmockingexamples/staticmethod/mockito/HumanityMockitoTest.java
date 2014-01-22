package net.lkrnac.unusualmockingexamples.staticmethod.mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import net.lkrnac.unusualmockingexamples.staticmethod.mockito.HumanityMockito;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test demonstrating of static mocking workaround. Uses partial mocking of
 * static method wrappers.
 */
public class HumanityMockitoTest {
	private static final int BILION_TONS_CO2 = 5;
	private static final double GREENGOUSE_GASSES_LEVEL = 393.1;

	/**
	 * Test method demonstrating of static mocking workaround. Uses partial
	 * mocking of static method wrappers.
	 */
	@Test
	public void testRevageAthmoshere() {
		HumanityMockito humanity = new HumanityMockito();
		HumanityMockito humanitySpy = Mockito.spy(humanity);

		Mockito.doReturn(GREENGOUSE_GASSES_LEVEL).when(humanitySpy)
				.monitorRevageOfAthmosphere();
		Mockito.doNothing().when(humanitySpy)
				.releaseGreenHouseGases(BILION_TONS_CO2);

		// invoke testing method
		Collection<Integer> greenHouseGassesList = new ArrayList<>(
				Arrays.asList(BILION_TONS_CO2, BILION_TONS_CO2));
		double actualLevel = humanitySpy.revageAthmoshere(greenHouseGassesList);

		Assert.assertEquals(actualLevel, GREENGOUSE_GASSES_LEVEL);
		Mockito.verify(humanitySpy, Mockito.times(greenHouseGassesList.size()))
				.releaseGreenHouseGases(BILION_TONS_CO2);
	}
}
