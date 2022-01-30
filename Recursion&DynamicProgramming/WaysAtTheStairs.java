public class WaysAtTheStairs {
  public static void main (String[] args) {
    int totalSteps = 32 ;
    int[] hops = {1,2,3}; // {1,2,3};
    long[] memo = new long[totalSteps + 1];
    java.util.Arrays.fill(memo, -1);

    long start = System.currentTimeMillis();
    long result1 = countSteps(totalSteps, hops);
    long end = System.currentTimeMillis();
    System.out.println("result1: " + result1 + ". Time: " + (end - start));

    start = System.currentTimeMillis();
    long result2 = countStepsWithMemo(totalSteps, hops, memo);
    end = System.currentTimeMillis();
    System.out.println("result2: " + result2 + ". Time: " + (end - start));
 
    start = System.currentTimeMillis();
    long result3 = numWaysBottomUp(totalSteps, hops);
    end = System.currentTimeMillis();
    System.out.println("result3: " + result3 + ". Time: " + (end - start));
    
    start = System.currentTimeMillis();
    long result4 = numWaysBottomUp2(totalSteps, hops);
    end = System.currentTimeMillis();
    System.out.println("result4: " + result4 + ". Time: " + (end - start));
  }
  
  public static long countSteps(int steps, int[] hops) {
    if (steps == 0) return 1;
    if (steps < 0) return 0;
    long val = 0;
    for (int hop : hops) {
      val += countSteps(steps - hop, hops);
    }
    return val;
  }
  
  public static long countStepsWithMemo(int steps, int[] hops, long[] memo) {
    if (steps == 0) return 1;
    if (steps < 0) return 0;
    if (memo[steps] > -1) return memo[steps];
    long val = 0;
    for (int hop : hops) {
      val += countStepsWithMemo(steps - hop, hops, memo);
    }
    memo[steps] = val;
    return memo[steps];
  }
  
  public static long numWaysBottomUp (int steps, int[] hops) {
    if (steps == 0) return 1;
    long[] memo = new long[steps + 1];
    memo[0] = 1;
    for (int i = 1; i <= steps; i++) {
      for (int hop : hops) {
        if (i >= hop) {
          memo[i] += memo[i - hop];
        }
      }
    }
    return memo[steps];
  }
  
  public static long numWaysBottomUp2 (int steps, int[] hops) {
    if (steps == 0) return 1;
    long[] lastVal = new long[hops.length + 1];
    // java.util.Arrays.fill(lastVal, 1);
    lastVal[0] = 1;
    lastVal[1] = 1;
    lastVal[2] = 1;
    lastVal[3] = 0;
    for (int i = 1; i <= steps; i++) {
      long values = 0;
      for (int j = 0; j < hops.length; j++) {
        if (i >= hops[j]) {
          // long temp = lastVal[hops.length];
          values += lastVal[j];
          // lastVal[j] += lastVal[hops.length];
        }
      }
      if (values > 0) {
        lastVal[0] = lastVal[1];
        lastVal[1] = lastVal[2];
        lastVal[2] = lastVal[hops.length];
        lastVal[hops.length] += values;
      }
    }
    return lastVal[hops.length];
  }
}
