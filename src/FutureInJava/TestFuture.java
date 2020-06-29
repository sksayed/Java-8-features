package FutureInJava;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestFuture {
    private static Runnable longRunningTask = () -> {
      try {
          String threadName = Thread.currentThread().getName();
          System.out.println("Hello from longRunningTask" + threadName +" ");
          TimeUnit.SECONDS.sleep(10l);
          System.out.println("My name is sayed");
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    };
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.print("Hello " + threadName +" ");
            System.out.println("executing from "+threadName);
        };

        task.run();

        Thread thread = new Thread(longRunningTask);

        thread.start();

        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello from executor service" + threadName);}
            );
        executor.shutdown();
        System.out.println("Done!");
    }


}
