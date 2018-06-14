package org.datastructures.array;

import static org.junit.Assert.assertEquals;

import org.ds.ADTException;
import org.ds.ADTFactory;
import org.ds.model.Array;
import org.ds.type.list.List;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

	private List<String> list;

	@Before
	public void setup() throws ADTException {
		list = ADTFactory.get(List.class, Array.class, 10);
	}

	@Test
	public void test() {
		list.add(0, "A");
		assertEquals("[A]", list.toString());

		list.add(0, "B");
		assertEquals("[B, A]", list.toString());

		String x = list.get(1);
		assertEquals("A", x);

		try {
			x = null;
			x = list.set(2, "C");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(null, x);
		}

		list.add(2, "C");
		assertEquals("[B, A, C]", list.toString());

		try {
			x = list.set(4, "D");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(null, x);
		}

		x = list.remove(1);
		assertEquals("A", x);
		assertEquals("[B, C]", list.toString());

		list.add(1, "D");
		assertEquals("[B, D, C]", list.toString());

		list.add(1, "E");
		assertEquals("[B, E, D, C]", list.toString());

		try {
			x = null;
			x = list.get(4);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(null, x);
		}

		list.add(4, "F");
		assertEquals("[B, E, D, C, F]", list.toString());

		x = list.set(2, "G");
		assertEquals("D", x);
		assertEquals("[B, E, G, C, F]", list.toString());

		x = list.get(2);
		assertEquals("G", x);
		assertEquals("[B, E, G, C, F]", list.toString());
	}
}
