public class DoublyLinkedList {
  private Node first;
  private Node last;

  public DoublyLinkedList() { 
    this.first = null;
    this.last = null;
  }
  
  public boolean isEmpty() {
    return first == null;
  }
  
  public void insertFirst(int value) {
    Node node = new Node();
    node.data = value;
    if (isEmpty()) {
      last = node;
    } else {
      first.previous = node;
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
      last.next = node; // node.previous = last;
    }
    node.previous = last; // remove it
    last = node;
  }
  
  public boolean insertAfter(int key, int value) {
    if (isEmpty()) {
      System.out.println("Empty List");
      return false;
    }
    Node current = first;
    while (current.data != key) {
      current = current.next;
      if (current == null) {
        return false;
      }
    }
    Node node = new Node();
    node.data = value;
    if (current == last) {
      node.next = null;
      last = node;
    } else {
      node.next = current.next;
      current.next.previous = node;
    }
    node.previous = current;
    current.next = node;
    return true;
  }
  
  public Node deleteFirst() {
    if (isEmpty()) {
      System.out.println("Empty List. Impossible execute deleteFirst");
      return null;
    }
    Node current = first;
    if (first.next == null) {
      last = null;
    } else {
      first.next.previous = null;
    }
    first = first.next;
    return current;
  }
  
  public Node deleteLast() {
    if (isEmpty()) {
      System.out.println("Empty List. Impossible execute deleteLast");
      return null;
    }
    Node current = last;
    if (last.previous == null) { // if (first.next == null) {
      first = null;
    } else {
      last.previous.next = null;
    }
    last = last.previous;
    return current;
  }
  
  public Node deleteByKey(int key) {
    if (isEmpty()) {
      System.out.println("Empty List");
      return null;
    }
    Node current = first;
    while (current.data != key) {
      current = current.next;
      if (current == null) {
        return null;
      }
    }
    if (current == first) {
      first = current.next;
    } else {
      current.previous.next = current.next;
    }
    if (current == last) {
      last = current.previous;
    } else {
      current.next.previous = current.previous;
    }
    return current;
  }
  
  public void displayForward() {
    System.out.println("List (First --> Last)");
    Node current = first;
    while (current != null) {
      current.display();
      current = current.next;
    }
    System.out.println();
  }
  
  public void displayBackward() {
    System.out.println("List (Last --> First)");
    Node current = last;
    while (current != null) {
      current.display();
      current = current.previous;
    }
    System.out.println();
  }
}