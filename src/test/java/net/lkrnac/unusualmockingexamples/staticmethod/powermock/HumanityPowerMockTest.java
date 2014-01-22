package net.lkrnac.unusualmockingexamples.staticmethod.powermock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import net.lkrnac.unusualmockingexamples.staticmethod.Athmosphere;
import net.lkrnac.unusualmockingexamples.staticmethod.powermock.HumanityPowerMock;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test demonstrates static mocking by PowerMockito.
 */
@PrepareForTest(Athmosphere.class)
public class HumanityPowerMockTest extends PowerMockTestCase {
	private static final int BILION_TONS_CO2 = 5;
	private static final double GREENGOUSE_GASSES_LEVEL = 393.1;

	/**
	 * Test method demonstrates static mocking by PowerMock.
	 */
	@Test
	public void testRevageAthmoshere() {
		PowerMockito.mockStatic(Athmosphere.class);

		Mockito.when(Athmosphere.getGreenhouseGassesLevel()).thenReturn(
				GREENGOUSE_GASSES_LEVEL);

		// call of static method is required to mock it
		PowerMockito.doNothing().when(Athmosphere.class);
		Athmosphere.releaseGreenhouseGases(BILION_TONS_CO2);

		// invoke testing method
		Collection<Integer> greenHouseGassesList = new ArrayList<>(
				Arrays.asList(BILION_TONS_CO2, BILION_TONS_CO2));
		HumanityPowerMock humanity = new HumanityPowerMock();
		double actualLevel = humanity.revageAthmoshere(greenHouseGassesList);

		Assert.assertEquals(actualLevel, GREENGOUSE_GASSES_LEVEL);

		// call of static method is required to verify it
		PowerMockito.verifyStatic(Mockito.times(greenHouseGassesList.size()));
		Athmosphere.releaseGreenhouseGases(BILION_TONS_CO2);
	}
}
