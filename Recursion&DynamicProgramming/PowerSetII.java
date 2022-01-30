import java.util.List;
import java.util.ArrayList;

public class PowerSetII {
  public static void main (String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(2455);
    list.add(3);
    // list.add(25);
    list.add(908);
    list.add(5);
    // list.add(786);
    // list.add(342);
    // list.add(77);
    // list.add(16);
    List<List<Integer>> subsets = getSubsets(list);
    for (List<Integer> subset : subsets) {
      System.out.print("{");
      for (Integer item : subset) {
        System.out.print(item +  " - ");
      }
      System.out.println("}");
    }
  }
  
  public static List<List<Integer>> getSubsets (List<Integer> set) {
    List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    int max = 1 << set.size(); // Compute 2^N
    for (int k = 0; k < max; k++) {
      List<Integer> subset = convertIntoSet(k, set);
      subsets.add(subset);
    }
    return subsets;
  }
  
  public static List<Integer> convertIntoSet(int x, List<Integer> set) {
    List<Integer> subset = new ArrayList<Integer>();
    int index = 0;
    for (int k = x; k > 0; k >>= 1) {
      if ((k & 1) == 1) {
        subset.add(set.get(index));
      }
      index++;
    }
    return subset;
  }
}
