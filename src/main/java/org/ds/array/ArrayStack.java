package org.ds.array;

import org.ds.model.Array;
import org.ds.type.stack.Stack;

public class ArrayStack<E> extends AbstractArray<E> implements Stack<E> {

	public ArrayStack(Array<E> data) {
		super(data);
	}

	@Override
	public void push(E e) throws IllegalStateException {
		if (size() == data.capacity()) {
			throw new IllegalStateException("Stack is full");
		}
		data.add(e);
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return data.get(lastIndex());
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E temp = data.remove(lastIndex());
		return temp;
	}

}
