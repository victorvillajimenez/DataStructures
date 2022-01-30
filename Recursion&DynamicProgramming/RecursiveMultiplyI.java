public class RecursiveMultiplyI {
  public static void main (String[] args) {
    int x = minProduct(17, 23);
  }
  
  public static int minProduct (int a, int b) {
    int bigger = a < b ? b : a;
    int smaller = a < b ? a : b;
    return minProductHelper(smaller, bigger);
  }
  
  private static int minProductHelper (int smaller, int bigger) {
    if (smaller == 0) {
      return 0;
    } else if (smaller == 1) {
      return bigger;
    }
    
    int s = smaller >> 1;
    int side1 = minProductHelper(s, bigger);
    int side2 = side1;
    if (smalller % 2 == 1) {
      side2 = minProductHelper(smalller - s, bigger);
    }
    return side1 + side2;
  }
}