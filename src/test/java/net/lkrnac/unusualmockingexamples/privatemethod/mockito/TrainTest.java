package net.lkrnac.unusualmockingexamples.privatemethod.mockito;

import net.lkrnac.unusualmockingexamples.privatemethod.mockito.Train;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrate partial mock of class changed to make private method testable by
 * Mockito
 */
public class TrainTest {

	private static final int TESTING_WAGON_COUNT = 2;

	/**
	 * Demonstrate partial mocking on testing object
	 */
	@Test
	public void testCompose() {
		Train train = new Train();
		Train trainSpy = Mockito.spy(train);

		//notice that different Mockito syntax for spy   
		Mockito.doReturn(TESTING_WAGON_COUNT).when(trainSpy).getWagonsCount();
		Mockito.doNothing().when(trainSpy).addWagon(0);

		// invoke testing method
		int actualWagonCount = trainSpy.compose();

		Assert.assertEquals(actualWagonCount, TESTING_WAGON_COUNT);
		Mockito.verify(trainSpy, Mockito.times(TESTING_WAGON_COUNT))
				.addWagon(0);
	}
}
