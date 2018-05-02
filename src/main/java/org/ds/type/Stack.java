package org.ds.type;

public interface Stack<E> extends Type<E> {

	int size();

	boolean isEmpty();

	void push(E e);

	E top();

	E pop();
}
