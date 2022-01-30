public class SumTwoLinkedLists {

  static boolean hasOneCarrier;
  
  public static class Node {
    Node next;
    int data;
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void main (String[] args) {    
    // a = 545246
    Node a = new Node(5);
    Node b = new Node(4);
    Node c = new Node(5);
    Node d = new Node(2);
    Node e = new Node(4);
    Node f = new Node(6);
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;

    // b = 91
    Node x = new Node(9);
    Node y = new Node(5);
    Node z = new Node(6);
    x.next = y;
    y.next = z;

    Node t;
    int countA;
    int countX;
    for (countA = 0, t = a; t != null; t = t.next, countA++);
    for (countX = 0, t = x; t != null; t = t.next, countX++);

    if (countA < countX) {
      a = addZerosToLeft(a, countX - countA);
    } else if (countX < countA) {
      x = addZerosToLeft(x, countA - countX);
    }

    hasOneCarrier = false;
    Node r = perform(a, x);
    while (r != null) {
      System.out.print(r.data);
      r = r.next;
    }
    System.out.println();
  }

  private static Node addZerosToLeft (Node head, int n) {
    for (int i = 0; i < n; i++) {
      Node node = new Node(0);
      node.next = head;
      head = node;
    }
    return head;
  }

  public static Node perform (Node a, Node b) {    
    if (a.next == null) { // or could be: b.next == null
      return sum(a.data, b.data);
    }
    Node next = perform(a.next, b.next);
    Node current = sum(a.data, b.data);
    current.next = next;
    return current;
  }

  private static Node sum (int a, int b) {
    int carry = hasOneCarrier ? 1 : 0;
    int x = a + b + carry;
    hasOneCarrier = x > 9;
    return new Node(x % 10);
  }
}
