package org.datastructures.model.impl;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtil {

	public static <E> void clear(E[] data) {
		Arrays.stream(data).forEach(e -> e = null);
	}

	public static <E> String toString(E[] data, String separator) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(Arrays.stream(data).filter(e -> e != null).map(Object::toString)
				.collect(Collectors.joining(separator)));
		sb.append("]");
		return sb.toString();
	}

	public static <E> void copy(E[] src, E[] dest) {
		for (int k = 0; k < src.length; k++) {
			dest[k] = src[k];
		}
	}

	public static <E> void shiftLeft(E[] data, int index, int length) {
		for (int k = index; k < length - 1; k++) {
			data[k] = data[k + 1];
		}
	}

	public static <E> void shiftRight(E[] data, int index, int length) {
		for (int k = length - 1; k >= index; k--) {
			data[k + 1] = data[k];
		}
	}

}
