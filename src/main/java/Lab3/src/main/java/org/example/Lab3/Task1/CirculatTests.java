package org.example.Lab3.Task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircularQueueStressTests {

    @Test
    void testEnqueueSpecialSymbols() {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.enqueue("🚗");
        queue.enqueue("特斯拉");
        queue.enqueue("Über");

        assertTrue(queue.isFull(), "Queue should be full after enqueuing three elements.");
        assertEquals(3, queue.size, "Queue size should be 3.");


        assertEquals("🚗", queue.elements[0], "Element at index 0 should be '🚗'.");
        assertEquals("特斯拉", queue.elements[1], "Element at index 1 should be '特斯拉'.");
        assertEquals("Über", queue.elements[2], "Element at index 2 should be 'Über'.");
    }

    @Test
    void testEnqueueDequeueSequence() {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.enqueue("Toyota");
        queue.enqueue("Honda");
        queue.enqueue("Ford");

        assertEquals(3, queue.size, "Queue size should be 3 after enqueuing three elements.");
        assertTrue(queue.isFull(), "Queue should be full.");

        queue.dequeue();
        assertEquals(2, queue.size, "Queue size should be 2 after one dequeue.");
        assertFalse(queue.isFull(), "Queue should not be full after one dequeue.");


        assertNull(queue.elements[0], "Index 0 should be empty after dequeuing 'Toyota'.");
        assertEquals("Honda", queue.elements[1], "Element at index 1 should be 'Honda'.");
        assertEquals("Ford", queue.elements[2], "Element at index 2 should be 'Ford'.");
    }

    @Test
    void testQueueCapacityLimit() {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.enqueue("Car3");


        queue.enqueue("Car4");

        assertEquals(3, queue.size, "Queue size should remain 3 after attempting to enqueue a fourth element.");
        assertTrue(queue.isFull(), "Queue should be full and not accept the fourth element.");


        assertEquals("Car1", queue.elements[0], "First element should still be 'Car1'.");
        assertEquals("Car2", queue.elements[1], "Second element should still be 'Car2'.");
        assertEquals("Car3", queue.elements[2], "Third element should still be 'Car3'.");
    }

    @Test
    void testAlternatingEnqueueDequeue() {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.dequeue();
        queue.enqueue("Car3");

        assertEquals(2, queue.size, "Queue size should be 2 after alternating enqueue and dequeue.");
        assertFalse(queue.isFull(), "Queue should not be full.");


        assertNull(queue.elements[0], "Index 0 should be empty after dequeuing 'Car1'.");
        assertEquals("Car2", queue.elements[1], "Element at index 1 should be 'Car2'.");
        assertEquals("Car3", queue.elements[2], "Element at index 2 should be 'Car3'.");
    }

    @Test
    void testFullWrapAround() {
        CircularQueue<String> queue = new CircularQueue<>(3);


        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");


        queue.dequeue();
        queue.dequeue();


        queue.enqueue("D");
        queue.enqueue("E");

        assertEquals(3, queue.size, "Queue should be full after wrap-around enqueues.");
        assertTrue(queue.isFull(), "Queue should be full.");


        assertEquals("D", queue.elements[0], "Element at index 0 should be 'D' after wrap-around.");
        assertEquals("E", queue.elements[1], "Element at index 1 should be 'E' after wrap-around.");
        assertEquals("C", queue.elements[2], "Element at index 2 should be 'C'.");
    }

    @Test
    void testDequeueAllElements() {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.enqueue("X");
        queue.enqueue("Y");
        queue.enqueue("Z");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements.");
        assertEquals(-1, queue.front, "Front should be reset to -1.");
        assertEquals(-1, queue.rear, "Rear should be reset to -1.");
    }


}
