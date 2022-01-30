public class SumLists {
  public static void main (String[] args) {
    SumLists instance = new SumLists();

    Node a = instance.createRandomLinkedList(3);
    Node b = instance.createRandomLinkedList(5);
    instance.showData(a);
    instance.showData(b); 
    Node x = instance.sum(a, b);
    instance.showData(x);

    Node c = instance.createRandomLinkedList(7);
    Node d = instance.createRandomLinkedList(7);
    instance.showData(c);
    instance.showData(d); 
    Node y = instance.sumB(c, d);
    instance.showData(y);
  }

  Node sumB (Node c, Node d) {
    int cLength = length(c);
    int dLength = length(d);

    if (cLength < dLength) {
      c = padList(c, dLength - cLength);
    } else {
      d = padList(d, cLength - dLength);
    }

    Carry carry = new Carry();
    Node r = addLists(c, d, carry);
    if (carry.value == 1) {
      return insertBefore(r, 1);
    }
    return r;
  }
  
  Node addLists (Node a, Node b, Carry carry) {
    if (a == null && b == null) {
      return null;
    }
    Node n  = addLists(a.next, b.next, carry);
    int val = carry.value + a.data + b.data;
    Node result = insertBefore(n, val % 10);
    carry.value = val / 10; 

    return result;
  }
  
  Node padList (Node n, int padding) {
    Node h = n;
    for (int i = 0; i < padding; i++, h = insertBefore(h, 0));
    return h;
  }

  Node insertBefore (Node n, int d) {
    Node node = new Node(d);
    if (n != null) {
      node.next = n;
    }
    return node;
  }

  int length (Node n) {
    int l = 0;
    for (;n != null; l++, n = n.next);
    return l;
  }

  Node sum (Node a, Node b) {
    return sum(a, b, 0);
  }

  Node sum (Node a, Node b, int carry) {
    if (a == null && b == null && carry == 0) {
      return null;
    }
    Node result = new Node();
    int value = carry;
    if (a != null) {
      value += a.data;
    }
    if (b != null) {
      value += b.data;
    }
    result.data = value % 10;
    
    if (a != null || b != null) {
      Node n = sum(
        a == null ? null : a.next,
        b == null ? null : b.next,
        value >= 10 ? 1 : 0);
      result.next = n;
    }
    return result;
  }

  void showData (Node node) {
    Node n = node;
    System.out.println("\n Show data:");
    while (n != null) {
      System.out.print(" " + n.data);
      n = n.next;
    }
    System.out.println("\n");
  }

  Node createRandomLinkedList (int x) {
    Node a = null;
    Node b = null;
    java.util.Random random = new java.util.Random();
    for (int i = 0; i < x; i++) {
      Node n = new Node(random.nextInt(10));
      if (i == 0) {
        a = n;
      } else {
        b.next = n;
      }
      b = n;
    }
    return a;
  }
}

class Carry {
  int value = 0;
}
