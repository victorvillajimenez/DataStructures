/*
  Array has two parts: 
    Left side: sorted sublist (by time will increase)
    Right side: unsorted sublist (by time will decrease)

  Find the smallest element using a linear scan and move it to the front. Then, find the second
  smallest and move it, again doing a linear scan. Continue doing this until all the elements
  are in place. O(n^2).
    
  Worst complexity: n^2
  Average complexity: n^2
  Best complexity: n^2
  Space complexity: 1
  Method: Selection (every iteration it finds the smallest in Rigth Side and swap it with the last Left Side)
  Stable: No
  Class: Comparison sort
  Worst case number of swaps: n - 1
*/
public class SelectionSort {
  public static void main (String[] args) {
    int[] a = {9,8,3,13,87,12,99};
    perform(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }

  public static void perform (int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[min] > a[j]) {
          min = j;
        }
      }
      if (i != min) {
        int t = a[i];
        a[i] = a[min];
        a[min] = t;
      }
    }
  }
}
