package net.lkrnac.unusualmockingexamples.finalclass.powermock;

import net.lkrnac.unusualmockingexamples.finalclass.Plane;
import net.lkrnac.unusualmockingexamples.finalclass.powermock.Pilot;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test demonstrating static class mocking by PowerMock
 */
@PrepareForTest(Plane.class)
public class PilotTest extends PowerMockTestCase {
	/**
	 * Demonstrate static class mocking
	 */
	@Test
	public void testReadyForFlight() {
		Plane planeMock = PowerMockito.mock(Plane.class);
		Pilot pilot = new Pilot(planeMock);

		Mockito.when(planeMock.verifyAllSystems()).thenReturn(true);

		// testing method
		boolean actualStatus = pilot.readyForFlight();

		Assert.assertEquals(actualStatus, true);
		Mockito.verify(planeMock).startEngine(Plane.ENGINE_ID_LEFT);
		Mockito.verify(planeMock).startEngine(Plane.ENGINE_ID_RIGHT);
	}
}
