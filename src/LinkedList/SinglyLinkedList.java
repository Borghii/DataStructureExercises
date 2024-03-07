package LinkedList;

public class SinglyLinkedList<E> {

    private static class Node<E>{
        private E value;
        private Node<E> referenceValue;

        public Node(E value, Node<E> referenceValue){
            this.value=value;
            this.referenceValue=referenceValue;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public void setReferenceValue(Node<E> referenceValue) {
            this.referenceValue = referenceValue;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getReferenceValue() {
            return referenceValue;
        }
    }

    private static int size;
    private Node<E> head = null;
    private Node<E> tail = null;

    public SinglyLinkedList() {}

    public void addFirst(E value){
        head = new Node<>(value,head);
        if (size==0)
            tail=head;
        size++;
    }

    public void addLast(E value){
        Node<E> node = new Node<>(value,null);
        tail.setReferenceValue(node);
        tail = node;

        if (size==0)
            head=tail;
        size++;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty())return null;
        return head.getValue();
    }
    public E last(){
        if (isEmpty())return null;
        return tail.getValue();
    }

    public E removeFirst(){
        if (isEmpty())return null;

        E answer = head.value;
        head = head.referenceValue;
        size--;

        if (size==1)
            tail=head;

        if (size==0)
            tail=null;

        return answer;
    }


}
