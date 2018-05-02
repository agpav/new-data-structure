package org.ds.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.ds.array.impl.ArrayDeque;
import org.ds.array.impl.ArrayList;
import org.ds.array.impl.ArrayQueue;
import org.ds.array.impl.ArrayStack;
import org.ds.model.Array;
import org.ds.model.LinkedList;
import org.ds.model.impl.ArrayImpl;
import org.ds.type.Deque;
import org.ds.type.List;
import org.ds.type.Queue;
import org.ds.type.Stack;

public class DSFactory { // <T extends Type<?>, M extends Model<?>> {

	private static Map<Class<?>, Class<?>> map = new HashMap<>();

	static {
		map.put(Array.class, ArrayImpl.class);
		map.put(Stack.class, ArrayStack.class);
		map.put(Queue.class, ArrayQueue.class);
		map.put(List.class, ArrayList.class);
		map.put(Deque.class, ArrayDeque.class);
	}

	public static <T, M> T get(Class<T> typeCls, M model) throws DSException {
		return getType(typeCls, model);
	}

	public static <T, M> T get(Class<T> typeCls, Class<M> modelCls) throws DSException {
		return get(typeCls, modelCls, null);
	}

	public static <T, M> T get(Class<T> typeCls, Class<M> modelCls, Object capacity) throws DSException {
		M model = getModel(modelCls, capacity);
		return getType(typeCls, model);
	}

	private static <M> M getModel(Class<M> modelCls, Object param) throws DSException {
		M model = null;
		if (param == null) {
			model = newInstance(getConstructor(getImpl(modelCls), null), null);
		} else {
			model = newInstance(getConstructor(getImpl(modelCls), int.class), param);
		}
		return model;
	}

	private static <T, M> T getType(Class<T> typeCls, M model) throws DSException {
		T type = null;
		if (model instanceof Array) {
			type = newInstance(getConstructor(getImpl(typeCls), Array.class), model);
		} else {
			type = newInstance(getConstructor(getImpl(typeCls), LinkedList.class), model);
		}
		return type;
	}

	private static Class<?> getImpl(Class<?> iFace) {
		Class<?> impl = map.get(iFace);
		return impl;
	}

	private static Constructor<?> getConstructor(Class<?> cls, Class<?> param) throws DSException {
		try {
			Constructor<?> ctor = null;
			if (param == null) {
				ctor = cls.getConstructor();
			} else {
				ctor = cls.getConstructor(param);
			}
			return ctor;
		} catch (NoSuchMethodException | SecurityException e) {
			throw new DSException(e);
		}
	}

	private static <T> T newInstance(Constructor<?> ctor, Object param) throws DSException {
		try {
			T t = null;
			if (param == null) {
				t = (T) ctor.newInstance();
			} else {
				t = (T) ctor.newInstance(param);
			}
			return t;
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new DSException(e);
		}
	}

	// public static <E> Stack<E> getDS(Class<Stack> typeClz, Class<Array> modelClz)
	// throws DSException {
	// try {
	// Array<E> model = modelClz.newInstance();
	// Stack<E> type = typeClz.getConstructor(Model.class).newInstance(model);
	// return type;
	// } catch (InstantiationException | IllegalAccessException |
	// IllegalArgumentException | InvocationTargetException
	// | NoSuchMethodException | SecurityException e) {
	// throw new DSException(e);
	// }
	// }

}

enum Category {
	ARRAY_IMPL, LL_IMPL;
}

class TypeDef {

	private static Map<Class<?>, Class<?>> map = new HashMap<>();

	private Class<?> iFace;

}