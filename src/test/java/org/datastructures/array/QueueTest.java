package org.datastructures.array;

import static org.junit.Assert.assertEquals;

import org.ds.ADTException;
import org.ds.ADTFactory;
import org.ds.model.Array;
import org.ds.type.queue.Queue;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	private Queue<Integer> queue;

	@Before
	public void setup() throws ADTException {
		queue = ADTFactory.get(Queue.class, Array.class, 10);
	}

	@Test
	public void test() {
		queue.enqueue(5);
		assertEquals("[5]", queue.toString());

		queue.enqueue(3);
		assertEquals("[5, 3]", queue.toString());

		assertEquals(2, queue.size());

		int x = queue.dequeue();
		assertEquals(5, x);
		assertEquals("[3]", queue.toString());
		assertEquals(false, queue.isEmpty());

		x = queue.dequeue();
		assertEquals(3, x);
		assertEquals("[]", queue.toString());
		assertEquals(true, queue.isEmpty());

		Object y = queue.dequeue();
		assertEquals(null, y);
		assertEquals("[]", queue.toString());

		queue.enqueue(7);
		assertEquals("[7]", queue.toString());

		queue.enqueue(9);
		assertEquals("[7, 9]", queue.toString());

		x = queue.first();
		assertEquals(7, x);

		queue.enqueue(4);
		assertEquals("[7, 9, 4]", queue.toString());
	}

}
