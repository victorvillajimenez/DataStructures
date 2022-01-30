public class StackWithMinMax extends java.util.Stack<Integer> {
  java.util.Stack<Integer> sMin;
  java.util.Stack<Integer> sMax;

  public StackWithMinMax () {
    sMin = new java.util.Stack<Integer>();
    sMax = new java.util.Stack<Integer>();
  }

  public static void main (String[] args) {
    StackWithMinMax stack = new StackWithMinMax();
    // System.out.println(stack.min());
    // System.out.println(stack.max());
    stack.push(87);
    stack.push(13);
    stack.push(764);
    stack.push(5);
    stack.push(4311);
    stack.push(8);
    // stack.pop();
    // stack.pop();

    System.out.println(stack.peek() + " : " + stack.min() + " : " + stack.max());
  }

  public void push (int value) {
    if (value <= min()) {
      sMin.push(value);
    }
    if (value >= max()) {
      sMax.push(value);
    }
    super.push(value);
  }

  public Integer pop () {
    int value = super.pop();
    if (value == min()) {
      sMin.pop();
    }
    if (value == max()) {
      sMax.pop();
    }
    return value;
  }

  public int max () {
    if (sMax.isEmpty()) {
      return Integer.MIN_VALUE;
    } else {
      return sMax.peek();
    }
  }

  public int min () {
    if (sMin.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return sMin.peek();
    }
  }
}
