import java.util.*;
public class ZeroMatrix {
  public static void main (String[] args) {
    int[][] m = {
      {0 ,4 ,6 ,8},
      {1 ,0 ,5 ,7},
      {9 ,2 ,0,10},
      {20,30,40,0}};      
    perform(m);
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static void perform (int[][] m) {
    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> cols = new HashSet<Integer>();
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        if (m[i][j] == 0) {
          if (!rows.contains(i)) rows.add(i);
          if (!cols.contains(j)) cols.add(j);
        }
      }
    }
    for (Integer row : rows) {
      for (int c = 0; c < m[0].length; m[row][c++] = 0);
    }
    for (Integer col : cols) {
      for (int r = 0; r < m.length; m[r++][col] = 0);
    }
  }
  
}