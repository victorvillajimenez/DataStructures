public class RecursiveSearch {
  public static void main (String[] args) {
    // reduceByOne(10);
    System.out.println(recursiveLinearSearch(new int[] {1, 48, 4, 28, 34, 76, 9, 3}, 0, 300));

    reduceByOne(10);
  }

  public static int recursiveLinearSearch (int[] a, int i, int x) {
    if (i >= a.length) {
      return -1;
    } else if (a[i] == x) {
      return i;
    } else {
      System.out.println("Index at: " + i);
      return recursiveLinearSearch(a, i + 1, x);
    }
  }

  public static int recursiveBinarySearch (int[] a, int p, int r, int x) {
    if (p > r) {
      return -1;
    } else {
      int q = (p + r) / 2;
      if (a[q] == x) {
        return q;
      } else if (a[q] > x) {
        return recursiveBinarySearch(a, p, q - 1, x);
      } else {
        return recursiveBinarySearch(a, q + 1, r, x);
      }
    }
  }

  public static void reduceByOne (int n) {
    System.out.println("In reduceByOne method. Value: " + n);
    if (n > 0) {
      reduceByOne(n - 1);
    }
    System.out.println("Completed call: " + n);
  }
}