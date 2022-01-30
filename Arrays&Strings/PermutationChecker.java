public class PermutationChecker {
  public static void main (String[] args) {
    PermutationChecker pc = new PermutationChecker();
    System.out.println(pc.permutation1("qwert yuiop", "poqwerty ai"));
    System.out.println(pc.permutation2("qwert yuiop", "poqwerty ai"));
  }
  
  String sort (String s) {
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
  }
  
  boolean permutation1 (String s, String t) {
    if (s.length() != s.length()) {
      return false;
    }
    return sort(s).equals(sort(t));
  }
  
  boolean permutation2 (String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    
    int[] letters = new int[128]; // Assumption: ASCII
    for (int i = 0; i < s.length(); i++) {
      letters[s.charAt(i)]++;
    }
    
    for (int i = 0; i < t.length(); i++) {
      letters[t.charAt(i)]--;
      if (letters[t.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }
}
  