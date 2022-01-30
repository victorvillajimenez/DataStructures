public class BitManipulation {
  public static void main (String[] args) {
    int x = 93242;
    int y = 93242;
    int count = 1; 
    System.out.println("repeatedArithmeticShift (x: " + x + ", count: " + count + ") = " + repeatedArithmeticShift(x, count));
    System.out.println("repeatedLogicalShift (y: " + y + ", count: " + count + ") = " + repeatedLogicalShift(y, count));
    System.out.println("6 << 2 : " + (6 << 2)); // 110 => 11000 : 24
    // System.out.println("6 <<< 2 :" + (6 <<< 2)); // It does not exist because It is not required
  }

  public static int repeatedArithmeticShift (int x, int count) {
    for (int i = 0; i < count; i++) {
      x >>= 1;
    }
    return x;
  }

  public static int repeatedLogicalShift (int x, int count) {
    for (int i = 0; i < count; i++) {
      x >>>= 1;
    }
    return x;
  }

  public static boolean getBit (int num, int i) {
    return (num & (1 << i)) != 0;
  }

  public static int setBit (int num, int i) {
    return num | (1 << i);
  }

  public static int clearBit (int num, int i) {
    int mask = ~(1 << i);
    return num & mask;
  }

  public static int clearBitsMSBThroughI (int num, int i) {
    int mask = (1 << i) - 1;
    return num & mask;
  }

  public static int clearBitsIThrough0 (int num, int i) {
    int mask = (-1 << (i + 1));
    return num & mask;
  }

  public static int updateBit (int num, int i, boolean bitIs1) {
    int value = bitIs1 ? 1 : 0;
    int mask = ~(1 << i);
    return (num & mask) | (value << i);
  }
}
