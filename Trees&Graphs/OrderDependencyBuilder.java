public class OrderDependencyBuilder {
  public Project[] findBuildOrder (String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.getNodes());
  }
  
  public Graph buildGraph (String[] projects, String[][] dependencies) {
    Graph graph = new Graph();
    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }
    return graph;
  }
  
  public Project[] orderProjects (ArrayList<Project> projects) {
    Project[] order = new Project[projects.size()];
    
    int endOfList = addNonDependent(order, projects, 0);
    
    int toBeProcessed = 0;
    while (toBeProcessed < order.length) {
      Project current = order[toBeProcessed];
      
      // we have circular dependency since there are no remaining projects with Zero dependencies.
      if (current == null) return null;
      
      ArrayList<Project> children = current.getChildren();

      for (Project child : children) child.decrementDependencies();

      endOfList = addNonDependent(order, children, endOfList);
    
      toBeProcessed++;
    }
    return order;
  }
  
  private int addNonDependent (Project[] order, ArrayList<Project> projects, int offset) {
    for (Project project : projects) {
      if (project.getNumberDependencies() == 0) {
        order[offset] = project;
        offset++;
      }
    }
    return offset;
  }


  public class Graph {
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HahMap<String, Project> map = new HashMap<Project>();
    
    public Project getOrCreateNode (String name) {
      if (!map.containsKey(name)) {
        Project node = new Project(name);
        map.put(name, node);
        nodes.add(node);
      }
      return map.get(name);
    }
    
    public void addEdge (String start, String end) {
      Project first = getOrCreateNode(start);
      Project second = getOrCreateNode(end);
      first.addNeighbor(second);
    }
    
    public ArrayList<Project> getNodes () { return nodes; }
  }
  
  public class Project {
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;
    
    public Project (String n) { this.name = n; }
    
    public void addNeighbor (Project node) {
      if (!map.containsKey(node.getName())) {
        children.add(node);
        map.put(node.getName(), node);
        node.incrementDependencies();
      }
    }
    
    public void incrementDependencies () { dependencies++; }
    public void decrementDependencies () { dependencies--; }
    
    public String getName () { return name; }
    public ArrayList<Project> getChildren () { return children; }
    public int getNumberDependencies () { return dependencies; }
  }
}
