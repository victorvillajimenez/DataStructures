public class LinkedListReverted {
  
  public static void main (String[] args) {
    Node input = null;
    Node n = null;
    for (int i = 1; i <= 8; i++) {
      Node tmp = new Node(i);
      if (input == null) {
        input = tmp;
        n = tmp;
      } else {
        n.next = tmp;
        n = n.next;
      }
    }
    display(input);
    display(reverseBy(input, 3));
  }
  
  public static void display(Node first) {
    Node n = first;
    System.out.println();
    while (n != null) {
      System.out.print(" " + n.key + " --> ");
      n = n.next;
    }
    System.out.println();
  }
  
  public static Node reverseBy(Node root, int k) {
    Node current = root;
    Node behind = root;
    int[] subGroup = new int[k];
    int i = 0;
    while (current != null) {
      subGroup[i % k] = current.key;
      current = current.next;
      i++;
      if ((i % k) == 0) {
        for (int c = subGroup.length - 1; c >= 0; c--) {
          behind.key = subGroup[c];
          behind = behind.next;
        }
      }
    }
    return root;
  }
}

  class Node {
    int key;
    Node next = null;
    public Node(int key) {
      this.key = key;
    }
  }