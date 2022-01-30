import java.util.Arrays;

/*
  It is called "partition-exchange sort"
  It is a "divide and conquer" algorithm (based on multi-branched recursion)

  It is recursived
  Pick a random element and partition the array, such that all numbers that are less than it come before all elements
  that are greater than it. Then do that for each half, then each quarter, etc. O(n log n) expected, O(n^2) worst case.

  Inventor: Tony Hoare (1960)
  Worst complexity: n^2
  Average complexity: n*log(n)
  Best complexity: n*log(n)
  Space complexity: log(n)
  Method: Partitioning
  Stable: No
  Class: Comparison sort
*/
public class QuickSort {
  public static void main (String[] args) {
    int[] a = {12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};
    sort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }

  public static void sort (int[] a, int start, int end) {
    if (start < end) {
      int p = partition(a, start, end);
      sort(a, start, p - 1);
      sort(a, p + 1, end);
    }
  }

  public static int partition (int[] a, int start, int end) {
    int pivot = a[end];
    int j = start - 1;
    for (int i = start; i < end; i++) {
      if (a[i] <= pivot) {
        int tmp = a[++j];
        a[j] = a[i];
        a[i] = tmp;
      }
    }
    a[end] = a[++j];
    a[j] = pivot;
    return j;
  }
}
