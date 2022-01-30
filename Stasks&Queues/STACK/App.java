public class App {
  public static void main(String[] args) {
    // First example
    // Stack stack = new Stack(8);
    
    // stack.push(20);
    // stack.push(40);
    // stack.push(50);
    // stack.push(60);
    // stack.push(90);
    // stack.push(20);
    // stack.push(40);
    // stack.push(50);
    // stack.push(60);
    // stack.push(90);
    
    // while (!stack.isEmpty()) {
    //   long value = stack.pop();
    //   System.out.println(value);
    // }
    
    // Second example
    System.out.println(reverseString("HELLO WORLD!"));
  }
  
  public static String reverseString (String word) {
    int size = word.length();
    Stack stack = new Stack(size);
    String newWord = new String("");
    for (int i = 0; i < size; i++) {
      stack.push(word.charAt(i));
    }
    while (!stack.isEmpty()) {
      newWord += stack.pop();
    }
    return newWord;
  }
}
