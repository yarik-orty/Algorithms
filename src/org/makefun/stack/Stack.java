package org.makefun.stack;

public final class Stack<T> {

    private final Object[] elements;
    private final int capacity;
    private int top;

    public Stack(int size) {
        this.elements = new Object[size];
        this.capacity = size;
        this.top = -1;
    }

    public void push(T item) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            elements[++top] = item;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return toElement(elements[top--]);
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i <= top; i++) {
            System.out.print(elements[i] + " ");
        }
    }

    private T toElement(Object obj) {
        return (T) obj;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top >= capacity - 1;
    }
}
