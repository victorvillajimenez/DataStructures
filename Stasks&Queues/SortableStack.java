import java.util.Stack;
public class SortableStack extends Stack {
  
  public static void main (String[] args) {
    SortableStack s = new SortableStack();
    s.push(3123);
    s.push(34);
    s.push(45);
    s.push(1);
    s.push(123);
    s.push(2534);
    s.sort();

    while(!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }
  
  public void sort () {
    Stack<Integer> r = new Stack<Integer>();
    while (!this.isEmpty()) {
      int tmp = (Integer)this.pop();
      while (!r.isEmpty() && r.peek() > tmp) {
        this.push(r.pop());
      }
      r.push(tmp);
    }
    while (!r.isEmpty()) {
      this.push(r.pop());
    }
  }
}
