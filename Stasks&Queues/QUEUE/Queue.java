public class Queue {
  private int maxSize;
  private long[] a;
  private int front;
  private int rear;
  private int nItems;
  
  public Queue (int size) {
    this.maxSize = size;
    this.a = new long[maxSize];
    front = 0;
    rear = -1;
    nItems = 0;
  }
  
  public void insert (long value) {
    if (rear == maxSize - 1) {
      rear = -1;
    }
    a[++rear] = value;
    nItems++;
  }
  
  public long remove () {
    long temp = a[front++];
    if (front == maxSize) {
      front = 0;
    }
    nItems--;
    return temp;
  }
  
  public long peakFront () {
    return a[front];
  }
  
  public boolean isEmpty () {
    return nItems == 0;
  }
  
  public boolean isFull () {
    return nItems == maxSize;
  }
  
  public void view () {
    System.out.println("nItems: " + nItems);
    System.out.print("[ ");
    int i;
    if (front < rear) {
      for (i = front; i <= rear; i++) {
        System.out.print(a[i] + ". ");
      }
    } else {
      for (i = front; i < maxSize; i++) {
        System.out.print(a[i] + "+ ");
      }
      for (i = 0; i <= rear; i++) {
        System.out.print(a[i] + "* ");
      }
    }
    System.out.println(" ]");
  }
}