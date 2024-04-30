package LinkedList;

import org.w3c.dom.Node;

public class CircularyLinkedList<E> {

    private static class  Node<E>{
        private Node<E> referenceValue;
        private E element;

        public Node(E element,Node<E> referenceValue) {
            this.referenceValue = referenceValue;
            this.element = element;
        }

        public Node<E> getReferenceValue() {
            return referenceValue;
        }

        public void setReferenceValue(Node<E> referenceValue) {
            this.referenceValue = referenceValue;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }



    private Node<E> tail=null;
    private int size=0;

    public CircularyLinkedList() {}

    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty())return null;
        return tail.referenceValue.element;
    }
    public E last(){
        if (isEmpty())return null;
        return tail.element;
    }

    public void addFirst(E element){
        if (size==0) {
            tail = new Node<>(element,null);
            tail.setReferenceValue(tail);
        }else{
            Node<E> newest = new Node<>(element,tail.getReferenceValue());
            tail.setReferenceValue(newest);
        }
        size++;
    }
    public void addLast(E element){
        addFirst(element);
        tail = tail.getReferenceValue();
    }

    public void rotate(){
        if (tail!=null)
            tail=tail.getReferenceValue();
    }

    public E removeFirst(){
        if (isEmpty()) return null;

        Node<E> head = tail.getReferenceValue();

        if (head == tail)tail=null;
        else tail.setReferenceValue(head.getReferenceValue());
        size--;

        return head.getElement();
    }

    public int getSize(){
        if (tail==null)return 0;
        int cont = 1;
        Node<E> temp = tail;

        while (temp.getReferenceValue() != tail){
            cont++;
            temp = temp.getReferenceValue();
        }
        return cont;

    }

    public static void main(String[] args) {
        CircularyLinkedList<String> names = new CircularyLinkedList<>();
        CircularyLinkedList<String> names2 = new CircularyLinkedList<>();

        names.addFirst("Tomas");
        names.addFirst("Alfonso");
        names.addFirst("Raul");

        System.out.println(names2.getSize());


        // RAUL(head) --> ALFONSO --> TOMAS(tail) --> RAUL ...
        System.out.println(names.first());
        System.out.println(names.last());

        names.removeFirst();//remove head

        // ALFONSO(head) --> TOMAS(tail) -->ALFONSO ...
        System.out.println(names.first());
        System.out.println(names.last());

        names.removeFirst();//remove head

        // TOMAS(head,tail) --> TOMAS(tail,head) -->TOMAS ...
        System.out.println(names.first());
        System.out.println(names.last());

    }

}
