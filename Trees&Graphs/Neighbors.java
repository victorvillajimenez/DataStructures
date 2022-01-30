/*
Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.

Q1: Tell me a story of success (preferably team work): a project that went well at work.
How many people were on it?
Describe your role in delivering it.
What have you done to develop leadership skills, and how to develop them further?
How could Google (or your ideal manager) help you with these?
Q2: Have you helped a new teammate get up to speed, and become productive? How?
Imagine that a teammate is struggling with a task over a month; how do you help them?
How do you keep them motivated?
How do you help them if, hypothetically, you don't understand how to do the task yourself?
Q3: Tell me a story where you've shared an idea to your team, and met resistance.
What caused such resistance?
What did you try doing to overcome it?
What was the result, and
Could you have done something different?
Q4: Tell me about a time that you set a difficult goal for yourself that you did not achieve. What was the situation? Backend: Seam Framework (EJB3, JFP, ORM(hibernate,), core(spring) 
Frontend: Rich compoents: AS3, Flex3, Stream connection)
What was the rationale for setting this goal?
What did you learn from this experience?
If you were to attempt to achieve the same goal again, what could you do differently?
*/

/*
TechLead - https://www.youtube.com/watch?v=IWvbPIYQPFM&t=309s
WilliamFiset - https://www.youtube.com/watch?v=KiCBXu4P-2Y 

[
  [1,1,2,3],
  [1,2,3,2],
  [3,2,2,2],
  [3,2,2,2]
]
*/
import java.util.*;

class Neighbors {
  public int maxNeighbors (int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];

    // int moveCount = 0;
    // int nodesLeftInLayer = 1;
    // int nodesInNextLayer = 0;
    
    LinkedList<Integer> qr = new LinkedList<>();
    LinkedList<Integer> qc = new LinkedList<>();
    
    // North, South, East, West
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    
    int max = 0;
    
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++ ) {
        if (!visited[i][j]) {
          int currentValue = grid[i][j];
          qr.add(i);
          qc.add(j);
          visited[i][j] = true;
          int count = 1;
          while (!qr.isEmpty()) {
            int r = (Integer)qr.removeFirst();
            int c = (Integer)qc.removeFirst();
            // exploreNeighbors(r, c);
            for (int k = 0; k < 4; k++) {
              int rr = r + dr[k];
              int cc = c + dc[k];
              if (rr < 0 || cc < 0) continue;
              if (rr >= rows || cc >= cols) continue;
              if (visited[rr][cc]) continue;
              if (grid[rr][cc] != currentValue) continue;
              qr.add(rr);
              qc.add(cc);
              visited[rr][cc] = true;
              count++;
              // nodesInNextLayer++;
            }
            // nodesLeftInLayer--;
            // if (nodesLeftInLayer == 0) {
            //   nodesLeftInLayer = nodesInNextLayer;
            //   nodesInNextLayer = 0;
            //   moveCount++;
            // }
          }
          max = Math.max(max, count);     
        }
      }
    }
    return max;
  }
  
  public static void main (String[] args) {
    Neighbors c = new Neighbors();
    System.out.println(c.maxNeighbors(new int[][] {
      {1,1,1,3},
      {1,2,3,2},
      {1,2,3,2},
      {1,3,2,2}
    }));
  }
}
