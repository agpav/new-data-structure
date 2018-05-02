package org.ds.type;

public interface Queue<E> extends Type<E> {
	int size();

	boolean isEmpty();

	void enqueue(E e);

	E first();

	E dequeue();
}
