package org.ds.util;

public class Util {

	public static void checkIndex(int index, int n) throws IndexOutOfBoundsException {
		if (index < 0 || index >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + index);
		}
	}

}
