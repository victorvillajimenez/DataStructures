public class App {
  public static void main (String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();

    list.deleteFirst();
    list.deleteLast();
    list.deleteLast();
    list.insertFirst(12);
    list.insertFirst(52);
    list.insertFirst(23);
    list.insertFirst(4);
    list.insertFirst(211);
    list.insertFirst(8);
    list.insertFirst(97);
    System.out.println("Node " + list.deleteLast().data);
    System.out.println("Node " + list.deleteLast().data);
    list.insertLast(9898);
    list.insertLast(11);
    
    list.display();
  }
}