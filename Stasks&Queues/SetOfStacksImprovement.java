import java.util.ArrayList;

public class SetOfStacksImprovement {
  int capacity;
  ArrayList<Stack> stacks = new ArrayList<Stack>();

  public static void main (String[] args) {
    SetOfStacksImprovement stack = new SetOfStacksImprovement(4);

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
    
    stack.popAt(0); // Will remove element with value 2
    
    stack.showData();
    
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    
    stack.showData();

    stack.push(500);
    stack.push(8);
    stack.push(71);

    stack.showData();

    stack.popAt(1); // Will remove element with value 4

    stack.showData();
  }

  public SetOfStacksImprovement (int capacityPerStack) {
    this.capacity = capacityPerStack;
  }

  public void showData () {
    System.out.println("\n==============");
    System.out.println("SHOW DATA");
    for (Stack stack : stacks) {
      System.out.println("\n\nStack size = " + stack.size);
      Node current = stack.bottom;
      while (current != null) {
        System.out.println("Element value = " + current.value);
        current = current.above;
      }
    }
  }

  public void push (int value) {
    Stack s = getLastStack();
    if (s == null || s.isFull()) {
      s = new Stack(capacity);
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
    int value = s.pop();
    if (s.isEmpty()) {
      stacks.remove(stacks.size() - 1);
    }
    return value;
  }

  public boolean isEmpty () {
    Stack last = getLastStack();
    return last == null || last.isEmpty();
  }

  public int popAt (int index) {
    return leftShift(index, true);
  }

  public int leftShift (int index, boolean removeTop) {
    Stack stack = stacks.get(index);
    int remove_item;
    if (removeTop) {
      remove_item = stack.pop();
    } else {
      remove_item = stack.removeBottom();
    }
    if (stack.isEmpty()) {
      stacks.remove(index);
    } else if (stacks.size() > index + 1) {
      int v = leftShift(index + 1, false);
      stack.push(v);
    }
    return remove_item;
  }

  private Stack getLastStack () {
    if (stacks.isEmpty()) { return null; }
    return stacks.get(stacks.size()  - 1);
  }
}

class Node {
  public Node above, below;
  public int value;
  public Node (int value) {
    this.value = value;
  }
}

class Stack {
  private int capacity;
  public Node top, bottom;
  public int size = 0;
  
  public Stack (int capacity) {
    this.capacity = capacity;
  }
  public boolean isFull () {
    return capacity == size;
  }
  public boolean isEmpty () {
    return size == 0;
  }

  public void join (Node above, Node below) {
    if (below != null) below.above = above;
    if (above != null) above.below = below;
  }

  public boolean push (int v) {
    if (size >= capacity) return false;
    size++;
    Node n = new Node(v);
    if (size == 1) bottom = n;
    join (n, top);
    top = n;
    return true;
  }

  public int pop () {
    Node t = top;
    top = top.below;
    size--;
    return t.value;
  }

  public int removeBottom () {
    Node b = bottom;
    bottom = bottom.above;
    if (bottom != null) bottom.below = null;
    size--;
    return b.value;
  }
}
