package org.datastructures.array;

import static org.junit.Assert.assertEquals;

import org.datastructures.model.Array;
import org.datastructures.model.impl.ArrayImpl;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {

	private Array<Integer> array;

	@Before
	public void setup() {
		array = new ArrayImpl<>();
	}

	@Test
	public void add() {
		array.add(5);
		array.add(4);
		assertEquals("[5, 4]", array.toString());
		array.clear();
	}

	@Test
	public void length() {
		array.add(5);
		array.add(4);
		assertEquals(2, array.length());
		array.clear();
	}

	@Test
	public void get() {
		array.add(5);
		array.add(4);
		int x = array.get(0);
		assertEquals(5, x);
		array.clear();
	}

	@Test
	public void capacity() {
		assertEquals(1000, array.capacity());
	}

}
