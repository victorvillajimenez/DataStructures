import java.util.*;
public class Palindrome {
  public static void main (String[] args) {
    Node a = new Node(0);
    Node b = new Node(1);
    Node c = new Node(2);
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
    
    System.out.println("\nResult: " + isPalindrome(a));
  }
  
  public static boolean isPalindrome (Node a) {
    if (a == null) return false;
    Node n = a;
    Node r = a;
    List<Integer> stack = new ArrayList<>();
    while (r.next != null && r.next.next != null) {      
      stack.add(n.data);
      n = n.next;
      r = r.next.next;
    }
    if (r.next != null) stack.add(n.data);
    n = n.next;
    for (int i = stack.size() - 1; i >= 0; i--) {
      if (stack.get(i) != n.data) return false;
      n = n.next;
    }
    return true;
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