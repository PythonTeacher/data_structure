package org.dimigo.array;

import java.util.Arrays;

// ArrayList 직접 구현하기 (난이도:상)
interface IMyArrayList<E> {
    void add(E data);
    void add(int index, E element);
    E set(int index, E element);
    E remove(int index);
    void clear();
    E get(int index);
    int size();
}

class MyArrayList implements IMyArrayList {

    Object[] array = null;
    int incSize = 3;
    int size = 0;

    public MyArrayList() {
        array = new Object[incSize];
    }

    @Override
    public void add(Object data) {
        array[size++] = data;
        if (array.length > size) {
            array = Arrays.copyOf(array, array.length + incSize);
        }
    }

    @Override
    public void add(int index, Object element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + incSize);
        }
        System.arraycopy(array, index, array, index + 1,size - index);
        array[index] = element;
        size++;
    }

    @Override
    public Object set(int index, Object element) {
        array[index] = element;
        return element;
    }

    @Override
    public Object remove(int index) {
        Object oldValue = array[index];
        if (size - 1 > index)
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size-- - 1] = null;
        return oldValue;
    }

    @Override
    public void clear() {
        for(int i=0; i<size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index < size) return array[index];
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }
}

public class Array3_2 {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("사과");
        list.add("배");
        list.add("바나나");
        list.add("감");
        list.add("귤");
        list.add(1, "사과2");
        list.add(1, "사과3");
        list.add(1, "사과4");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
        list.clear();
        System.out.println(list);
        System.out.println(list.size());
    }
}