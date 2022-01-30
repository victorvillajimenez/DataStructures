public class RotateMatrix {
  public static void main (String[] args) {
    // int[][] m = {{2,4,6},{1,3,5},{9,8,7}};
    int[][] m = {
      {2 ,4 ,6 ,8},
      {1 ,3 ,5 ,7},
      {9 ,0 ,11,10},
      {20,30,40,50}};
    perform(m);
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static boolean perform (int[][] m) {
    if (m.length == 0) return false;
    if (m.length == 1) return true;
    if (m.length != m[0].length) return false;
    for (int i = 0; i < m.length / 2; i++) {
      int first = i;
      int last = m.length - 1 - i;
      for (int j = first; j < last; j++) {
        int top = m[first][j];
        // int offset = j - first;
        m[first][j] = m[last - (j - first)][first];
        m[last - (j - first)][first] = m[last][last - (j - first)];
        m[last][last - (j - first)] = m[j][last];
        m[j][last] = top;
      }
    }
    return true;
  }
}