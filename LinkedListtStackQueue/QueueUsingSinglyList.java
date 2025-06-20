public class QueueUsingSinglyList {
    private SinglyList queueList;
    
    public QueueUsingSinglyList() {
        queueList = new SinglyList();
    }
    
    // Enqueue operation - add to rear of queue
    public void enqueue() {
        queueList.insertAtRear();
    }
    
    // Dequeue operation - remove from front of queue
    public void dequeue() {
        queueList.deleteFromFront();
    }
    
    // Peek operation - view front element without removing
    public void peek() {
        if (queueList.getHead() == null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element: " + queueList.getHead().getData());
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return queueList.getHead() == null;
    }
    
    // Display queue from front to rear
    public void display() {
        System.out.println("Queue contents (front to rear):");
        queueList.displayFromFront();
    }
    
    // We'll use the existing getHead() method from SinglyList
}