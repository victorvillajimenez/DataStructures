public class LinearSearch {
  public static void main (String[] args) {
    int[] a = {9, 76, 0, 1, 8, 2, 7, 3, 6, 4, 5, 23};
    int x = 76;
    System.out.println("Value: " + x + " is at the position: " + perform(a, x));
  }

  public static int perform (int[] a, int x) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == x) {
        return i;
      }
    }
    return -1;
  }
}