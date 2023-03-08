public class SinglyLinkedList1<I> {
    private static class Node<I>{
        private I element;
        private Node<I> next;
        private Node<I> penul;

        public Node(I e, Node<I> n) {
            element = e;
            next = n;
            penul = null;
        }
        public I getElement() {return element;}
        public Node<I> getNext(){return next;}
        public void setNext(Node<I> n) {next = n;}
        public Node<I> penul(Node<I> head) {
            Node<I> current = head;
            while(current != null) {
                if(head.getNext() == null) {
                    penul = head;
                }
                else {
                    current = current.getNext();
                }
            }
            return penul;
        }
    }

    private Node<I> head = null;
    private Node<I> tail = null;
    private int size = 0;

    public SinglyLinkedList1() {}

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public I first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }
    public I last() {
        if(isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
    public void addFirst(I i) {
        head = new Node<> (i, head);
        if(size == 0) {
            tail = head;
        }
        size++;
    }
    public void addLast(I i) {
        Node<I> newest = new Node<>(i,null);
        if(isEmpty()) {
            head = newest;
        }
        else {
            tail.setNext(newest);
            tail = newest;
            size++;
        }
    }
    public I removeFirst() {
        if(isEmpty()) {
            return null;
        }
        I answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0) {
            tail = null;
        }
        return answer;
    }
    public void getPenultimate() {

        if (isEmpty()) {
            System.out.println("List is empty. Please check.");
        } else {
            System.out.println(" second last node is: " + head.penul(head));
        }
    }}