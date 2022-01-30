public class RemoveDups {
  public static void main (String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    
    list.appendToTail(new Node(6));
    list.appendToTail(new Node(6));
    list.appendToTail(new Node(87));
    list.appendToTail(new Node(3));
    list.appendToTail(new Node(2));
    list.appendToTail(new Node(90));
    list.appendToTail(new Node(87));
    list.appendToTail(new Node(3));
    list.appendToTail(new Node(1));
    list.appendToTail(new Node(3));
    
    list.showData();
    
    list.removeDuplicatesWithoutBuffer();
    
    list.showData();
  }
}
