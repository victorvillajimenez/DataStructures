public class InsertionSort {
  public static void main (String[] args) {
    int[] a = {9,8,99,110,8,87,637,8,3,13,87,12,99,1,55};
    perform(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }

  public static void perform (int[] a) {
    for (int i = 1; i < a.length; i++) {
      int e = a[i];
      int j = i - 1;
      for (; j >= 0 && a[j] > e; j--) {
        a[j + 1] = a[j];
      }
      a[j + 1] = e;
    }
  }
}