package FutureInJava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestingShopApi {
    public static void main(String[] args) {
        Shop s = new Shop();
        long startOfSync = System.nanoTime();
        double price = s.getPriceSync("sayed");
        System.out.println("Price is "+price);
        long endTimeSync = System.nanoTime();
        System.out.println("time required is "+((endTimeSync-startOfSync)/1_000_000)+" milisecs");
        long startOfAync = System.nanoTime();
        Future<Double> getPriceAsync = s.getPriceAsync("leona");
        long invocationTime = ((System.nanoTime()- startOfAync)/1_000_000);
        System.out.println("Invocation returned after "+invocationTime+" milisecs");
        //doing something else
        try {
            price = getPriceAsync.get().doubleValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrivalTime  = ((System.nanoTime()- invocationTime)/1_000_000);
        System.out.println("Price returned after "+(retrivalTime/1000)+" secs");

    }
}
