import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RobotInAGrid {
  public static void main (String[] args) {

    boolean[][] maze1 = new boolean[2500][2500];
    for (boolean[] row : maze1) { Arrays.fill(row, true); }

    ArrayList<Point> path1 = getPath(maze1);
    if (path1 != null && path1.size() > 0) {
      for (Point point : path1) {
        System.out.println("point [" + point.getX() + ", " + point.getY() + "]");
      }
    }
    
    
    boolean[][] maze2 = new boolean[2500][2500];
    for (boolean[] row : maze2) { Arrays.fill(row, true); }

    ArrayList<Point> path2 = getPathWithMemo(maze2);
    if (path2 != null && path2.size() > 0) {
      for (Point point : path2) {
        System.out.println("point [" + point.getX() + ", " + point.getY() + "]");
      }
    }
  }
  
  public static ArrayList<Point> getPathWithMemo (boolean[][] maze) {
    if (maze == null || maze.length == 0) { return null; }
    ArrayList<Point> path = new ArrayList<Point>();
    HashSet<Point> failedPoints = new HashSet<Point>();
    if (getPathWithMemo(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
      return path;
    }
    return null;
  }
  
  public static boolean getPathWithMemo (boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
    if (col < 0 || row < 0 || !maze[row][col]) {
      return false;
    }
    Point p = new Point(row, col);
    if (failedPoints.contains(p)) {
      return false;
    }
    boolean isAtOrigin = (row == 0) && (col == 0);
    if (isAtOrigin ||
      getPathWithMemo(maze, row, col - 1, path, failedPoints) ||
      getPathWithMemo(maze, row - 1, col, path, failedPoints)) {
      path.add(p);
      return true;
    }
    failedPoints.add(p);
    return false;
  }
  
  public static ArrayList<Point> getPath (boolean[][] maze) {
    if (maze == null || maze.length == 0) { return null; }
    ArrayList<Point> path = new ArrayList<Point>();
    if (getPath(maze, maze.length - 1, maze[0].length -1, path)) {
      return path;
    }
    return null;
  }
  
  public static boolean getPath (boolean[][] maze, int row, int col, ArrayList<Point> path) {
    if (col < 0 || row < 0 || !maze[row][col]) {
      return false;
    }
    boolean isAtOrigin = (row == 0) && (col == 0);
    if (isAtOrigin ||
      getPath(maze, row, col -1, path) ||
      getPath(maze, row - 1, col, path)) {
      Point p = new Point(row, col);
      path.add(p);
      return true;
    }
    return false;
  }
}
