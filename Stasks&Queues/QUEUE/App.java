public class App {
  public static void main (String[] args) {
    Queue queue = new Queue(5);
    
    queue.insert(1); // *
    queue.insert(3); // *
    queue.insert(5); // +  *
    queue.insert(7); //    *
    queue.insert(9);
    
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    
    queue.insert(33);
    queue.insert(44);
    queue.insert(55); // + *
    
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    
    queue.insert(66);
    queue.insert(77);
    
    queue.view();
  }
}
