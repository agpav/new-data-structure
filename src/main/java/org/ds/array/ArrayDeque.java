package org.ds.array;

import org.ds.model.Array;
import org.ds.type.queue.Deque;

public class ArrayDeque<E> extends AbstractArray<E> implements Deque<E> {

	public ArrayDeque(Array<E> data) {
		super(data);
	}

	@Override
	public E first() {
		return data.get(firstIndex());
	}

	@Override
	public E last() {
		return data.get(lastIndex());
	}

	@Override
	public void addFirst(E e) {
		data.insert(firstIndex(), e);
	}

	@Override
	public void addLast(E e) {
		data.add(e);
	}

	@Override
	public E removeFirst() {
		E e = data.remove(firstIndex());
		return e;
	}

	@Override
	public E removeLast() {
		E e = data.remove(lastIndex());
		return e;
	}

}
