public class Stack {
  private int maxSize;
  // private Long[] a; // stackArray
  private char[] a;
  private int top;
  
  public Stack (int size) {
    this.maxSize = size;
    this.a = new char[size];
    this.top = -1;
  }
  
  public void push (char value) {
    if (isFull()) {
      System.out.println("Stack is already full");
    } else {
      a[++top] = value;
    }
  }
  
  public char pop () {
    if (isEmpty()) {
      System.out.println("Stack is already empty");
      // return -1L;
      return '0';
    } else {
      return a[top--];
    }
  }
  
  public char peak () {
    return a[top];
  }
  
  public boolean isEmpty () {
    return top == -1;
  }
  
  public boolean isFull () {
    return top == maxSize - 1;
  }
}
