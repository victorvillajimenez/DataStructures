public class BinarySearch {
  public static void main (String[] args) {
    // LIST MUST BE ORDERED
    System.out.println(perform(new int[]{1,2,3,4,7,9,10,12,18,21}, 12));
  }

  public static int perform (int[] a, int x) {
    int p = 0;
    int r = a.length - 1;
    int q = -1;
    while (p <= r) {
      q = (p + r) / 2;
      if (a[q] == x) {
        return q;
      } else if (a[q] > x) {
        r = q - 1;
      } else {
        p = q + 1;
      }
    }
    return -1;
  }
}