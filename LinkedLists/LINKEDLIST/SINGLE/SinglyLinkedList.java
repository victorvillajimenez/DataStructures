public class SinglyLinkedList {
  private Node first;
  
  public SinglyLinkedList () {
  }
  
  public void insertFirst (int value) {
    Node node = new Node();
    node.data = value;
    node.next = first;
    first = node;
  }
  
  public void insertLast (int value) {
    Node current = first;
    while (current.next != null) {
      current = current.next;
    }
    Node node = new Node();
    node.data = value;
    current.next = node;
  }
  
  public Node deleteFirst () {
    if (isEmpty()) {
      System.out.println("Empty List. Impossible execute deleteFirst");
      return null;
    }
    Node current = first;
    first = first.next;
    return current;
  }
  
  public Node deleteLast () {
    if (isEmpty()) {
      System.out.println("Empty List. Impossible execute deleteLast");
      return null;
    }
    Node current = first;
    Node behind = null;
    while (current.next != null) {
      behind = current;
      current = current.next;
    }
    if (behind == null) {
      first = null;
    } else {
      behind.next = null;
    }
    return current;
  }
  
  public boolean isEmpty () {
    return first == null;
  }
  
  public void display () {
    System.out.println("Singly Linked List (first --> Last)");
    Node current = first;
    while (current != null) {
      current.display();
      current = current.next;
    }
    System.out.println();
  }
}