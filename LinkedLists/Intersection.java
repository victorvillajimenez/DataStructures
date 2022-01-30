public class Intersection {
  public static void main (String[] args) {
    Node a = new Node(0);
    Node b = new Node(1);
    Node c = new Node(25);
    Node d = new Node(3);
    Node e = new Node(2);
    Node f = new Node(1);
    Node g = new Node(0);
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = g;
    showData(a);

    Node w = new Node(10);
    Node x = new Node(11);
    Node y = new Node(12);
    Node z = new Node(13);
    w.next = x;
    x.next = y;
    y.next = z;
    z.next = c;
    showData(w);
    
    Node r = findIntersection(w, a);
    if (r != null) System.out.println("\nR. data: " + r.data);
  }
  
  public static Node findIntersection(Node a, Node b) {
    int i = 0;
    int j = 0;
    Node x = a;
    Node y = b;
    Node p = null;
    Node q = null;
    while (x != null) {
      i++;
      p = x;
      x = x.next;
    }
    while (y != null) {
      j++;
      q = y;
      y = y.next;
    }
    if (p != q) return null;
    x = a;
    y = b;
    int c = j - i;
    if (i > j) {
      c = i - j;
      x = b;
      y = a;
    }
    for (int l = 0; l < c; l++) y = y.next;
    while (y != null && x != null) {
      if (y == x) return x;
      x = x.next;
      y = y.next;
    }
    return null;
  }
  
  public static void showData (Node node) {
    Node n = node;
    System.out.println("\nShow data:");
    while (n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }
}
