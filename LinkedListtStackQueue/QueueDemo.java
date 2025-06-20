public class QueueDemo {
    public static void runMenu() {
        int choice = 0;
        int numberOfOperations = 20;
        QueueUsingSinglyList queue = new QueueUsingSinglyList();
        do {
            System.out.print(
                    "\n1:Enqueue 2:Dequeue 3:Peek 4:Display 5:Check if Empty 6:Exit. Your Choice: ");
            choice = SinglyList.scanner.nextInt();
            switch (choice) {
                case 1:
                    queue.enqueue();
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Queue is " + (queue.isEmpty() ? "empty" : "not empty"));
                    break;
                case 6:
                    numberOfOperations = 0;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            numberOfOperations--;
        } while (numberOfOperations >= 1);
    }

    public static void main(String[] args) {
        runMenu();
        System.out.println("End of Program");
    }
}