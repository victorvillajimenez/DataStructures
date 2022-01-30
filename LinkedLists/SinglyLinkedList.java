import java.util.HashSet;
public class SinglyLinkedList {
  Node head;

  public SinglyLinkedList () {
    head = null;
  }

  public void appendToTail (int data) {
    appendToTail(new Node(data));
  }

  public void appendToTail (Node n) {
    Node newNode = n;
    if (head == null) {
      head = newNode;
    } else {
      Node currentNode = head;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }
      currentNode.next = newNode;
    }
  }

  public void removeDuplicatesWithBuffer () {
    Node current = head;
    Node previous = null;
    HashSet<Integer> set = new HashSet<Integer>();

    while (current != null) {
      if (set.contains(current.data)) {
        previous.next = current.next;
      } else {
        set.add(current.data);
        previous = current;
      }
      current = current.next;
    }
  }

  public void removeDuplicatesWithoutBuffer () {
    Node i = head;
    while (i != null) {
      Node j = i;
      while (j.next != null) {
        if (i.data == j.next.data) {
          j.next = j.next.next;
        } else {
          j = j.next;
        }
      }
      i = i.next;
    }    
  }

  public void showData () {
    Node currentNode = head;
    System.out.println("\nshowData:");
    while (currentNode != null) {
      System.out.println(currentNode.data);
      currentNode = currentNode.next;
    }
  }
}
