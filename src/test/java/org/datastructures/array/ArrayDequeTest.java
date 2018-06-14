package org.datastructures.array;

import static org.junit.Assert.assertEquals;

import org.ds.ADTException;
import org.ds.ADTFactory;
import org.ds.model.Array;
import org.ds.type.queue.Deque;
import org.junit.Before;
import org.junit.Test;

public class ArrayDequeTest {

	private Deque<Integer> deque;

	@Before
	public void setup() throws ADTException {
		deque = ADTFactory.get(Deque.class, Array.class, 10);
	}

	@Test
	public void test() {

		deque.addLast(5);
		assertEquals("[5]", deque.toString());

		deque.addFirst(3);
		assertEquals("[3, 5]", deque.toString());

		deque.addFirst(7);
		assertEquals("[7, 3, 5]", deque.toString());

		int x = deque.first();
		assertEquals(7, x);
		assertEquals("[7, 3, 5]", deque.toString());

		x = deque.removeLast();
		assertEquals(5, x);
		assertEquals("[7, 3]", deque.toString());

		x = deque.size();
		assertEquals(2, x);
		assertEquals("[7, 3]", deque.toString());

		x = deque.removeLast();
		assertEquals(3, x);
		assertEquals("[7]", deque.toString());

		x = deque.removeFirst();
		assertEquals(7, x);
		assertEquals("[]", deque.toString());

		deque.addFirst(6);
		assertEquals("[6]", deque.toString());

		x = deque.last();
		assertEquals(6, x);
		assertEquals("[6]", deque.toString());

		deque.addFirst(8);
		assertEquals("[8, 6]", deque.toString());

		assertEquals(false, deque.isEmpty());

		x = deque.last();
		assertEquals(6, x);
		assertEquals("[8, 6]", deque.toString());
	}

}
