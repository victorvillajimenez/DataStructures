import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.nio.file.*;

/*
  It is a divide and conquer algorithm (based on multi-branched recursion)

  Sort each pair of elements. Then, sort every four elements by merging every two pairs.
  Then, sort every 8 elements, etc. O(n log n) expected and worst case.

  Inventor: John von Neumann
  Worst complexity: n*log(n)
  Average complexity: n*log(n)
  Best complexity: n*log(n)
  Space complexity: n
  Method: Merging
  Stable: Yes
  Class: Comparison sort
*/
public class MergeSortAlternative {
  public static int[] perform( int array[]) {
    return divide( array, array.length );
  }
  
  public static int[] divide(int a[], int n) {
    if (n > 1) {
      if (n%2 == 0) {
        int a1[] = new int[n/2];
        int a2[] = new int[n/2];
        for ( int i = 0; i < n; i++ ) {
          if ( i < n/2 ) {
            a1[i] = a[i];
          } else {
            int ind = i - n/2;
            a2[ind] = a[i];
          }
        }
        return combine(divide(a1, n/2), divide(a2, n/2), n);
      } else {
        int a1[] = new int[(n - 1)/2];
        int a2[] = new int[(n + 1)/2];
        for ( int j = 0; j < n; j++ ) {
          if ( j < (n -1)/2) {
            a1[j] = a[j];
          } else {
            int ind = j - ((n - 1)/2);
            a2[ind] = a[j];
          }
        }
        return combine(divide(a1, (n - 1)/2), divide(a2, (n + 1)/2), n);
      }
    } else {
      return a;
    }
  }
  
  public static int[] combine(int a1[], int a2[], int n) {
    int i = 0, j = 0, k = 0;
    int z[] = new int[n];
    if (n%2 == 0) {
      while (k < n) {
        if ( i >= (n/2) ) {
          z[k++] = a2[j++];
        } else if ( j >= (n/2) ) {
          z[k++] = a1[i++];
        } else if ( a1[i] <= a2[j] ) {
          z[k++] = a1[i++];
        } else {
          z[k++] = a2[j++];
        }
      }
      return z;
    } else {
      while (k < n) {
        if ( i >= ((n - 1) / 2) ) {
          z[k++] = a2[j++];
        } else if ( j >= ((n + 1) / 2) ) {
          z[k++] = a1[i++];
        } else if ( a1[i] <= a2[j] ) {
          z[k++] = a1[i++];
        } else {
          z[k++] = a2[j++];
        }
      }
      return z;
    }
  }
  
  public static void main(String args[]) {
    int[] array = new int[0];
    List<String> list = new ArrayList<>();
    
    try (Stream<String> stream = Files.lines(Paths.get("random_numbers.txt"))) {
      list = stream.collect(Collectors.toList());
      array = new int[list.size()];
      System.out.println("Count : " + list.size());
      System.out.println("Original array");
      for (int i = 0; i < list.size(); i++ ) {
        System.out.print(list.get(i) + ",");
        array[i] = Integer.parseInt(list.get(i));
      }
    } catch (IOException e) {
    }
    
    for (int item : perform(array)) {
      System.out.println("Item:" + item);
    }
  }
}