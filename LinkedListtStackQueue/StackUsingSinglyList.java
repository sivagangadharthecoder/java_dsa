public class StackUsingSinglyList {
    private SinglyList stackList;

    public StackUsingSinglyList() {
        stackList = new SinglyList();
    }

    public void push() {
        stackList.insertAtFront();
    }

    public void pop() {
        stackList.deleteFromFront();
    }

    public void peek() {
        if (stackList.getHead() == null) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top element: " + stackList.getHead().getData());
    }

    public boolean isEmpty() {
        return stackList.getHead() == null;
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        stackList.displayFromFront();
    }
}