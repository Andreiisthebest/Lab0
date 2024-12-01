package org.example.Lab3.Task1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriorityQueueTests{
    private PriorityQueue queue;

    @Before
    public void setUp() {
        queue = new PriorityQueue();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("Car1", 3);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull());
        queue.enqueue("Car1", 1);
        queue.enqueue("Car2", 2);
        queue.enqueue("Car3", 3);
        queue.enqueue("Car4", 4);
        queue.enqueue("Car5", 5);
        queue.enqueue("Car5", 5);
        assertTrue(queue.isFull());
    }

    @Test
    public void testPriorityOrdering() {
        queue.enqueue("Low priority car", 1);
        queue.enqueue("High priority car", 5);
        queue.enqueue("Medium priority car", 3);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueFullBehavior() {
        queue.enqueue("Car1", 1);
        queue.enqueue("Car2", 2);
        queue.enqueue("Car3", 3);
        queue.enqueue("Car4", 4);
        queue.enqueue("Car5", 5);
        queue.enqueue("Car6", 6);

        assertTrue(queue.isFull());
    }

    @Test
    public void testEmptyQueueDequeue() {
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSamePriority() {
        queue.enqueue("First", 3);
        queue.enqueue("Second", 3);
        queue.enqueue("Third", 3);

        assertFalse(queue.isEmpty());
    }
}