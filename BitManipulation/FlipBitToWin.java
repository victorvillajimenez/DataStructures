import java.lang.StringBuilder;

public class FlipBitToWin {
  public static void main (String[] args) {
    System.out.println("Integer.BYTES: " + Integer.BYTES * 8);
    int num = 0;
    
    boolean isFirstGroup = true;
    int countZeros = 0;
    int size = 1;
    
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
    for (int i = 0; i < Integer.BYTES * 8; i++) {
      boolean bit = getBit(num, i);
      System.out.println("BIT: " + bit);
      if (bit) { // i is 1
        if (isFirstGroup) {
          s1.append(1);
        } else {
          s2.append(1);
        }
        countZeros = 0;
      } else { // i is 0
        countZeros++;
        if (countZeros == 2) {
          s1 = new StringBuilder();
          s2 = new StringBuilder();
          isFirstGroup = true;
        } else if (countZeros == 1) {
          if (s1.length() > 0 && s2.length() > 0) {
            isFirstGroup = true;
            if ((s1.length() + s2.length() + 1) > size) {
              size = s1.length() + s2.length() + 1;
            }
            s1 = s2;
            s2 = new StringBuilder();
          } else if (s1.length() > 0) {
            if (s1.length() >= size) {
              size = s1.length() + 1;
            }
            isFirstGroup = false;
          }
        }
      }
    }
    if (countZeros == 0) {
      if (s1.length() > 0 && s2.length() > 0) {
        size = s1.length() + s2.length() + 1;
      } else if (s1.length() > 0) {
        size = s1.length() < 32 ?  s1.length() + 1 : s1.length();
      }
    }
    System.out.println("THE MAX LENGTH IS: " + size);
  }
  
  public static boolean getBit (int num, int i) {
    return (num & (1 << i)) != 0;
  }
}
