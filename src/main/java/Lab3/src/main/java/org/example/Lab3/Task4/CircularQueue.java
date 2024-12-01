package org.example.Lab3.Task4;

public class CircularQueue<T> {
    private final T[] queue;
    private int front, rear, size;

    public CircularQueue(int capacity) {
        queue = (T[]) new Object[capacity];
        front = rear = size = 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T item) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return item;
    }
}
