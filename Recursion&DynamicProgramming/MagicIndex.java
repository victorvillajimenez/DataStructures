public class MagicIndex {
  public static void main (String[] args) {
    int[] a = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
    int[] b = {-10, -5, 2, 2, 2, 3, 4, 5, 9, 12, 13};
    int[] c = {-10, -5, 2, 2, 2, 3, 4, 5, 9, 12, 13};
    int i = find(a, 0, a.length - 1);
    int j = findWithDistinct(b, 0, b.length - 1);
    int k = findFast(c, 0, c.length - 1);
    System.out.println("Magic Index - i: " + i);
    System.out.println("Magic Index - j: " + j);
    System.out.println("Magic Index - k: " + k);
  }
  
  public static int find (int[] a, int start, int end) {
    if (end < start) {
      return -1;
    }
    int i = (start + end) / 2;
    if (a[i] == i) {
      return i;
    } else if (a[i] > i) {
      return find(a, start, i - 1);
    } else {
      return find(a, i + 1, end);
    }
  }
  
  public static int findWithDistinct (int[] a, int start, int end) {
    if (end < start) {
      return -1;
    }
    int i = (start + end) / 2;
    if (a[i] == i) {
      return i;
    }
    int x = find(a, start, i - 1);
    if (x == -1) {
      x = find(a, i + 1, end);
    }
    return x;
  }
  
  public static int findFast (int[] a, int start, int end) {
    if (end < start) {
      return -1;
    }
    int i = (start + end) / 2;
    int m = a[i];
    if (m == i) {
      return i;
    }
    /* Search left */
    int j = Math.min(i - 1, m);
    int l = findFast(a, start, j);
    if (l >= 0) {
      return l;
    }
    /* Search right */
    int k = Math.max(i + 1, m);
    int r = findFast(a, k, end);
    return r;
  }
}
