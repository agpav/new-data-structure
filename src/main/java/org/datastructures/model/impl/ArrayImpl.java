package org.datastructures.model.impl;

import org.datastructures.Util;
import org.datastructures.model.Array;

/**
 * get() -> O(1) add() -> O(n) if no resize then O(1) insert() -> O(n) set() ->
 * O(1) remove() -> O(n) clear() -> O(n) resize() -> O(n)
 * 
 * @author Pavan
 *
 * @param <E>
 */
public class ArrayImpl<E> implements Array<E> {

	// default array capacity
	public static final int CAPACITY = 1000;

	// generic array used for storage
	private E[] data;

	// total length of array
	private int capacity;

	// number of actual entries
	private int length = 0;

	// constructs array with default capacity
	public ArrayImpl() {
		this(CAPACITY);
	}

	// constructs array with given capacity
	public ArrayImpl(int capacity) {
		this.capacity = capacity;
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#capacity()
	 */
	@Override
	public int capacity() {
		return capacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#length()
	 */
	@Override
	public int length() {
		return length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (length == 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#get(int)
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		Util.checkIndex(index, length);
		return data[index];
	}

	// add to end
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#add(E)
	 */
	@Override
	public void add(E e) {
		resize();
		data[length] = e;
		length++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#insert(int, E)
	 */
	@Override
	public void insert(int index, E e) throws IndexOutOfBoundsException {
		Util.checkIndex(index, length + 1);
		resize();

		// start by shifting rightmost
		ArrayUtil.shiftRight(data, index, length);

		data[index] = e;
		length++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#set(int, E)
	 */
	@Override
	public E set(int index, E e) throws IndexOutOfBoundsException {
		Util.checkIndex(index, length);
		E temp = data[index];
		data[index] = e;
		return temp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#remove(int)
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Util.checkIndex(index, length);
		E temp = data[index]; // save the object to be removed

		// shift elements to fill hole
		ArrayUtil.shiftLeft(data, index, length);

		data[length - 1] = null; // null out the old
		length--;
		return temp; // return the removed object
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#clear()
	 */
	@Override
	public void clear() {
		ArrayUtil.clear(data);
	}

	// Resizes internal array to have given capacity >= size
	protected void resize() {

		// check if resize reqd.
		if (length < capacity) {
			return;
		}

		// double from original capacity
		capacity = 2 * capacity;
		E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning

		// copy
		ArrayUtil.copy(data, temp);

		// start using the new array
		data = temp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ds.model.impl.Array#toString()
	 */
	@Override
	public String toString() {
		String str = ArrayUtil.toString(data, ", ");
		return str;
	}

}