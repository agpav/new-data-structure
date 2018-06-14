package org.ds.array;

import org.ds.model.Array;

public class AbstractArray<E> {

	// underlying array storage
	protected Array<E> data;

	protected AbstractArray(Array<E> data) {
		this.data = data;
	}

	public int size() {
		return data.length();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public String toString() {
		return data.toString();
	}

	protected int firstIndex() {
		return 0;
	}

	protected int lastIndex() {
		if (data.isEmpty()) {
			return 0;
		}
		return data.length() - 1;
	}
}
