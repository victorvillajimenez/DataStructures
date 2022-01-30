public class App {
  public static void main(String[] args) {
    Heap heap = new Heap(100);

    heap.insert(2);
    heap.insert(63);
    heap.insert(1);
    heap.insert(78);
    heap.insert(824); // 0
    heap.insert(34);
    heap.insert(7);
    heap.insert(4);
    heap.insert(13);
    heap.insert(84);
    heap.insert(43);
    heap.insert(5);
    heap.insert(678);
    heap.insert(836);
    heap.insert(111);
    heap.insert(510);
    heap.insert(11);
    heap.insert(50);
    heap.insert(57);
    heap.insert(411);
    heap.insert(0);
    heap.insert(79);
    heap.insert(182);
    heap.insert(191);
    heap.insert(550);
    heap.insert(78);
    heap.insert(17);
    heap.insert(33);
    heap.insert(333);
    heap.insert(801);
    heap.insert(911);
    heap.insert(14);
    heap.insert(248);
    heap.insert(6);
    heap.insert(81);
    heap.insert(199);
    heap.insert(47);
    heap.insert(21);
    heap.insert(96);

    System.out.println("SIZE: " + heap.getSize());
    heap.display();
    
    heap = new Heap(100);

    heap.insert(34);
    heap.insert(7);
    heap.insert(4);
    heap.insert(13);
    heap.insert(84);
    heap.insert(43);
    heap.insert(5);
    heap.insert(78);
    heap.insert(17);
    heap.insert(33);
    heap.insert(2);
    heap.insert(63);
    heap.insert(1);
    heap.insert(78);
    heap.insert(6);
    heap.insert(81);
    heap.insert(47);
    heap.insert(21);
    heap.insert(96);
    heap.insert(0);
    heap.insert(3);
    heap.insert(9);
    heap.insert(15);
    heap.insert(8);
    heap.insert(99);
    heap.insert(91);

    System.out.println("SIZE: " + heap.getSize());
    heap.display();
  }
}