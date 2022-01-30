import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class BubbleSortVisual {
  public static void sort1( int array[] ) {
    int counter = 0;
    System.out.println("\nStart sorting");
    for ( int i = 0; i < array.length - 1; i++ ) {
      for ( int j = 0; j < array.length - i - 1; j++ ) {
        counter++;
        if ( array[j] > array[j + 1] ) {
          int tmp = array[j + 1];
          array[j + 1] = array[j];
          array[j] = tmp;
        }
        for (int item : array) {
          System.out.print(item + ",");
        }
        System.out.println("[i:" + i + ", j:" + j + "]");
      }
    }
    System.out.println("\nCounter:" + counter);
  } 
  public static void sort2( int array[] ) {
    int counter = 0;
    System.out.println("\nStart sorting");
    for ( int i = 0; i < array.length - 1; i++ ) {
      for ( int j = i + 1; j < array.length; j++ ) {
        counter++;
        if ( array[i] > array[j] ) {
          int tmp = array[j];
          array[j] = array[i];
          array[i] = tmp;
        }  
        for (int item : array) {
          System.out.print(item + ",");
        }
         System.out.println("[i:" + i + ", j:" + j + "]");
      }
    }
    System.out.println("\nCounter:" + counter);
  }
  public static void sort3( int array[] ) {
    int counter = 0;
    System.out.println("\nStart sorting");
    for ( int i = 1; i < array.length; i++ ) {
      for ( int j = array.length - 1; j >= i; j-- ) {
        counter++;
        if ( array[j] < array[j - 1] ) {
          int tmp = array[j -1];
          array[j - 1] = array[j];
          array[j] = tmp;
        }  
        for (int item : array) {
          System.out.print(item + ",");
        }
         System.out.println("[i:" + i + ", j:" + j + "]");
      }
    }
    System.out.println("\nCounter:" + counter);
  }
  public static void main(String args[]) {
    int[] array = new int[0];
    List<String> list = new ArrayList<>();

    try (Stream<String> stream = Files.lines(Paths.get("random_numbers.txt"))) {
      list = stream.collect(Collectors.toList());
      array = new int[list.size()];
      System.out.println("count : " + list.size());
      System.out.println("Original array");
      for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i) + ",");
        array[i] = Integer.parseInt(list.get(i));
      }
    } catch(IOException e) {
    }
    
    sort3(array);
    for (int item : array) {
      System.out.println("Item:" + item);
    }
  }
}