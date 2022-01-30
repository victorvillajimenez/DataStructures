public class App {
  public static void main (String[] args) {
    Node a = new Node();
    a.data = 4;
    
    Node b = new Node();
    b.data = 3;
    
    Node c = new Node();
    c.data = 7;
    
    Node d = new Node();
    d.data = 8;
    
    Node e = new Node();
    e.data = 111;
    
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    
    System.out.println(listLength(a));
    System.out.println(listLength(b));
    System.out.println(listLength(c));
  }
  
  public static int listLength (Node x) {
    int size = 0;
    Node t = x;
    while (t != null) {
      size++;
      t = t.next;
    }
    return size;
  }
}