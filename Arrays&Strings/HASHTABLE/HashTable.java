public class HashTable {
  String[] array;
  int arraySize;
  int size = 0;

  public HashTable(int noOfSlots) {
    if (isPrime(noOfSlots)) {
      array = new String[noOfSlots];
      arraySize = noOfSlots;
    } else {
      int noPrime = getNextPrime(noOfSlots);
      array = new String[noPrime];
      arraySize = noPrime;
      System.out.println("Hash table size given " + noOfSlots + " is not a prime");
      System.out.println("Hash table size changed to " + noPrime);
    }
  }

  private boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
  
  private int getNextPrime(int minNum) {
    for (int i = minNum; true; i++) {
      if (isPrime(i)) {
        return i;
      }
    }
  }

  private int hashFunc1(String word) {
    int hashVal = word.hashCode();
    hashVal %= arraySize;
    if (hashVal < 0) {
      hashVal += arraySize;
    }
    return hashVal;
  }
  
  private int hashFunc2(String word) {
    int hashVal = hashFunc1(word);
    return 3 - hashVal % 3;
  }

  public void insert(String word) {
    int hashVal = hashFunc1(word);
    int stepSize = hashFunc2(word);
    while (array[hashVal] != null) {
      hashVal += stepSize;
      hashVal %= arraySize;
    }
    array[hashVal] = word;
    System.out.println("Inserted word: " + word);
    size++;
  }
  
  public String find(String word) {
    int hashVal = hashFunc1(word);
    int stepSize = hashFunc2(word);
    while (array[hashVal] != null) {
      if (array[hashVal].equals(word)) {
        return array[hashVal];
      }
      hashVal += stepSize;
      hashVal %= arraySize;
    }
    return null;
  }
  
  public void display() {
    System.out.println("+++++ HashTable: Start +++++");
    for (int i = 0; i < arraySize; i++) {
      if (array[i] != null) {
        System.out.println(array[i]);
      } else {
        System.out.println("** ");
      }
    }
    System.out.println("+++++ HashTable: End +++++");
  }
}
