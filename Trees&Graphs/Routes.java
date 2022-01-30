public class Routes {
  
  public static void main (String[] args) {
    Routes routes = new Routes();
    Graph graph = routes.buildGraph();
    routes.printGraph(graph);
    Node s = routes.getRandomNode(graph);
    Node e = routes.getRandomNode(graph);
    System.out.println("\nx:" + s.name + " - y:" + e.name);
    boolean hasRoute = routes.search(graph, s, e);
    System.out.println("hasRoute: " + hasRoute);
  } 

  public boolean search (Graph graph, Node x, Node y) {
    if (x == y) { return true; }
    java.util.LinkedList<Node> queue = new java.util.LinkedList<Node>();
    for (Node u : graph.nodes) {
      u.state = State.Unvisited;
    }
    x.state = State.Visiting;
    queue.add(x);
    Node u;
    while (!queue.isEmpty()) {
      u = queue.removeFirst();
      if (u != null) {
        for (Node v : u.children) {
          if (v.state == State.Unvisited) {
            if (v == y) {
              return true;
            } else {
              v.state = State.Visiting;
              queue.add(v);
            }
          }
        }
        u.state = State.Visited;
      }
    }
    return false;
  }

  public void printGraph (Graph graph) {
    for (Node n : graph.nodes) {
      System.out.println("[name: " + n.name + " value: " + n.value + "] => Children : ");
      for (Node c : n.children) {
        System.out.println("  |__ " + c.name);
      }
    }
  }

  public Node getRandomNode (Graph graph) {
    int size = graph.nodes.length;
    java.util.Random random = new java.util.Random();
    int index = random.nextInt(1000) % size;
    return graph.nodes[index];
  }

  public Graph buildGraph () {
    Node a = new Node("A", 0);
    Node b = new Node("B", 1);
    Node c = new Node("C", 2);
    Node d = new Node("D", 3);
    Node e = new Node("E", 4);
    Node f = new Node("F", 5);
    Node g = new Node("G", 6);
    Node h = new Node("H", 7);
    Node i = new Node("I", 8);
    Node j = new Node("J", 9);

    a.children = new Node[]{b, e, f};
    b.children = new Node[]{d, e};
    c.children = new Node[]{b};
    d.children = new Node[]{c, e};
    e.children = new Node[]{g};
    f.children = new Node[]{};
    g.children = new Node[]{a, c};
    
    Graph graph = new Graph();
    graph.nodes = new Node[]{a, b, c, d, e, f, g, h, i, j};
    return graph;
  }
}

enum State {
  Unvisited,
  Visited,
  Visiting;
}

class Node {
  public String name;
  public int value;
  public State state;
  public Node[] children;
  
  public Node (String name, int value) {
    this.name = name;
    this.value = value;
    this.children = new Node[]{};
  }
}

class Graph {
  public Node[] nodes;
}

