import java.util.ArrayDeque;
import java.util.Iterator;
/*
  Given a Binary tree, how eill you find its maximum width
*/
public class MaxWidth {
  private static int max;

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node (int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static void main (String[] args) {
    Node root = init();
    ArrayDeque<Node> queue = new ArrayDeque<Node>();
    queue.add(root);
    max = 0;
    perform(root, queue);
    System.out.println("MAX: " + max);
  }
  
  public static void perform (Node n, ArrayDeque q) {
    while (!q.isEmpty()) {
      if (q.size() > max) max = q.size();
      // System.out.println("q.size(): " + q.size());
      int size = q.size(); // Very IMPORTANT to get size before iterate
      for (int i = 0; i < size; i++) {
        Node node = (Node)q.removeFirst();
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }
    }
  }
  
  public static Node init () {
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);
    Node h = new Node(8);
    Node i = new Node(9);
    Node j = new Node(10);
    
    Node k = new Node(11);
    Node l = new Node(12);
    Node m = new Node(13);
    Node n = new Node(14);
    
    Node o = new Node(15);
    Node p = new Node(16);
    Node q = new Node(17);
    Node r = new Node(18);
    Node s = new Node(19);
    Node t = new Node(20);
    Node u = new Node(21);
    Node v = new Node(22);

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;
    f.left = h;
    h.left = i;
    h.right = j;
    
    i.left = k;
    i.right = l;
    j.left = m;
    j.right = n;
    
    k.left = o;
    k.right = p;
    l.left = q;
    l.right = r;
    m.left = s;
    m.right = t;
    n.left = u;
    n.right = v;

    return a;
  }
}