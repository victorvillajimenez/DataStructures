import java.util.ArrayList;
import java.util.LinkedList;

public class ListInDepths {
  public static void main (String[] args) {
    BinaryTreeNode node = createBinaryTree();
    ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<LinkedList<BinaryTreeNode>>();
    // createLevelLinkedListWithDepthFirstSearch(node, lists, 0);
    lists = createLevelLinkedListWithBreadthFirstSearch(node);
    
    for (int i = 0; i < lists.size(); i++) {
      System.out.println("Level: " + i + " Size: " + lists.get(i).size());
    }
  }
  
  public static void createLevelLinkedListWithDepthFirstSearch (BinaryTreeNode node, ArrayList<LinkedList<BinaryTreeNode>> lists, int level) {
    if (node == null) return;
    LinkedList<BinaryTreeNode> list = null;
    if (lists.size() == level) {
      list = new LinkedList<BinaryTreeNode>();
      lists.add(list);
    } else {
      list = lists.get(level);
    }
    list.add(node);
    createLevelLinkedListWithDepthFirstSearch(node.left, lists, level + 1);
    createLevelLinkedListWithDepthFirstSearch(node.right, lists, level + 1);
  }
  
  public static ArrayList<LinkedList<BinaryTreeNode>> createLevelLinkedListWithBreadthFirstSearch(BinaryTreeNode node) {
    ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<LinkedList<BinaryTreeNode>>();
    LinkedList<BinaryTreeNode> current = new LinkedList<BinaryTreeNode>();
    if (node != null) {
      current.add(node);
    }
    while (current.size() > 0) {
      result.add(current);
      LinkedList<BinaryTreeNode> parents = current;
      current = new LinkedList<BinaryTreeNode>();
      for (BinaryTreeNode parent : parents) {
        if (parent.left != null) {
          current.add(parent.left);
        }
        if (parent.right != null) {
          current.add(parent.right);
        }
      }
    }
    return result;
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