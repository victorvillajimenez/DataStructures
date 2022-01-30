public class BSTValidator {
  static Integer lastPrinted = null;
  public static void main (String[] args) {
    BinaryTreeNode root = createBinarySearchTree();
    // boolean result = isBST(root);
    boolean result = checkBST(root);
    
    System.out.println("isBST : " + result);
  }

  public static boolean checkBST (BinaryTreeNode n) {
    if (n == null) return true;
    if (!checkBST(n.left)) return false;
    if (lastPrinted != null && n.value <= lastPrinted) return false;
    lastPrinted = n.value;
    if (!checkBST(n.right)) return false;
    return true;
  }

  public static boolean isBST (BinaryTreeNode n) {
    if (n == null) return true;
    if (!checkLeft(n.value, n.left) ||
      !isBST(n.left) ||
      !checkRight(n.value, n.right) ||
      !isBST(n.right)) {
      return false;
    }
    return true;
  }
  
  public static boolean checkLeft (int parentValue, BinaryTreeNode current) {
    return current != null ? current.value <= parentValue : true;
  }
  
  public static boolean checkRight (int parentValue, BinaryTreeNode current) {
    return current != null ? current.value >= parentValue : true;
  }
  
  public static BinaryTreeNode createBinarySearchTree () {
    
    BinaryTreeNode j = new BinaryTreeNode(0);
    BinaryTreeNode i = new BinaryTreeNode(1);
    BinaryTreeNode a = new BinaryTreeNode(2);
    BinaryTreeNode e = new BinaryTreeNode(4);
    BinaryTreeNode t = new BinaryTreeNode(6);
    
    BinaryTreeNode h = new BinaryTreeNode(7);
    
    BinaryTreeNode s = new BinaryTreeNode(8);
    BinaryTreeNode p = new BinaryTreeNode(9);
    BinaryTreeNode q = new BinaryTreeNode(18);
    BinaryTreeNode k = new BinaryTreeNode(24);
    
    BinaryTreeNode b = new BinaryTreeNode(45);
    
    BinaryTreeNode d = new BinaryTreeNode(52);
    BinaryTreeNode r = new BinaryTreeNode(56);
    BinaryTreeNode o = new BinaryTreeNode(63);
    BinaryTreeNode f = new BinaryTreeNode(64);
    BinaryTreeNode n = new BinaryTreeNode(73);
    BinaryTreeNode c = new BinaryTreeNode(89);
    BinaryTreeNode l = new BinaryTreeNode(212);
    BinaryTreeNode m = new BinaryTreeNode(248);
    BinaryTreeNode g = new BinaryTreeNode(999);
    
    b.left = h;
    b.right = n;

    h.left = a;
    h.right = q;
    n.left = o;
    n.right = m;
    
    a.left = i;
    a.right = e;
    q.left = p;
    q.right = k;

    o.left = r;
    o.right = f;
    m.left = l;
    m.right = g;

    i.left = j;
    p.left = s;
    r.left = d;
    l.left = c;
    
    e.right = t;

    return b;
  }
  
  public static BinaryTreeNode createBinaryTree () {
    BinaryTreeNode a = new BinaryTreeNode(2);
    BinaryTreeNode b = new BinaryTreeNode(45);
    BinaryTreeNode c = new BinaryTreeNode(89);
    BinaryTreeNode d = new BinaryTreeNode(52);
    BinaryTreeNode e = new BinaryTreeNode(4);
    BinaryTreeNode f = new BinaryTreeNode(64);
    BinaryTreeNode g = new BinaryTreeNode(999);
    BinaryTreeNode h = new BinaryTreeNode(7);
    BinaryTreeNode i = new BinaryTreeNode(1);
    BinaryTreeNode j = new BinaryTreeNode(0);
    BinaryTreeNode k = new BinaryTreeNode(24);
    BinaryTreeNode l = new BinaryTreeNode(212);
    BinaryTreeNode m = new BinaryTreeNode(248);
    BinaryTreeNode n = new BinaryTreeNode(73);
    BinaryTreeNode o = new BinaryTreeNode(63);
    BinaryTreeNode p = new BinaryTreeNode(9);
    BinaryTreeNode q = new BinaryTreeNode(18);
    BinaryTreeNode r = new BinaryTreeNode(56);
    BinaryTreeNode s = new BinaryTreeNode(8);
    
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;

    d.right = h;
    g.left = i;
    g.right = j;
    
    h.left = k;
    h.right = l;
    j.left = m;
    j.right = n;
    
    n.left = o;
    o.left = p;
    p.left = q;
    p.right = r;
    r.left = s;

    return a;
  }
}

class BinaryTreeNode {
  int value;
  BinaryTreeNode left;
  BinaryTreeNode right;
  public BinaryTreeNode (int value) {
    this.value = value;
  }
}
