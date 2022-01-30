public class App {
  public static void main (String[] args) {
    System.out.println("First:");
    System.out.format("[%13s]", "");
    System.out.println("Second:");
    System.out.format("[%1$13s]%n", "");
    System.out.println("End");

    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(20, "Twenty");
    tree.insert(10, "Ten");
    tree.insert(15, "Fifteen");
    tree.insert(30, "Thirty");
    tree.insert(99, "ninety nine");
    tree.insert(1,  "one");

    System.out.println(tree.findMin().key);
    System.out.println(tree.findMax().key);
    System.out.println(tree.delete(99));
    System.out.println(tree.findMax().key);
  }
}