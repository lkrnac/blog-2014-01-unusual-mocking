package net.lkrnac.unusualmockingexamples.constructor.mockito;

import net.lkrnac.unusualmockingexamples.constructor.Car;
import net.lkrnac.unusualmockingexamples.constructor.mockito.CarFactoryMockito;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrates workaround how to enhance constructor testability
 */
public class CarFactoryMockitoTest {
	private static final String TESTING_TYPE = "Tatra";
	private static final String TESTING_COLOR = "Black";

	/**
	 * Test demonstrating partial mocking of constructor wrapper
	 */
	@Test
	public void testConstructCar() {
		CarFactoryMockito carFactory = new CarFactoryMockito();
		CarFactoryMockito carFactorySpy = Mockito.spy(carFactory);

		Car mockedInstance = Mockito.mock(Car.class);
		Mockito.doReturn(mockedInstance).when(carFactorySpy)
				.carFactoryMethod(TESTING_TYPE, TESTING_COLOR);

		// invoke testing method
		Car actualInstance = carFactorySpy.constructCar(TESTING_TYPE,
				TESTING_COLOR);

		Assert.assertEquals(actualInstance, mockedInstance);
		// ... verify other logic in constructCar() method ...
		Mockito.verify(carFactorySpy, Mockito.times(2)).carFactoryMethod(
				TESTING_TYPE, TESTING_COLOR);
	}
}
