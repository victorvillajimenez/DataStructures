public class CircularLinkedList {
  private Node first;
  private Node last;
  
  public CircularLinkedList() {
    this.first = null;
    this.last  = null;
  }
  
  public void insertFirst(int value) {
    Node node = new Node();
    node.data = value;
    if (isEmpty()) {
      last = node;
    }
    node.next = first;
    first = node;
  }
  
  public void insertLast(int value) {
    Node node = new Node();
    node.data = value;
    if (isEmpty()) {
      first = node;
    } else {
      last.next = node; // last = node;
    }
    last = node;
  }
  
  public int deleteFirst() {
    if (isEmpty()) {
      System.out.println("Empty List. Impossible execute deleteFirst");
      return -1;
    }
    int temp = first.data;
    if (first.next == null) {
      last = null;
    }
    first = first.next;
    return temp;
  }
  
  // This method is not possible to implement.
  public int deleteLast() {
    return -1;
  }
  
  public boolean isEmpty() {
    return first == null;
  }
  
  public void display() {
    System.out.println("List (first --> last)");
    Node current = first;
    while (current != null) {
      current.display();
      current = current.next;
    }
    System.out.println();
  }
}