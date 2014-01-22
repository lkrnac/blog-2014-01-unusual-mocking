package net.lkrnac.unusualmockingexamples.privatemethod.powermock;

import java.util.Arrays;
import java.util.Collection;

import net.lkrnac.unusualmockingexamples.privatemethod.powermock.Truck;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test demonstrating bypassing encapsulation by PowerMock
 */
@PrepareForTest(Truck.class)
public class TruckTest extends PowerMockTestCase {
	private static final double TESTING_LOAD_WEIGHT = 200;
	private static final double TESTING_BOX_WEIGHT = 100;

	/**
	 * Test method to demonstrate bypassing encapsulation by PowerMock
	 * 
	 * @throws Exception
	 *             if PowerMock error is thrown
	 */
	@Test
	public void testTestingMethod() throws Exception {
		Truck truck = new Truck();
		Truck truckSpy = PowerMockito.spy(truck);

		PowerMockito.doReturn(TESTING_LOAD_WEIGHT).when(truckSpy,
				"getLoadWeight");
		PowerMockito.doNothing().when(truckSpy, "addBoxToLoad",
				TESTING_BOX_WEIGHT);

		// call testing method
		Collection<Double> boxesWeights = Arrays.asList(TESTING_BOX_WEIGHT,
				TESTING_BOX_WEIGHT);
		double actualLoad = truckSpy.addLoad(boxesWeights);

		Assert.assertEquals(actualLoad, TESTING_LOAD_WEIGHT);
		PowerMockito.verifyPrivate(truckSpy, Mockito.times(2)).invoke(
				"addBoxToLoad", TESTING_BOX_WEIGHT);
	}
}
