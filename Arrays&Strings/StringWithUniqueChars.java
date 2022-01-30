public class StringWithUniqueChars {

  public static void main(String[] args) {
    StringWithUniqueChars instance = new StringWithUniqueChars();
    
    int val = " ".charAt(0);
    for (Character c : "abczABC 123?!".toCharArray()) {
      int i = (int) c;
      System.out.print("[" + c + " : " + i + "] - ");
    }
    System.out.println("\n1 << 31 : " + (1 << 31));
  
    // System.out.println("isUniqueChars1 : " + instance.isUniqueChars1(" abcb"));
    System.out.println("isUniqueChars2 : " + instance.isUniqueChars2("abczABC 123?!"));
  }

  boolean isUniqueChars1 (String str) {
    if (str.length() > 128) { return false; }

    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (char_set[val]) {
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }
  
  boolean isUniqueChars2 (String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - ' ';
      System.out.println("checker, val, (1 << val): " + checker + " : " + val + " : " + (1 << val) + " : " + (checker & (1 << val)));
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }
}
