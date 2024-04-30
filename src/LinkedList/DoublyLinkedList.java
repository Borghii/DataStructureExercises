package LinkedList;

public class DoublyLinkedList <T>{

    private static class Node <T>{
        private T element;
        private Node<T> next;
        private Node<T> previous;
        public Node(T element, Node<T> next, Node<T> previous){
            this.element=element;
            this.next=next;
            this.previous=previous;
        }

        public Node() {
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }

    private final Node<T> header = new Node<>();
    private final Node<T> trailer=new Node<>();
    private int size=0;

    public DoublyLinkedList() {
        header.setNext(trailer);
        trailer.setPrevious(header);
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public T first(){
        if (isEmpty()) return null;
        return header.getNext().element;
    }
    public T last(){
        if (isEmpty()) return null;
        return trailer.getPrevious().element;
    }

    public void addFirst(T element){
        Node <T> newest;

        newest = new Node<>(element,header.getNext(),header);

        header.setNext(newest);
        newest.next.setPrevious(newest);
        size++;
    }

    public void addLast(T element){
        Node <T> newest;

        newest = new Node<>(element,trailer,trailer.previous);

        trailer.setPrevious(newest);
        newest.previous.setNext(newest);
        size++;

    }

    public T removeFirst(){
        if (isEmpty())return null;

        T element = header.next.element;

        header.setNext(header.next.next);
        header.next.next.setPrevious(header);

        size--;

        return element;
    }

    public T removeLast(){
        if (isEmpty())return null;

        T element = trailer.previous.element;

        trailer.setPrevious(trailer.previous.previous);
        trailer.previous.previous.setNext(trailer);

        size--;

        return element;
    }

    public Node<T> returnMiddle() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }

        Node<T> tempA = header.next;
        Node<T> tempB = trailer.previous;

        while (tempA != tempB && tempA.next != tempB) {
            tempA = tempA.next;
            tempB = tempB.previous;
        }

        // Si la lista tiene un número impar de nodos, tempA apuntará al nodo medio
        // Si la lista tiene un número par de nodos, tempA apuntará al nodo que está justo antes del medio
        return tempA;
    }

    public int getSizeWithoutInstance(){
        if (header.getNext()==trailer)return 0;
        int cont = 1;

        Node <T> tempA = header.getNext();
        Node <T> tempB = trailer.getPrevious();

        while (tempA != tempB && tempA.getNext()!=tempB){
            tempA=tempA.getNext();
            tempB=tempB.getPrevious();
            cont+=2;
        }

        return tempA==tempB ? cont: cont+1;

    }



    public static void main(String[] args) {
        var doublyList = new DoublyLinkedList<Integer>();
        var doublyList2 = new DoublyLinkedList<Integer>();
        doublyList.addFirst(1);
        doublyList.addFirst(2);
        doublyList.addFirst(4);
        doublyList.addFirst(5);
        doublyList.addFirst(5);

        doublyList2.addFirst(9);


        System.out.println(doublyList2.getSizeWithoutInstance());

    }





}
