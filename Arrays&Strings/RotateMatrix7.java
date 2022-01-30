public class RotateMatrix7 {
  // m[row][column]
  public void perform (int[][] m) {
    for (int o = 0; o < m.length / 2; o++) {
      for (int i = o; i < m.length - 1 - o; i++) {
        int tmp = m[m.length - i][o]; // left to tmp
        m[m.length - i][o] = m[m.length - o][m.length - i]; // bottom to left
        m[m.length - o][m.length - i] = m[i][m.length - o]; // right to bottom
        m[i][m.length - o] = m[o][i]; // top to right
        m[o][i] = tmp; // tmp to top;
      }
    }
  }
}