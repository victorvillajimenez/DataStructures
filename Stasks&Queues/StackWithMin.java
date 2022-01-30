public class StackWithMin extends java.util.Stack<NodeWithMin> {
  public static void main (String[] args) {
    StackWithMin stack = new StackWithMin();
    // System.out.println(stack.min());
    // System.out.println(stack.max());
    stack.push(87);
    stack.push(13);
    stack.push(764);
    stack.push(5);
    stack.push(4311);
    stack.push(8);

    System.out.println(stack.peek().value + " : " + stack.min() + " : " + stack.max());
  }

  public void push (int value) {
    int newMin = Math.min(value, min());
    int newMax = Math.max(value, max());
    super.push(new NodeWithMin(value, newMin, newMax));
  }

  public int min () {
    if (this.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return peek().min;
    }
  }

  public int max () {
    if (this.isEmpty()) {
      return Integer.MIN_VALUE;
    } else {
      return peek().max;
    }
  }
}

class NodeWithMin {
  public int value;
  public int min;
  public int max;
  public NodeWithMin (int value, int min, int max) {
    this.value = value;
    this.min = min;
    this.max = max;
  }
}
