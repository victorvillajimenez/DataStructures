public class Urlify {
  public static void main (String[] args) {
    Urlify instance = new Urlify();
    char[] str = "This is a tiny test        ".toCharArray();
    System.out.println("str before replace: " + new String(str));
    System.out.println("str before replace: " + java.util.Arrays.toString(str));
    instance.replaceSpaces(str, 19);
    System.out.println("str after replace: " + str);
    System.out.println("str after replace: " + new String(str));
    System.out.println("str after replace: " + java.util.Arrays.toString(str));
    java.util.Arrays.sort(str);
    System.out.println("str after replace: " + str);
    System.out.println("str after replace: " + new String(str));
    System.out.println("str after replace: " + java.util.Arrays.toString(str));    
  }

  void replaceSpaces (char[] str, int trueLength) {
    int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
    int newIndex = trueLength - 1 + numberOfSpaces * 2;
    
    if (newIndex + 1 < str.length) {
      str[newIndex + 1] = '\0';
    }
    for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
      if (str[oldIndex] == ' ') {
        str[newIndex] = '0';
        str[newIndex - 1] = '2';
        str[newIndex - 2] = '%';
        newIndex -= 3;
      } else {
        str[newIndex] = str[oldIndex];
        newIndex--;
      }
    } 
  }
  
  int countOfChar (char[] str, int start, int end, int target) {
    int count = 0;
    for (int i = start; i < end; i++) {
      if (str[i] == target) {
        count++;
      }
    }
    return count;
  }
}