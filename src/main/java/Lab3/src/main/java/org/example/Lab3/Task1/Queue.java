package org.example.Lab3.Task1;

public interface Queue<T> {
    public boolean isFull();
    public void enqueue(T car);

    public void dequeue();

    public boolean isEmpty();

    public void displayQueue();
    public void isRefueling();
    public void wasRefueled();
}