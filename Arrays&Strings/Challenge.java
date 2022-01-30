public class Challenge {
  public static void main (String[] args) {
    int[] asciiArray = new int[128];
    // System.out.println("Challenge: ");
    // System.out.println(isUnique(".!<? 019azAZ"));
    // System.out.println(isUnique("Challenge"));
    // String s = "admin";
    // try {
    //   byte[] bytes = s.getBytes("US-ASCII");
    //   for (byte i : bytes) {
    //     System.out.println(i);
    //   }
    // } catch (Exception e) {}
    
    
    // background: #f5f5f5;
    
    Challenge c = new Challenge();
    System.out.println(c.lengthOfLongestSubstring("tmmzuxt"));
  }
  
  public static boolean isUnique (String s) {
    int[] ascii = new int[128];
    for (char c : s.toCharArray()) {
      int i = (int) c;
      ascii[i]++;
      if (ascii[i] > 1) return false;
    }
    return true;
  }
  
  
  public int lengthOfLongestSubstring(String s) {
    int[] ascii = new int[128];
    for (int c = 0; c < ascii.length; c++) {
      ascii[c] = -1;
    }
    int lastIndex = -1;
    int count = 0;
    int max = 0;
    for (int c = 0; c < s.length(); c++) {
      int i = (int) s.charAt(c);
      if (ascii[i] == -1) {
        count++;
        ascii[i] = c;
      } else {
        int position = ascii[i];
        if (lastIndex > ascii[i]) {
          position = lastIndex;
        }
        int aux = c - position;
        if (aux > max) {
          max = aux;
        }
        if (count > max) {
          max = count;
        }
        count = aux;
        lastIndex = c;
        ascii[i] = c;
      }
    }
    return count > max ? count : max;
  }
}
