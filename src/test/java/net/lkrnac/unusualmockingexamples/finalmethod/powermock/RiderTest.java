package net.lkrnac.unusualmockingexamples.finalmethod.powermock;

import net.lkrnac.unusualmockingexamples.finalmethod.Bike;
import net.lkrnac.unusualmockingexamples.finalmethod.powermockito.Rider;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrate final method mocking by PowerMock
 */
@PrepareForTest(Bike.class)
public class RiderTest extends PowerMockTestCase {
	private static final int TESTING_INITIAL_GEAR = 2;

	/**
	 * Test method that demonstrates final method mocking by PowerMock
	 */
	@Test
	public void testShiftGear() {
		Bike mock = PowerMockito.mock(Bike.class);

		Rider rider = new Rider(mock);
		Mockito.when(mock.getGear()).thenReturn(TESTING_INITIAL_GEAR);

		// invoke testing method
		int actualGear = rider.prepareForUphill();

		Assert.assertEquals(actualGear, TESTING_INITIAL_GEAR + 2);
		Mockito.verify(mock, Mockito.times(2)).shiftGear(true);
	}
}
