package FutureInJava;

import java.util.Random;

public class Shop {

    public double getPrice (String shopName) {
        return calculatePrice(shopName) ;
    }

    private void delay () {
        try {
            //here we are making the thread sleeping for
            //five seconds
            String threadName = Thread.currentThread().getName();
            System.out.println("executing on "+threadName);
            Thread.sleep(5*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice (String name){
        Random random = new Random();
        delay();
        return random.nextDouble()*name.charAt(0)+name.charAt(1);
    }

}
