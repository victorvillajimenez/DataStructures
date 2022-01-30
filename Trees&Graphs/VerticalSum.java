import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
  Problem: Given a Binary Tree, how will you find the Vertical Sum of Binary Tree?
*/
public class VerticalSum {
  
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
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    perform(root, 0, map);
    printMap(map);
  }
  
  public static void perform (Node node, int key, HashMap<Integer, Integer> map) {
    if (node == null) return;
    map.put(key, map.getOrDefault(key, 0) + node.data);
    perform(node.left, key - 1, map);
    perform(node.right, key + 1, map);
  }
  
  public static void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      System.out.println(pair.getKey() + " = " + pair.getValue());
      it.remove(); // avoids a ConcurrentModificationException
    }
  }
  
  private static Node init () {
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(7);
    Node g = new Node(6);
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;
    return a;
  }
}
