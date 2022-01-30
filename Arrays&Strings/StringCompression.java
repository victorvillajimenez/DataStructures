public class StringCompression {
  public static void main (String[] args) {
    StringCompression instance = new StringCompression();

    System.out.println(instance.customCompress("Hello World"));
    System.out.println(instance.customCompress("Gooooooooaaal"));

    System.out.println(instance.compressBad("Hello World"));
    System.out.println(instance.compressBad("Gooooooooaaal"));

    System.out.println(instance.compressGood("Hello World"));
    System.out.println(instance.compressGood("Gooooooooaaal"));

    System.out.println(instance.countBeforeCompress("Hello World"));
    System.out.println(instance.countBeforeCompress("Gooooooooaaal"));
  }

  String customCompress(String s) {
    int count = 0;
    String zip = "";
    Character previous = ' ';
    for (int i = 0; i < s.length(); i++) {
      if (previous != s.charAt(i)) {
        if (i != 0) {
          zip += previous + "" + count;
          count = 0;
        }
        previous = s.charAt(i);
      }
      count++;
      if (s.length() < zip.length() + (previous + "" + count).length()) {
        return s;
      }
    }
    return zip + previous + "" + count;
  }

  String compressBad (String s) {
    String compressedString = "";
    int countConsecutive = 0;
    for (int i = 0; i < s.length(); i++) {
      countConsecutive++;

      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        compressedString += "" + s.charAt(i) + countConsecutive;
        countConsecutive = 0;
      }
    }
    return compressedString.length() < s.length() ? compressedString : s;
  }

  String compressGood (String s) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < s.length(); i++) {
      countConsecutive++;

      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        compressed.append(s.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.length() < s.length() ? compressed.toString() : s;
  }

  String countBeforeCompress (String s) {
    int finalLength = countCompression(s);
    if (finalLength >= s.length()) return s;

    StringBuilder compressed = new StringBuilder(finalLength);
    int countConsecutive = 0;
    for (int i = 0; i < s.length(); i++) {
      countConsecutive++;

      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        compressed.append(s.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.toString();
  }

  int countCompression (String s) {
    int compressedLength = 0;
    int countConsecutive = 0;
    for (int i = 0; i < s.length(); i++) {
      countConsecutive++;

      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        compressedLength += 1 + String.valueOf(countConsecutive).length();
        countConsecutive = 0;
      }
    }
    return compressedLength;
  }
}
