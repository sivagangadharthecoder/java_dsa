public class DoublyNode {
    private Person data;
    private DoublyNode next;
    private DoublyNode prev;

    public DoublyNode() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public DoublyNode(Person data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Getters and Setters
    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "[id=" + data.getId() + ", name=" + data.getName() + "]";
    }
}