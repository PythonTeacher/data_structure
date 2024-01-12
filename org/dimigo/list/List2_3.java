package org.dimigo.list;

import java.util.NoSuchElementException;

// remove() 메소드 추가 구현하기
class MyLinkedList4<T> {
    public Node<T> head;
    public int size;

    // 추가 메소드
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        Node<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size)  // 마지막에 넣을 수 있으므로 > 이어야 함
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        if (index == 0) {
            addFirst(item);
        } else {
            Node<T> prev = getNode(index - 1);
            Node<T> newNode = new Node(item);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    public void addLast(T item) {
        add(size, item);
    }

    // addLast()와 동일
    public void add(T item) {
        addLast(item);
    }

    // 추가문제
    public void addAfter(Node<T> prev, T item) {
        Node<T> newNode = new Node(item);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException();
        else {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    // 추가문제
    public T removeAfter(Node<T> prev) {
        if (prev.next == null) throw new NoSuchElementException();
        else {
            T data = prev.next.data;
            prev.next = prev.next.next;
            size--;
            return data;
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        if (index == 0) {
            return removeFirst();
        } else {
            Node<T> prev = getNode(index - 1);
            if (prev.next == null) throw new NoSuchElementException();
            else {
                T data = prev.next.data;
                prev.next = prev.next.next;
                size--;
                return data;
            }
        }
    }

    // 추가문제
    public T remove(T item) {
        Node<T> p = head;
        Node<T> q = null;

        while (p != null && !p.data.equals(item)) {
            q = p;      // q는 항상 p의 직전 노드 가리킴
            p = p.next;
        }

        if (p == null) return null;
        if (q == null) return removeFirst();
        else return removeAfter(q);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    // removeFirst()와 동일
    public T remove() {
        return removeFirst();
    }

    // 노드들을 처음부터 순서대로 방문하는 것을 순회(Traverse)한다고 한다.
    // 순회하며 동일한 데이터가 들어있는 노드를 찾아 그 인덱스를 반환한다.
    public int indexOf(T item) {
        Node p = head;
        int index = 0;
        while (p != null) {
            if (p.data.equals(item)) {
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        return getNode(index).data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.data + " ");
            p = p.next;
        }
        return sb.toString();
    }
}

public class List2_3 {
    public static void main(String[] args) {
        MyLinkedList4<String> list = new MyLinkedList4();
        list.add("월요일");
        list.add("화요일");
        list.add("수요일");
        list.add("수요일");
        System.out.println(list);       // 월요일 화요일 수요일 수요일
        list.remove("화요일");
        System.out.println(list);       // 월요일 수요일 수요일
        list.remove("수요일");
        System.out.println(list);       // 월요일 수요일
    }
}