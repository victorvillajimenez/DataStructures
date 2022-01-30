public class OtherGraph {

  Vertex[] arrayOfLists;
  int indexCounter = 0;
  boolean undirected = true;
  
  class Node {
    public int vertexIdx;
    public Node next;
    public Node (int vertexIdx, Node node) {
      this.vertexIdx = vertexIdx;
      this.next = node;
    }
  }
  
  class Vertex {
    String name;
    Node adjList;
    public Vertex (String name, Node node) {
      this.name = name;
      this.adjList = node;
    }
  }
  
  public OtherGraph (int nVertices, String graphType) {
    if (graphType.equals("directed")) {
      undirected = false;
    }
    arrayOfLists = new Vertex[nVertices];
  }
  
  public void addVertex (String name) {
    arrayOfLists[indexCounter] = new Vertex(name, null);
    indexCounter++;
  }
  
  public void addEdge (String srcVertexName, String destVertexName) {
    int v1Idx = indexForName(srcVertexName);
    int v2Idx = indexForName(destVertexName);
    arrayOfLists[v1Idx].adjList = new Node(v2Idx, arrayOfLists[v1Idx].adjList);
    if (undirected) {
      arrayOfLists[v2Idx].adjList = new Node(v1Idx, arrayOfLists[v2Idx].adjList);
    }
  }
  
  int indexForName (String name) {
    for (int i = 0; i < arrayOfLists.length; i++) {
      if (arrayOfLists[i].name.equals(name)) {
        return i;
      }
    }
    return -1;
  }
  
  public void print () {
    for (int i = 0; i < arrayOfLists.length; i++) {
      System.out.print(arrayOfLists[i].name);
      for (Node n = arrayOfLists[i].adjList; n != null; n = n.next) {
        System.out.print(" --> " + arrayOfLists[n.vertexIdx].name);
      }
      System.out.println();
    }
  }
}