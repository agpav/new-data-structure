package org.ds.model;

public interface Array<E> extends Model<E>, Contiguous<E> {

	int capacity();

	int length();

	boolean isEmpty();

	E get(int index) throws IndexOutOfBoundsException;

	void add(E e);

	void insert(int index, E e) throws IndexOutOfBoundsException;

	E set(int index, E e) throws IndexOutOfBoundsException;

	E remove(int index) throws IndexOutOfBoundsException;

	void clear();

	String toString();

}