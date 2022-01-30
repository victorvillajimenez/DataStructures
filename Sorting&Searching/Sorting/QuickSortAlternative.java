import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
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
public class QuickSortAlternative {  
  public static void sort2(int[] a, int left, int right) {
    int pivot = a[left];
    int i = left;
    int j = right;
    int aux;
    while (i < j) {
      while (a[i] <= pivot && i < j) i++;
      while (a[j] > pivot) j--;
      if (i < j) {
        aux = a[i];
        a[i] = a[j];
        a[j] = aux;
      }
    }
    a[left] = a[j];
    a[j] = pivot;
    if (left < j - 1)  sort2(a, left, j - 1);
    if (j + 1 < right) sort2(a, j + 1, right);
  }

  public static void sort(int[] a, int left, int right) {
    int pivot = a[left];
    int i = left;
    int j = right;
    int aux;
    System.out.println("pivot: " + pivot + " . left: " + left + ". right: " +right);
    while (i < j) {
      while (a[i] <= pivot && i < j) i++;
      while (a[j] > pivot) j--;
      if (i < j) {
        aux = a[i];
        a[i] = a[j];
        a[j] = aux;
      }
      display(a);
      System.out.println("[i:" + i + ", j:" + j + "]");
    }
    System.out.println("i:" + i + " > j:" + j);
    a[left] = a[j];
    a[j] = pivot;
    if (left < j - 1)  sort(a, left, j - 1);
    if (j + 1 < right) sort(a, j + 1, right);
  }
  
  public static void main(String args[]) {
    int a[] = new int[0];
    List<String> list = new ArrayList<>();
    
    try (Stream<String> stream = Files.lines(Paths.get("random_numbers.txt"))) {
      list = stream.collect(Collectors.toList());
      a = new int[list.size()];
      System.out.println("Count : " + list.size());
      System.out.println("Original array");
      for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i) + ",");
        a[i] = Integer.parseInt(list.get(i));
      }
    } catch (IOException e) {
    }
    System.out.println("\nCalling sort method...");
    sort(a, 0, a.length - 1);
    display(a);
  }
  
  public static void display (int[] a) {
    System.out.println();
    for (int e : a) System.out.print(e + ",");
    System.out.println();
  }
}