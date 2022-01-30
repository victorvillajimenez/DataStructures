public class ZeroMatrix8 {
  public void perform (int[][] a) {
    boolean[] rows = new boolean[a.length];
    boolean[] columns = new boolean[a[0].length];
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[0].length; c++) {
        if (row[r] == true) {
          break;
        }
        if (columns[c] == true) {
          break;
        }
        if (a[r][c] == 0) {
          row[r] = true;
          columns[c] = true;
        }
      }
    }
  }
}
