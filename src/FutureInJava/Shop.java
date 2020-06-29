package FutureInJava;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public double getPriceSync() {
        return calculatePrice(this.shopName);
    }

    public Future<Double> getPriceAsync() {
        return calculatePriceAsync(this.shopName);
        //return 0.0;
    }

    private Future<Double> calculatePriceAsync(String shopName) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(shopName);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }

        }).start();

        return futurePrice;
    }

    private void delay() {
        try {
            //here we are making the thread sleeping for
            //five seconds
            String threadName = Thread.currentThread().getName();
            System.out.println("executing on " + threadName);
            Thread.sleep(1 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice(String name) {
        Random random = new Random();
        delay();
        return random.nextDouble() * name.charAt(0) + name.charAt(1);
    }

}
