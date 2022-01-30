public class App {
  public static void main (String[] args) {
    Graph graph = new Graph(5); // Number of Vertices
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(1, 2);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 1);
    graph.addEdge(4, 0);
    graph.addEdge(4, 3);
    
    Object[] values = graph.adj(1); // 1
    for (Object val : values) {
      System.out.println(val);
    }
    
    
    OtherGraph otherGraph = new OtherGraph(5, "directed");
    otherGraph.addVertex("State");
    otherGraph.addVertex("Avenel");
    otherGraph.addVertex("Elm");
    otherGraph.addVertex("Pocono");
    otherGraph.addVertex("William");
    
    otherGraph.addEdge("State", "Avenel");
    otherGraph.addEdge("State", "Elm");
    otherGraph.addEdge("Elm", "Avenel");
    otherGraph.addEdge("Elm", "William");
    otherGraph.addEdge("William", "State");
    otherGraph.addEdge("William", "Pocono");
    otherGraph.addEdge("Avenel", "Pocono");
    otherGraph.addEdge("Pocono", "Elm");
    
    otherGraph.print();
  }
}