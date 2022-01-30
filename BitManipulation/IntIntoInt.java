public class IntIntoInt {
  public static void main (String[] args) {
    System.out.println("Update:" + update(34,5,2,6));
    System.out.println("Update:" + updateBook(34,5,2,6));
  }
  
  public static int update (int n, int m, int i , int j) {
    if (i > j || i < 0 || j >= 32) { return 0; }
    // Clear up N between J to I indexes with 0's

    // j - i. Where J >= I
    int x = j - i + 1;
    int mask = -1; // Start wit 1's
    mask <<= x; // Shift X times with 0's
    mask = ~mask; // Invert the number to have 0's first and then 1's
    mask <<= i; // Shift I times with 0's
    mask = ~mask; // Invert the number to have 1's, 0's and 1's. Mask is ready
    
    int nCleared = n & mask;
    int mShifted = m << i;
    
    return nCleared | mShifted;
  }
  
  public static int updateBook (int n, int m, int i, int j) {
    if (i > j || i < 0 || j >= 32) { return 0; }

    int allOnes = ~0;
    int left = j < 31 ? (allOnes << (j + 1)) : 0;
    int right = ((1 << i) - 1);
    int mask = left | right;
    
    int nCleared = n & mask;
    int mShifted = m << i;
    return nCleared | mShifted;
  }

}