package org.ds.type;

public interface Deque<E> extends Type<E> {

	int size();

	boolean isEmpty();

	E first();

	E last();

	void addFirst(E e);

	void addLast(E e);

	E removeFirst();

	E removeLast();

}
