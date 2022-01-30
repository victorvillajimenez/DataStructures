import java.util.ArrayList;

public class Graph {
  private int nVertices;
  private int nEdges;
  
  private ArrayList[] adjacents;
  
  public Graph (int nVertices) {
    this.nVertices = nVertices;
    this.nEdges = 0;
    adjacents = new ArrayList[nVertices];
    for (int i = 0; i < nVertices; i++) {
      adjacents[i] = new ArrayList();
    }
  }
  
  public int getVertexCount () {
    return nVertices;
  }
  
  public int getEdgeCount () {
    return nEdges;
  }
  
  public void addEdge (int src, int dest) {
    adjacents[src].add(dest);
    nEdges++;
  }
  
  public Object[] adj (int src) {
    return adjacents[src].toArray();
  }
}