import java.util.List;
import java.util.ArrayList;

public class PowerSet {
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
    List<List<Integer>> subsets = getSubsets(list, 0);
    for (List<Integer> subset : subsets) {
      System.out.print("{");
      for (Integer item : subset) {
        System.out.print(item +  " - ");
      }
      System.out.println("}");
    }
  }
  
  public static List<List<Integer>> getSubsets (List<Integer> set, int index) {
    List<List<Integer>> subsets;
    if (set.size() == index) { // Base case
      subsets = new ArrayList<List<Integer>>();
      subsets.add(new ArrayList<Integer>()); // Empty set
    } else {
      subsets = getSubsets(set, index + 1);
      int item = set.get(index);
      List<List<Integer>> more = new ArrayList<List<Integer>>();
      for (List<Integer> subset : subsets) {
        List<Integer> newSubset = new ArrayList<Integer>();
        newSubset.addAll(subset);
        newSubset.add(item);
        more.add(newSubset);
      }
      subsets.addAll(more);
    }
    return subsets;
  }
}