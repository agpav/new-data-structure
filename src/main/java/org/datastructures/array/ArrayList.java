package org.datastructures.array;

import java.util.Iterator;

import org.datastructures.model.Array;
import org.datastructures.type.list.List;

public class ArrayList<E> extends AbstractArray<E> implements List<E> {

	public ArrayList(Array<E> data) {
		super(data);
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		return data.get(i);
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		return data.set(i, e);
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		data.insert(i, e);
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		return data.remove(i);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
