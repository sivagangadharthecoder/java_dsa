public class StackDemo {
    public static void runMenu() {
        int choice = 0;
        int numberOfOperations = 20;
        StackUsingSinglyList stack = new StackUsingSinglyList();
        do {
            System.out.print(
                    "\n1:Push 2:Pop 3:Peek 4:Display 5:Check if Empty 6:Exit. Your Choice: ");
            choice = SinglyList.scanner.nextInt();
            switch (choice) {
                case 1:
                    stack.push();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Stack is " + (stack.isEmpty() ? "empty" : "not empty"));
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