public class Node {
  public int data;
  public Node next = null;
  public Node previous = null;
  
  public void display() {
    System.out.println("{ " + data + " }");
  }
}