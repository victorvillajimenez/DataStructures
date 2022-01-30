/*
  They are a Complete Binary Tree
*/
public class Heap { // Max Heap
  private Node[] array;
  private int maxSize;
  private int currentSize;
  
  public Heap(int size) {
    this.maxSize = size;
    currentSize = 0;
    array = new Node[size];
  }
  
  public int getSize() {
    return currentSize;
  }
  
  public boolean isEmpty() {
    return currentSize == 0;
  }
  
  public boolean insert(int value) {
    if (currentSize == maxSize) { // array is full
      return false;
    }
    Node node = new Node(value);
    array[currentSize] = node;
    
    trickleUp(currentSize);
    currentSize++;
    
    return true;
  }
  
  private void trickleUp(int index) {
    int parentIndex = (index - 1) / 2;
    Node nodeToInsert = array[index];
    // loop as long as we haven't reached the root and key of nodeToInsert's parent is less than new node.
    while (index > 0 && array[parentIndex].getKey() < nodeToInsert.getKey()) {
      array[index] = array[parentIndex]; // Move parent down
      index = parentIndex;
      parentIndex = (index - 1) / 2; // Move up
    }
    array[index] = nodeToInsert;
  }
  
  public Node remove() {
    if (isEmpty()) { // array is empty
      return null;
    }
    Node root = array[0];
    currentSize--;
    array[0] = array[currentSize];
    
    trickleDown(0);
    
    return root;
  }
  
  private void trickleDown(int index) {
    int larger;
    Node top = array[index];
    while (index < currentSize / 2) {
      int left  = (index * 2) + 1;
      int right = (index * 2) + 2;
      if (right < currentSize && array[left].getKey() < array[right].getKey()) {
        larger = right;
      } else {
        larger = left;
      }
      if (top.getKey() >= array[larger].getKey()) {
        break;
      }
      array[index] = array[larger];
      index = larger;
    }
    array[index] = top;
  }
  
  public void display() {
    if (isEmpty()) {
      System.out.println("Heap is empty\n");
      return;
    }
    int levels;
    int binaryInc;
    for (levels = 0, binaryInc = 1; currentSize >= binaryInc; levels++, binaryInc *= 2);
    int nChars = String.valueOf(array[0].getKey()).length();
    --levels;
    int binaryDec = binaryInc / 2;
    binaryInc = 1;
    for (int index = 0, level = 0; level <= levels; level++, binaryDec /= 2, binaryInc *= 2) {
      int binarySize = binaryInc + index;
      for (int nSpacesR = binaryDec * nChars, nSpacesL = nSpacesR - nChars; index < binarySize && index < currentSize; index++) {
        if (nSpacesL == 0) {
          System.out.print(String.format("%" + nChars + "d%" + nSpacesR + "s", array[index].getKey(), ""));
        } else {
          System.out.print(String.format("%" + nSpacesL + "s%" + nChars + "d%" + nSpacesR + "s", "", array[index].getKey(), ""));
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
        // import java.util.Arrays;
        // char[] arraySpaces = new char[nSpacesL];
        // Arrays.fill(arraySpaces, ' ');
        // String spaces = new String(arraySpaces);
        // System.out.print(spaces);
