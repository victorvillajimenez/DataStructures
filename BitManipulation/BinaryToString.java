public class BinaryToString {
  public static void main (String[] args) {
    // int number = 2147483647; // Max Integer Value
    // double num = 0.8785555555555555555555555555555555555555555555555D;
    double num = .75D;
    System.out.println("Number: " + toBinaryString(num));
  }
  
  public static String toBinaryString (double num) {
    if (num >= 1 || num <= 0) { return "ERROR"; }

    int i = 0;
    java.lang.StringBuilder s = new java.lang.StringBuilder();
    s.append(".");
    while (num > 0) {
      if (s.length() >= 32) {
        return "ERROR:" + s.toString();
      }
      double temp = num * 2D;
      if (temp >= 1) {
        s.append(1);
        num = temp - 1D;
      } else {
        s.append(0);
        num = temp;
      }
    }
    
    return s.toString();
  }
}
