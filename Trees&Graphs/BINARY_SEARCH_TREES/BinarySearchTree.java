public class BinarySearchTree {
  private Node root;
  
  public void insert (int key, String value) {
    Node n = new Node(key, value);
    if (root == null) {
      root = n;
    } else {
      Node current = root;
      Node parent;
      while (true) {
        parent = current;
        if (current.key > key) { // go to left
          current = current.left;
          if (current == null) {
            parent.left = n;
            return;
          }
        } else { // go to right
          current = current.right;
          if (current == null) {
            parent.right = n;
            return;
          }
        }
      }
    }
  }
  
  public Node findMin() {
    Node current = root;
    Node last = null;
    while (current != null) {
      last = current;
      current = current.left;
    }
    return last;
  }
  
  public Node findMax() {
    Node current = root;
    Node last = null;
    while (current != null) {
      last = current;
      current = current.right;
    }
    return last;
  }
  
  public boolean delete (int key) {
    Node current = root;
    Node parent = root;
    boolean isLeftChild = false;
    if (current == null) {
      return false; // tree empty
    }
    // SEARCH
    while (current.key != key) {
      parent = current;
      if (current.key > key) {
        isLeftChild = true;
        current = current.left;
      } else {
        isLeftChild = false;
        current = current.right;
      }
      if (current == null) {
        return false; // key not found
      }
    }
    // DELETION
    // If current node does not have children
    if (current.left == null && current.right == null) {
      if (current == root) {
        root = null;
      } else if (isLeftChild) {
        parent.left = null;
      } else {
        parent.right = null;
      }
    }
    // If current node has one child (right)
    else if (current.left == null) {
      if (current == root) {
        root = current.right;
      } else if (isLeftChild) {
        parent.left = current.right;
      } else {
        parent.right = current.right;
      }
    }
    // If current node has one child (left)
    else if (current.right == null) {
      if (current == root) {
        root = current.left;
      } else if (isLeftChild) {
        parent.left = current.left;
      } else {
        parent.right = current.left;
      }
    }
    // If current node has two children
    else {
      Node succesor = getSuccesor(current);
      if (current == root) {
        root = succesor;
      } else if (isLeftChild) {
        parent.left = succesor;
      } else {
        parent.right = succesor;
      }
      succesor.left = current.left;
    }
    return true;
  }
  private Node getSuccesor (Node nodeToDelete) {
    Node parent = nodeToDelete;
    Node succesor = nodeToDelete;
    Node current = nodeToDelete.right;
    while (current != null) {
      parent = succesor;
      succesor = current;
      current = current.left;
    }
    if (succesor != nodeToDelete.right) {
      parent.left = succesor.right;
      succesor.right = nodeToDelete.right;
    }
    return succesor;
  }
}
