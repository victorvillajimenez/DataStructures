class BalancedBinaryTreeChecker {
  public static void main (String[] args) {
    BinaryTreeNode root = createBinaryTree();
    // boolean isBal = isBalancedV1(root);
    
    boolean isBal = isBalancedV2(root);
    System.out.println("Is balanced? : " + isBal + " - MIN_VALUE : " + Integer.MIN_VALUE  );
  }
  
  private static int getHeight (BinaryTreeNode node) {
    if (node == null) return -1;
    return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
  }
  
  public static boolean isBalancedV1 (BinaryTreeNode node) {
    if (node == null) return true;
    int heightLeft = getHeight(node.left);
    int heightRight = getHeight(node.right);
    int heightDiff = heightLeft - heightRight;
    System.out.println("heightLeft : " + heightLeft + " - heightRight: " + heightRight + " = " + heightDiff);
    if (Math.abs(heightDiff) > 1) {
      return false;
    } else {
      return isBalancedV1(node.left) && isBalancedV1(node.right);
    }
  } 

  private static int checkHeight (BinaryTreeNode node) {
    if (node == null) return -1;
    int leftHeight = checkHeight(node.left);
    if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    
    int rigthHeight = checkHeight(node.right);
    if (rigthHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    
    int heightDiff = leftHeight - rigthHeight;
    if (Math.abs(heightDiff) > 1) {
      return Integer.MIN_VALUE;
    } else {
      return Math.max(leftHeight, rigthHeight) + 1;
    }
  }

  public static boolean isBalancedV2 (BinaryTreeNode node) {
    return checkHeight(node) != Integer.MIN_VALUE;
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

    // --- Balanced
    d.left = h;
    d.right = i;
    e.left = j;
    e.right = k;
    f.left = l;
    f.right = m;
    g.left = n;
    g.right = o;

    // --- Unbalanced
    // d.right = h;
    // g.left = i;
    // g.right = j;
    // h.left = k;
    // h.right = l;
    // j.left = m;
    // j.right = n;
    // n.left = o;
    // o.left = p;
    // p.left = q;
    // p.right = r;
    // r.left = s;

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
