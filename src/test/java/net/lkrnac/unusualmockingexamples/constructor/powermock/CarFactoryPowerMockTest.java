package net.lkrnac.unusualmockingexamples.constructor.powermock;

import net.lkrnac.unusualmockingexamples.constructor.Car;
import net.lkrnac.unusualmockingexamples.constructor.powermock.CarFactoryPowerMock;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrates constructor mocking by PowerMock.
 * <p>
 * NOTE: Prepared in PowerMock annotation {@link PrepareForTest} should be class
 * where is constructor called
 */
@PrepareForTest(CarFactoryPowerMock.class)
public class CarFactoryPowerMockTest extends PowerMockTestCase {
	private static final String TESTING_TYPE = "Tatra";
	private static final String TESTING_COLOR = "Black";

	/**
	 * Test method that demonstrates constructor mocking by PowerMock.
	 * 
	 * @throws Exception
	 *             error in PowerMock
	 */
	@Test
	public void testConstructCar() throws Exception {
		Car expectedCar = Mockito.mock(Car.class);
		PowerMockito.whenNew(Car.class)
				.withArguments(TESTING_TYPE, TESTING_COLOR)
				.thenReturn(expectedCar);

		// invoke testing method
		CarFactoryPowerMock carFactory = new CarFactoryPowerMock();
		Car actualCar = carFactory.constructCar(TESTING_TYPE, TESTING_COLOR);

		Assert.assertEquals(actualCar, expectedCar);
		// ... verify other logic in constructCar() method ...
		PowerMockito.verifyNew(Car.class, Mockito.times(2)).withArguments(
				TESTING_TYPE, TESTING_COLOR);
	}
}
