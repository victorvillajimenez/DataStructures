public class SortedStrings {
  public static void main(String[] args) {
    printSortedStrings(2, "");
  }
  
  public static void printSortedStrings(int remaining, String prefix) {
    if (remaining == 0) {
      isInOrder(prefix);
      // if (isInOrder(prefix)) {
      //   System.out.println(prefix);
      // } else {
      //   System.out.println("NOT ORDER => " + prefix);
      // }
    } else {
      for (char c = 'a'; c <= 'z'; c++) {
        System.out.println("remaining, prefix => " +  (remaining - 1) + " - " + (prefix + c));
        printSortedStrings(remaining - 1, prefix + c);
      }
    }
  }
  
  public static boolean isInOrder(String s) {
    boolean isInOrder = true;
    for (int i = 1; i < s.length(); i++) {
      System.out.println(s);
      int prev = ithLetter(s.charAt(i - 1));
      int curr = ithLetter(s.charAt(i));
      if (prev > curr) {
        isInOrder = false;
      }
    }
    return isInOrder;
  }
  
  public static char ithLetter(int i) {
    return (char) (((int) 'a') + i);
  }
}