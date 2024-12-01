package org.example.Lab3.Task5;

public interface Queue<T> {
    public boolean isFull();
    public void enqueue(T car);

    public Object dequeue();

    public boolean isEmpty();

    public void printQueue();

}
