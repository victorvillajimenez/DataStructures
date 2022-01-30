public class HeapSort {
  private int[] a;
  private int size;
  private int max;
  
  public HeapSort (int max) {
    this.size = 0;
    this.max = max;
    this.a = new int[max];
  }
  
  public boolean isEmpty () {
    return size == 0;
  }
  
  public boolean isFull () {
    return size == max;
  }
  
  public boolean insert (int data) {
    if (isFull()) return false;
    a[size] = data;
    trickleUp(size);
    size++;
    return true;
  }
  
  private void trickleUp (int i) {
    int parentIndex = (i - 1) / 2;
    int nodeToInsert = a[i];
    while (i > 0 && a[parentIndex] < nodeToInsert) {
      a[i] = a[parentIndex];
      i = parentIndex;
      parentIndex = (i - 1) / 2;
    }
    a[i] = nodeToInsert;
  }
  
  public int extractMax () {
    if (isEmpty()) return -1;
    int root = a[0];
    size--;
    a[0] = a[size];
    trickleDown(0);
    return root;
  }
  
  private void trickleDown (int i) {
    int larger;
    int top = a[i];
    while (i < size / 2) {
      int l = (i * 2) + 1;
      int r = (i * 2) + 2;
      if (r < size && a[l] < a[r]) {
        larger = r;
      } else {
        larger = l;
      }
      if (top >= a[larger]) {
        break;
      }
      a[i] = a[larger];
      i = larger;
    }
    a[i] = top;
  }
  
  public static void main(String[] args) {
    int[] x = new int[] {32423,123,5521,453,7,436,86,9,24,67,1223};
    HeapSort heap = new HeapSort(x.length);
    for (int i = 0; i < x.length; i++) {
      heap.insert(x[i]);
    }
    int start = x.length - 1;
    for (int i = start; i >= 0; i--) {
      x[i] = heap.extractMax();
    }
    System.out.println("Check order:");
    for (int i = 0; i < x.length; i++) {
      System.out.println(x[i]);
    }
  }
}