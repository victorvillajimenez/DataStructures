import java.util.Stack;
import java.util.ArrayList;

public class SetOfStacks {
  int capacity;
  ArrayList<Stack> stacks = new ArrayList<Stack>();

  public static void main (String[] args) {
    SetOfStacks stack = new SetOfStacks(4);
    
    stack.push(342);
    stack.push(54);
    stack.push(783);
    stack.push(2);
    stack.push(63);
    stack.push(672);
    stack.push(242);
    stack.push(738);
    stack.push(4);
    stack.push(49);
    stack.push(1);
    stack.push(74);
    stack.push(100);

    stack.showData();

    stack.pop();
    stack.pop();

    stack.showData();
  }

  public SetOfStacks (int capacityPerStack) {
    this.capacity = capacityPerStack;
  }

  public void showData () {
    System.out.println("\n=============");
    System.out.println("SHOW DATA ");
    for (Stack<Integer> s : stacks) {
      System.out.println("\n\nStack size = " + s.size());
      for (Integer e : s) {
        System.out.println("Element value = " + e);
      }
    }
  }

  public void push (int value) {
    Stack s = getLastStack();
    if (s == null || isFull(s)) {
      s = new Stack<Integer>();
      s.push(value);
      stacks.add(s);
    } else {
      s.push(value);
    }
  }

  public int pop () {
    Stack s = getLastStack();
    if (s == null) {
      throw new java.util.EmptyStackException();
    }
    int value = (Integer)s.pop();
    if (s.isEmpty()) {
      stacks.remove(stacks.size() - 1);
    }
    return value;
  }

  private Stack<Integer> getLastStack () {
    if (!stacks.isEmpty()) {
      return stacks.get(stacks.size() - 1);
    }
    return null;
  }

  private boolean isFull (Stack s) {
    return s.size() == this.capacity;
  }
}
