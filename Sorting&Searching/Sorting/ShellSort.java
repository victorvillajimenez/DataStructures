import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
// It is called 'Insertion con incrementos o saltos decrecientes'
// It is an in-place comparison sort.
// Improvement of direct inserction
// Improvement for Insertion sort
// Insertion with increment or decrement leaps/loops
// Worst complexity: Depends on gap sequence
// Average complexity: n*log(n)^2 or n^(3/2)
// Best complexity: n
// Method: Insertion
// Stable: No
// Class: Comparison sort
// By Donald L. Shell
public class ShellSort {
  public static void main (String[] args) {
    int[] a = {9,8,99,110,8,87,637,8,3,13,87,12,99,1,55};
    display(a);
    perform(a);
    display(a);

    // int[] a = new int[0];
    // List<String> list = new ArrayList<>();
    // try (Stream<String> stream = Files.lines(Paths.get("random_numbers.txt"))) {
    //   list = stream.collect(Collectors.toList());
    //   a = new int[list.size()];
    //   System.out.println("Count : " + list.size());
    //   System.out.println("Original array");
    //   for (int i = 0; i < list.size(); i++) {
    //     System.out.print(list.get(i) + ",");
    //     a[i] = Integer.parseInt(list.get(i));
    //   }
    // } catch (IOException e) {
    //   System.out.println("\nERROR => Exception...");
    // }
    // System.out.println("\nCalling sort method...");
    // sort(a);
    // display(a);
  }

  public static void perform (int[] a) {
    int j;
    for (int gap = a.length / 2; gap > 0; gap /= 2) {
      // System.out.println("Gap: " + gap);
      for (int i = gap; i < a.length; i++) {
        Integer tmp = a[i];
        // System.out.println("Element: " + tmp + " at position: " + i);
        // Condition could be: j >= gap && a[j - gap] > tmp
        for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap) {
          // System.out.println("a[j - gap] = " + a[j - gap] + " for j: " + j);
          a[j] = a[j - gap];
        }
        a[j] = tmp;
      }
      // System.out.println();
    }
  }

  public static void sort(int a[]) {
    int j;
    int counter = 0;
    System.out.println("Length: " + a.length);
    for (int gap = a.length / 2; gap > 0; gap /= 2 ) {
      System.out.println("\nGap: " + gap);
      for (int i = gap; i < a.length; i++) {
        System.out.println("\nI: " + i);
        Integer tmp = a[i];
        counter++;
        for (j = i; j >= gap && tmp.compareTo( a[j - gap] ) < 0; j -= gap) {
          a[j] = a[j - gap];
          System.out.println("\nJ: " + j);
          for (int item : a) System.out.print(item + ",");
        }
        a[j] = tmp;
        display(a);
      }
    }
    System.out.println("Counter: " + counter);
  }

  public static void display (int[] a) {
    System.out.println();
    for (int e : a) System.out.print(e + ",");
    System.out.println();
  }
}