package net.lkrnac.unusualmockingexamples.privatemethod.mockito;

/**
 * Used to demonstrate workaround when private method mock is needed
 */
public class Train {
	/**
	 * Public method used to demonstrate partial mocking
	 * 
	 * @return wagon count
	 */
	public int compose() {
		for (int idx = 0; idx < getWagonsCount(); idx++) {
			addWagon(0);
		}
		return getWagonsCount();
	}

	/**
	 * Access modifier was changed from private to default to enhance
	 * testability
	 * 
	 * @return number of wagons in train
	 */
	// private
	int getWagonsCount() {
		throw new UnsupportedOperationException("Fail if not mocked!");
	}

	/**
	 * Access modifier was changed from private to default to enhance
	 * testability
	 * 
	 * @param position
	 *            Target position of wagon in train. Zero value indicate append
	 *            at the end.
	 */
	// private
	void addWagon(int position) {
		throw new UnsupportedOperationException(
				"Fail if not mocked! [position=" + position + "]");
	}
}
