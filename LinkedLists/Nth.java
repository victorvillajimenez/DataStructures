public class Nth {
  public static void main (String[] args) {
    Nth instance = new Nth();

    Node head = instance.createRandomLinkedList();
    instance.showData(head);
    
    Index index = new Index();
    Node kth = instance.kthToLast(head, 3, index);
    instance.showData(kth);

    head = instance.createRandomLinkedList();
    instance.showData(head);
    
    index = new Index();
    Node nth = instance.nthToLast(head, 3, index);
    instance.showData(nth);
  }

  Node nthToLast (Node head, int n, Index i) {
    Node b = head;
    Node a = head;
    for (int j = 0; j < n; j++) {
      if (b == null) return null;
      b = b.next;
    }
    while (b != null) {
      b = b.next;
      a = a.next;
    }
    return a;
  }

  Node kthToLast (Node current, int k, Index i) {
    if (current == null) return null;
    Node node = kthToLast(current.next, k, i);
    i.value += 1;
    if (i.value == k) return current;
    return node;
  }
  
  Node createRandomLinkedList () {
    Node a = null;
    Node x = null;
    Node y = null;
    java.util.Random rand = new java.util.Random();

    for (int i = 0; i < 15; i++) {
      x = new Node(rand.nextInt(1000));
      if (i == 0) {
        a = x;
      } else {
        y.next = x;
      }
      y = x;
    }

    return a;
  }

  public void showData (Node head) {
    Node currentNode = head;
    System.out.println("\nshowData:");
    while (currentNode != null) {
      System.out.println(currentNode.data);
      currentNode = currentNode.next;
    }
  }

}

class Index {
  public int value = 0;
}