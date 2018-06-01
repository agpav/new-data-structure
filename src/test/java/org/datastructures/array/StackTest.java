package org.datastructures.array;

import static org.junit.Assert.assertEquals;

import org.datastructures.ADTException;
import org.datastructures.ADTFactory;
import org.datastructures.model.Array;
import org.datastructures.type.stack.Stack;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

	private Stack<Integer> stack;

	@Before
	public void setup() throws ADTException {
		stack = ADTFactory.get(Stack.class, Array.class, 10);
	}

	@Test
	public void test() {
		stack.push(5);
		assertEquals("[5]", stack.toString());
		stack.push(3);
		assertEquals("[5, 3]", stack.toString());
		assertEquals(2, stack.size());

		int x = stack.pop();
		assertEquals(3, x);
		assertEquals("[5]", stack.toString());

		assertEquals(false, stack.isEmpty());

		x = stack.pop();
		assertEquals(5, x);
		assertEquals("[]", stack.toString());

		assertEquals(true, stack.isEmpty());

		Object y = stack.pop();
		assertEquals(null, y);
		assertEquals("[]", stack.toString());

		stack.push(7);
		assertEquals("[7]", stack.toString());

		stack.push(9);
		assertEquals("[7, 9]", stack.toString());

		x = stack.top();
		assertEquals(9, x);

		stack.push(4);
		assertEquals("[7, 9, 4]", stack.toString());

		assertEquals(3, stack.size());

		x = stack.pop();
		assertEquals(4, x);
		assertEquals("[7, 9]", stack.toString());

		stack.push(6);
		assertEquals("[7, 9, 6]", stack.toString());

		stack.push(8);
		assertEquals("[7, 9, 6, 8]", stack.toString());

		x = stack.pop();
		assertEquals(8, x);
		assertEquals("[7, 9, 6]", stack.toString());
	}
}
