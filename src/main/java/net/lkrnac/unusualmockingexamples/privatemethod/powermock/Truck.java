package net.lkrnac.unusualmockingexamples.privatemethod.powermock;

import java.util.Collection;

/**
 * Used to demonstrate private methods mocking by PowerMock
 */
public class Truck {
	/**
	 * Testing method to demonstrate the private mocking
	 * 
	 * @param boxWeightsToAdd
	 *            collection of boxes weights to load
	 * @return total weight of the load
	 */
	public double addLoad(Collection<Double> boxWeightsToAdd) {
		for (Double boxWeight : boxWeightsToAdd) {
			addBoxToLoad(boxWeight);
		}
		return getLoadWeight();
	}

	/**
	 * Private method with return value to be mocked
	 * 
	 * @return weight
	 */
	private double getLoadWeight() {
		throw new UnsupportedOperationException("Fail is not mocked!");
	}

	/**
	 * Void private method to be mocked
	 * 
	 * @param weight
	 *            weight of the load
	 * 
	 */
	private void addBoxToLoad(double weight) {
		throw new UnsupportedOperationException("Fail is not mocked! [weight="
				+ weight + "]");
	}
}
