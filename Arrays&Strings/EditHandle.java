public class EditHandle {
  public static void main (String[] args) {
    EditHandle instance = new EditHandle();

    System.out.println("Version 1");
    System.out.println("pale, ple => " + instance.oneEditAway("pale", "ple"));
    System.out.println("pales, pale => " + instance.oneEditAway("pales", "pale"));
    System.out.println("pale, bale => " + instance.oneEditAway("pale", "bale"));
    System.out.println("pale, bae => " + instance.oneEditAway("pale", "bae"));

    System.out.println("Version 2");
    System.out.println("pale, ple => " + instance.oneEditAwayV2("pale", "ple"));
    System.out.println("pales, pale => " + instance.oneEditAwayV2("pales", "pale"));
    System.out.println("pale, bale => " + instance.oneEditAwayV2("pale", "bale"));
    System.out.println("pale, bae => " + instance.oneEditAwayV2("pale", "bae"));
  }

  boolean oneEditAway (String first, String second) {
    if (first.length() == second.length()) {
      return oneEditReplace(first, second);
    } else if (first.length() + 1 == second.length()) {
      return oneEditInsert(first, second);
    } else if (first.length() - 1 == second.length()) {
      return oneEditInsert(second, first);
    }
    return false;
  }

  boolean oneEditReplace (String a, String b) {
    boolean foundDifference = false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        if (foundDifference) {
          return false;
        }
        foundDifference = true;
      }
    }
    return true;
  }

  // a is shorter than b by 1.
  // a.length() + 1 == b.length()
  boolean oneEditInsert (String a, String b) {
    int i = 0;
    int j = 0;
    while (j < b.length() && i < a.length()) {
      if (a.charAt(i) != b.charAt(j)) {
        if (i != j) {
          return false;
        }
        j++;
      } else {
        i++;
        j++;
      }
    }
    return true;
  }

  boolean oneEditAwayV2 (String first, String second) {
    if (java.lang.Math.abs(first.length() - second.length()) > 1) {
      return false;
    }

    String a = first.length() < second.length() ? first : second;
    String b = first.length() < second.length() ? second : first;

    int i = 0;
    int j = 0;
    boolean foundDifference = false;
    while (j < b.length() && i < a.length()) {
      if (a.charAt(i) != b.charAt(j)) {

        if (foundDifference) {
          return false;
        }
        foundDifference = true;

        if (a.length() == b.length()) {
          i++;
        }

      } else {
        i++;
      }
      j++;
    }
    return true;
  }
}
