public class ThreadExample extends Thread {
  int count = 0;
  
  public void run () {
    System.out.println("Thread starting.");
    try {
      while (count < 5) {
        System.out.println("run (before sleep) count: " + count);
        Thread.sleep(800);
        count++;
        System.out.println("run (after sleep)");
      }
    } catch (InterruptedException e) {
      System.out.println("Thread interrupted.");
    }
    System.out.println("Thread terminating.");
  }
  
  public static void main (String[] args) {
    ThreadExample instance = new ThreadExample();
    instance.start();
    
    while (instance.count != 5) {
      try {
        System.out.println("instance.count (before sleep):" + instance.count);
        Thread.sleep(250);
        System.out.println("instance.count (after sleep)");
      } catch (InterruptedException e) {
        System.out.println("Thread interrupted...");
        e.printStackTrace();

      }
    }
  }
}