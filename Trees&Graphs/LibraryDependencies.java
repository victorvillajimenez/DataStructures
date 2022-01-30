import java.util.ArrayList;
import java.util.List;
/*
  Topological Sorting
*/
public class LibraryDependencies {

  public static class Node {
    int weight;
    List<Node> dependencies;
    public Node (int weight) {
      this.weight = weight;
      dependencies = new ArrayList<Node>();
    }
  }

  public static void main (String[] args) {
    Node library = init();
    List<Node> list = new ArrayList<Node>();

    order(library, list);

    for (Node n : list) System.out.print("[" + n.weight + "] ");
    System.out.println();
  }

  public static void order (Node lib, List<Node> list) {
    for (Node dependency : lib.dependencies) {
      order(dependency, list);
    }
    if (!list.contains(lib)) {
      list.add(lib);
    }
  }

  public static Node init () {
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    // Node g = new Node(7);
    // a.dependencies.add(b);
    // a.dependencies.add(e);
    // e.dependencies.add(d);
    // d.dependencies.add(c);
    // c.dependencies.add(b);
    // e.dependencies.add(f);
    // f.dependencies.add(g);
    // g.dependencies.add(c);

    a.dependencies.add(f);
    a.dependencies.add(e);
    b.dependencies.add(d);
    b.dependencies.add(e);
    c.dependencies.add(f);
    d.dependencies.add(c);
    return b;
  }
}
