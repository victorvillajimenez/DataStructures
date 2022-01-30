public class GraphAndTrees {

  public boolean breadthFirstSearch (Graph g, Node s, Node e) {
    if (s == e) return true;
    for (Node n : g.getNodes()) {
      n.state = "unvisited";
    }
    s.state = "visiting";
    LinkedList<Node> q = new LinkedList<Node>();
    q.add(s);
    while (!q.isEmpty()) {
      Node n = q.removeFirst();
      if (n != null) {
        for (Node c : n.getAdjacent()) {
          if (c.state == "unvisited") {
            if (c == e) {
              return true;
            } else {
              c.state = "visiting";
              q.add(c);
            }
          }
        }
        n.state = "visited";
      }
    }
    return false;
  }


  public boolean depthFirstSearch (Grapgh g, Node s, Node e) {
    for (Node n : g.getNodes()) {
      n.state = "unvisited";
    }
    return dfs(s, e);
  }
  private boolean dfs (Node s, Node e) {
    if (s == e) return true;
    s.state = "visited";
    for (Node n : s.getAdjacent()) {
      if (n != null) {
        if (n.state == "unvisited") {
          boolean flag = dfs(n, e);
          if (flag) return true;
        }
      }
    }
    return false;
  }


  // array must be asc sort
  public Node createMinimalBST (int[] a) {
    return buildBST(a, 0. a.length - 1);
  }
  private Node buildBST (int[] a, int start, int end) {
    if (end < start) return null;
    int mid = (start + end) / 2;
    Node n = new Node(a[mid]);
    n.left = buildBST(a, start, mid - 1);
    n.right = buildBST(a, mid + 1, end);
    return n;
  }


  public ArrayList<LinkedList<Node>> getListOfDepths (Node root) {
    ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
    getListOfDepths(root, lists, 0);
    return lists;
  }
  private void getListOfDepths (Node node, ArrayList<LinkedList<Node>> lists, int level) {
    if (node == null) return;
    if (lists.size() == level) {
      lists.add(new LinkedList<Node>());
    }
    LinkedList<Node> ll = lists.get(level);
    ll.add(node);
    getListOfDepths(node.left, lists, level + 1);
    getListOfDepths(node.right, lists, level + 1);
  }
  public ArrayList<LinkedList<Node>> getListOfDepthsWithBFS (Node root) {
    ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
    if (root == null) return lists;
    LinkedList<Node> q = new LinkedList<Node>();
    q.add(root);
    while (q.size() > 0) {
      lists.add(q);
      LinkedList<Node> parentList = q;
      q = new LinkedList<Node>();
      for (Node n : parentList) {
        if (n.left != null) {
          q.add(n.left);
        }
        if (n.right != null) {
          q.add(n.right);
        }
      }
    }
    return lists;
  }


  public boolean isBalanced (Node root) {
    if (root == null) return true;
    int heightDiff = getHeight(root.left) - getHeight(root.right);
    if (Math.abs(heightDiff) > 1) {
      return false;
    } else {
      return isBalanced(root.left) && isBalanced(root.right);
    }
  }
  private int getHeight (Node root) {
    if (root == null) return -1;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
  public boolean isBalancedImproved (Node root) {
    return checkHeight(root) != Integer.MIN_VALUE;
  }
  public int checkHeight (Node root) {
    if (root == null) return -1;
    int lHeight = checkHeight(root.left);
    if (lHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    int rHeight = checkHeight(root.right);
    if (rHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    int diff = lHeight - rHeight;
    if (Math.abs(diff) > 1) {
      return Integer.MIN_VALUE;
    }
    return Math.max(lHeight, rHeight) + 1;
  }


  public boolean validateBinarySearchTree (Node root) {
    return validateBST(root, null, null);
  }
  private boolean validateBST (Node n, Integer min, Integer max) {
    if (n == null) return true;
    if ((min != null && n.data <= min) || (max != null && n.data > max)) return false;
    if ((!validateBST(n.left, min, n.data)) || (!validateBST(n.right, n.data, max))) return false;
    return true;
  }
  Integer lastPrinted = null;
  public boolean validateBST (Node n) {
    if (n == null) return true;
    if (!validateBST(n.left)) return false;
    if (lastPrinted != null && n.data <= lastPrinted) return false;
    lastPrinted = n.data;
    if (!validateBST(n.right)) return false;
    return true;
  }
  
  public Node inorderSuccesor (Node n) { // next node
    if (n == null) return null;
    if (n.right != null) {
      return leftMostChild(n.right);
    } else {
      Node q = n;
      Node x = q.parent;
      while (x != null && x.left != q) {
        q = x;
        x = x.parent;
      }
      return x;
    }
  }
  private Node leftMostChild (Node n) {
    if (n == null) return null;
    while (n.left != null) n = n.left;
    return n;
  }

  public Node invertTree (Node n) {
    if (n == null) return null;
    Node t = invertTree(n.left);
    n.left = invertTree(n.right);
    n.right = t;
    return n;
  }
}
