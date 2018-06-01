package org.datastructures.array;

import org.datastructures.model.Array;
import org.datastructures.type.queue.Queue;

public class ArrayQueue<E> extends AbstractArray<E> implements Queue<E> {

	public ArrayQueue(Array<E> data) {
		super(data);
	}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		if (size() == data.capacity()) {
			throw new IllegalStateException("Queue is full");
		}
		data.add(e);
	}

	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return data.get(firstIndex());
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}

		E temp = data.remove(firstIndex());
		return temp;
	}

}
