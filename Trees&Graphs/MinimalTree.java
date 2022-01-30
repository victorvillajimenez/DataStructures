import java.util.Arrays;

public class MinimalTree {
  public static void main (String[] args) {
    int[] array = {6, 9, 11, 19, 27, 28, 63, 201};
    
    MinimalTree instance = new MinimalTree();
    BinaryTreeNode root = instance.arrayToBST(array);
    instance.printPreOrder(root, 0);
  }
  
  public void printPreOrder (BinaryTreeNode n, int level) {
    if (n == null) return;
    System.out.println("Level: " + level + ". Node:" + n.value);
    printPreOrder(n.left, level + 1);
    printPreOrder(n.right, level + 1);
  }
  
  public BinaryTreeNode arrayToBST (int[] array) {
    int length = array.length;
    if (length < 1) return null; 
    int middle = length / 2;
    int value = array[middle];
    BinaryTreeNode node = new BinaryTreeNode(value);
    node.left = arrayToBST(Arrays.copyOfRange(array, 0, middle));
    node.right = arrayToBST(Arrays.copyOfRange(array, middle + 1, length));
    return node;
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
