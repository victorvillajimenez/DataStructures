public class StringRotation {
  public static void main (String[] args) {
    boolean x = isSubstring("waterbottles", "erbottleswat");
    System.out.println("Result: " + x);
  }
  
  public static boolean isSubstring (String s1, String s2) {
    String s1s1 = s1 + s1;
    for (int i = 0, j = 0; i < s1s1.length(); i++) {
      if (s1s1.charAt(i) == s2.charAt(j)) {
        j++;
        if (j == s2.length()) return true;
      } else {
        j = 0;
      }  
    }
    return false;
  }
}