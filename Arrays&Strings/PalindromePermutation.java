public class PalindromePermutation {

  public static void main (String[] args) {
    PalindromePermutation instance = new PalindromePermutation();
    boolean decision1 = instance.isPermutationOfPalindromeV1("Tactz coaZ");
    System.out.println("decision1 : " + decision1);
    boolean decision2 = instance.isPermutationOfPalindromeV2("Tactz coaZ");
    System.out.println("decision2 : " + decision2);
    boolean decision3 = instance.isPermutationOfPalindromeV3("Tactz lcoaZ");
    System.out.println("decision3 : " + decision3);
  }

  boolean isPermutationOfPalindromeV1 (String phrase) {
    int[] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
  }

  int[] buildCharFrequencyTable (String phrase) {
    int size = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;
    int[] table = new int[size];

    for (char c : phrase.toCharArray()) {
      int x = getCharNumber(c);
      if (x != -1) {
        table[x]++;
      }
    }
    return table;
  }

  int getCharNumber (Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  boolean checkMaxOneOdd (int[] table) {
    boolean foundOdd = false;
    for (int count : table) {
      if (count % 2 == 1) {
        if (foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  boolean isPermutationOfPalindromeV2 (String phrase) {
    int countOdd = 0;
    int size = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;
    int[] table = new int[size];

    for (char c : phrase.toCharArray()) {
      int x = getCharNumber(c);
      if (x != -1) {
        table[x]++;
        if (table[x] % 2 == 1) {
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }
    return countOdd <= 1;
  }
  
  boolean isPermutationOfPalindromeV3 (String phrase) {
    int bitVector = createBitVector(phrase);
    return checkAtMostOneBitSet(bitVector);
  }

  int createBitVector (String s) {
    int bitVector = 0;
    for (char c : s.toCharArray()) {
      int x = getCharNumber(c);
      System.out.println(c + " : " + x);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  int toggle (int bitVector, int i) {
    if (i < 0) { return bitVector; }

    int mask = 1 << i;
    System.out.println("1 << i : " + (1 << i));
    bitVector ^= mask;
    System.out.println("bitVector ^= mask : " + bitVector + " : " + Integer.toBinaryString(bitVector));
    return bitVector;
  }

  boolean checkAtMostOneBitSet (int bitVector) {
    System.out.println("bitVector => " + bitVector + " : bitVector - 1 => " + (bitVector - 1) + " : bitVector & (bitVector - 1) => " + (bitVector & (bitVector - 1)));
    System.out.println("bitVector => " + Integer.toBinaryString(bitVector) + " : bitVector - 1 => " + Integer.toBinaryString(bitVector - 1) + " : bitVector & (bitVector - 1) => " + Integer.toBinaryString(bitVector & (bitVector - 1)));
    return (bitVector & (bitVector - 1)) == 0;
  }
}
