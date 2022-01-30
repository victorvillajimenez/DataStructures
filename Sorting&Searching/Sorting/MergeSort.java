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
public class MergeSort {
  public static void main (String[] args) throws ClassNotFoundException {
    int[] a = {9,7,3,1,6,3,2,6,8,9,2,3,0};
    Properties properties = new Properties();
    InputStream inputStream = Class.forName("MergeSort").getResourceAsStream("100RandomNumbers.properties");
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
    perform(a);
    long endTime = System.nanoTime();
    long timeElapsed = endTime - startTime;

    System.out.println("Execution time in nanoseconds  : " + timeElapsed);
    System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
    
    // 2nd alternative
    // int[] a = {9,7,3,1,6,3,2,6,8,9,2,3,0};
    // perform(a);
    // for (int i = 0; i < a.length; i++) {
    //   System.out.println(a[i]);
    // }
  }

  public static void perform (int[] a) {
    divide(a, 0, a.length - 1);
  }

  public static void divide (int[] a, int start, int end) {
    if (end <= start) return;
    int mid = (start + end) / 2;
    divide(a, start, mid);
    divide(a, mid + 1, end);
    merge(a, start, mid, end);
  }
  
  public static void merge (int[] a, int start, int mid, int end) {
    int tmp[] = new int[end - start + 1];
    int k = 0; // index's tmp
    int i = start;
    int j = mid + 1;
    while (i <= mid && j <= end) {
      if (a[i] < a[j]) {
        tmp[k++] = a[i++];
      } else {
        tmp[k++] = a[j++];
      }
    }
    if (i <= mid) {
      while (i <= mid) {
        tmp[k++] = a[i++];
      }
    } else if (j <= end) {
      while (j <= end) {
        tmp[k++] = a[j++];
      }
    }
    for (int c = 0; c < tmp.length; c++) {
      a[start + c] = tmp[c];
    }
  }
}
