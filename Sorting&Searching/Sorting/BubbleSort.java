/*
  Also called Sinking Sort

  Start at the beginning of an array and swap the first two elements if the first is bigger than
  the second. Go to the next pair, etc, continuously making sweeps of the array until sorted.
  O(n^2).

  Worst complexity: n^2
  Average complexity: n^2
  Best complexity: n
  Space complexity: 1
  Method: Exchanging (swaps)
  Stable: Yes
  Class: Comparison sort
*/
public class BubbleSort {
  public static void main(String[] args) {
    int[] a = new int[]{96,58,2,7,21,43,9,31,1,64,81,99,12,0};
    a = perform(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
    System.out.println();
  }

  public static int[] perform(int[] a) {
    for (int i = a.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        System.out.print("[" + i + "][" + j + "], ");
        if (a[j] > a[j + 1]) {
          int tmp = a[j + 1];
          a[j + 1] = a[j];
          a[j] = tmp;
        }
      }
      System.out.println();
    }
    return a;
  }
}