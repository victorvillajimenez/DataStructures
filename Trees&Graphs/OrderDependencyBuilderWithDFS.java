public class OrderDependencyBuilderWithDFS {
  public Stack<Project> findBuildOrder (String[] projects, String[][] dependencies) {
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
  
  public Stack<Project> orderProjects (ArrayList<Project> projects) {
    Stack<Project> stack = new Stack<Poject>();
    for (Project project : projects) {
      if (project.getState() == Project.State.BLANK) {
        if (!doDFS(project, stack)) return null;
      }
    }
    return stack;
  }
  
  public boolean doDFS (Project project, Stack<Project> stack) {
    if (project.getState() == Project.State.PARTIAL) return false; // CYCLE
    
    if (project.getState() == Project.State.BLANK) {
      project.setState(Project.State.PARTIAL);
      ArrayList<Project> children = project.getChildren();
      for (Project child : children) {
        if (!doDFS(child, stack)) return false;
      }
      project.setState(Project.State.COMPLETE);
      stack.push(project);
    }
    return true;
  }
  
  public class Graph {
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    
    public Project getOrCreateNode (String name) {
      if (!map.containsKey(name)) {
        Project project = new Project(name);
        nodes.add(project);
        map.put(name, project);
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
    public enum State {COMPLETE, PARTIAL, BLANK};
    
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    private String name;
    private State state = State.BLANK;
    
    public Project (String name) { this.name = name; }
    
    public void addNeighbor (Project node) {
      if (!map.containsKey(node.getName())) {
        children.add(node);
        map.put(node.getName(), node);
      }
    }
    
    public String getName () { return name; }
    public void setState (State st) { this.state = st; }
    public State getState () { return state; }
    public ArrayList<Project> getChildren () { return children; }
  }
}
