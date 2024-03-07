package LinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>(); // Crear una instancia de la lista

        myList.addFirst(5);
        myList.addFirst(6);
        myList.addFirst(7);
        myList.addFirst(3);

        System.out.println(myList.removeFirst());
        System.out.println(myList.removeFirst());
        System.out.println(myList.removeFirst());
        System.out.println(myList.removeFirst());
        System.out.println(myList.removeFirst());

        myList.addFirst(6);
        myList.addFirst(7);
        myList.addFirst(3);

        System.out.println(myList.removeFirst());
        System.out.println(myList.removeFirst());
        System.out.println(myList.removeFirst());



    }
}

