import java.util.*; // Properties, Arrays
import java.io.InputStream;
import java.io.IOException;

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
public class MergeSortCracking {
  public static void main (String[] args) {
    new MergeSortCracking();
  }

  public static void mergesort (int[] a) {
    int[] t = new int[a.length];
    divide(a, t, 0, a.length - 1);
  }

  private static void divide (int[] a, int[] t, int start, int end) {
    if (end <= start) return;
    int mid = (start + end) / 2;
    divide(a, t, start, mid);
    divide(a, t, mid + 1, end);
    merge(a, t, start, mid, end);
  }

  private static void merge (int[] a, int[] t, int start, int mid, int end) {
    for (int i = start; i <= end; i++) {
      t[i] = a[i];
    }
    int i = start; // index's tmp

    int l = start;
    int r = mid + 1;

    while (l <= mid && r <= end) {
      if (t[l] <= t[r]) {
        a[i++] = t[l++];
      } else {
        a[i++] = t[r++];
      }
    }

    int remaining = mid - l;
    for (int c = 0; c <= remaining; c++) {
      a[i + c] = t[l + c];
    }
  }

  public MergeSortCracking () {
    int[] a = {9,7,3,1,6,3,2,6,8,9,2,3,0};
    Properties properties = new Properties();
    InputStream inputStream = getClass().getResourceAsStream("100RandomNumbers.properties");
    try 
    {
      if(inputStream != null) {
        properties.load(inputStream);
        String[] values = properties.getProperty("values").split(",");
        a = Arrays
          .stream(values)
          .mapToInt(v -> Integer.valueOf(v))
          .toArray();
      }        
    } 
    catch (IOException e) {
      e.printStackTrace();
    }catch (Exception e) {
      e.printStackTrace();
    }
    
    long startTime = System.nanoTime();
    mergesort(a);
    long endTime = System.nanoTime();
    long timeElapsed = endTime - startTime;

    System.out.println("Execution time in nanoseconds  : " + timeElapsed);
    System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
  }
}
