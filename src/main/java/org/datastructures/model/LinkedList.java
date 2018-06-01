package org.datastructures.model;

public interface LinkedList<E> extends Model<E>, NonContiguous<E> {

	// Returns the number of elements in the list
	int size();

	// Returns true if the list is empty, and false otherwise
	boolean isEmpty();

	// Returns (but does not remove) the first element in the list
	E first();

	// Returns (but does not remove) the last element in the list
	E last();

	// Adds a new element to the front of the list
	void addFirst(E e);

	// Adds a new element to the end of the list
	void addLast(E e);

	E removeFirst();
}
