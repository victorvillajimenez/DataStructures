public class RunnableExample implements Runnable {
  public int count = 0;
  
  public void run () {
    System.out.println("RunnableThread starting.");
    try {
      while (count < 5) {
        System.out.println("run (before sleep) count: " + count);
        Thread.sleep(800);
        count++;
        System.out.println("run (after sleep)");
      }
    } catch (InterruptedException e) {
      System.out.println("RunnableThread interrupted.");
    }
    System.out.println("RunnableThread terminating.");
  }
  
  public static void main (String[] args) {
    RunnableExample instance = new RunnableExample();
    Thread thread = new Thread(instance);
    thread.start();
    
    while (instance.count != 5) {
      try {
        // if(instance.count == 2) {
        //   instance.count = 5;
        // }
        System.out.println("instance.count (before sleep):" + instance.count);
        Thread.sleep(250);
        System.out.println("instance.count (after sleep) ");
      } catch (InterruptedException e) {
        System.out.println("RunnableThread interrupted...");
        e.printStackTrace();
      }
    }
  }
}