public class App {
  public static void main(String[] args) {
    CircularLinkedList list = new CircularLinkedList();
    
    list.deleteFirst();
    list.deleteLast();
    list.insertLast(9898);
    list.deleteLast();
    list.insertFirst(12);
    list.insertFirst(52);
    list.insertFirst(23);
    list.insertFirst(4);
    list.insertFirst(211);
    list.insertFirst(8);
    list.insertFirst(9);
    list.insertLast(9898);
    list.deleteFirst();
    list.deleteLast();
    
    list.display();
  }
}