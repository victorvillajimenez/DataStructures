public class PartitionX {
  public static void main (String[] args) {
    PartitionX instance = new PartitionX();
    Node a = instance.createRandomLinkedList();
    instance.showData(a);
    Node b = instance.partition(a, 35);
    instance.showData(b);
    
    Node c = instance.createRandomLinkedList();
    instance.showData(c);
    Node d = instance.partitionB(c, 35);
    instance.showData(d);
  }

  Node partitionB(Node n, int x) {
    Node head = n;
    Node tail = n;
    while (n != null) {
      Node next = n.next;
      if (n.data >= x) {
        tail.next = n;
        tail = n;
      } else {
        n.next = head;
        head = n;
      }
      n = next;
    }
    if (tail != null) {
      tail.next = null;
    }
    return head;
  }

  Node partition(Node n, int x) {
    Node beforeStart = null;
    Node beforeEnd = null;
    Node afterStart = null;
    Node afterEnd = null;
    while (n != null) {
      Node next = n.next;
      n.next = null;
      if (n.data < x) {
        if (beforeStart == null) {
          beforeStart = n;
          beforeEnd = n;
        } else {
          beforeEnd.next = n;
          beforeEnd = n;
        }
      } else {
        if (afterStart == null) {
          afterStart = n;
          afterEnd = n;
        } else {
          afterEnd.next = n;
          afterEnd = n;
        }        
      }
      n = next;
    }
    if (beforeStart == null) {
      return afterStart;
    }
    beforeEnd.next = afterStart;
    return beforeStart;
  }

  Node createRandomLinkedList () {
    Node a = null;
    Node b = null;
    java.util.Random random = new java.util.Random();
    for (int i = 0; i < 15; i++) {
      Node n = new Node(random.nextInt(100));
      if (i == 0) {
        a = n;
      } else {
        b.next = n;
      }
      b = n;
    }
    return a;
  }

  void showData (Node node) {
    Node n = node;
    System.out.println("\nShow data:");
    while (n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }
}
