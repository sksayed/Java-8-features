package FutureInJava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestingShopApi {

    private static List<Shop> shopList = Arrays.asList(new Shop("sayed"),
            new Shop("leona"),
            new Shop("Ammu"),
            new Shop("Abbu"),
            new Shop("Kafi"));

    public static void main(String[] args) {
        //doingSyncAndAsyncCalling();
        // askingPriceSync();
        askingPricesAsyncAndParallel();
    }

    private static void askingPricesAsyncAndParallel() {
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    private static void askingPriceSync() {
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    private static void doingSyncAndAsyncCalling() {
        Shop s = new Shop("sayed");
        long startOfSync = System.nanoTime();
        double price = s.getPriceSync("asda asda ");
        System.out.println("Price is " + price);
        long endTimeSync = System.nanoTime();
        System.out.println("time required is " + ((endTimeSync - startOfSync) / 1_000_000) + " milisecs");
        long startOfAync = System.nanoTime();
        Future<Double> getPriceAsync = s.getPriceAsync("bjkiabkb oh");
        long invocationTime = ((System.nanoTime() - startOfAync) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " milisecs");
        //doing something else
        try {
            price = getPriceAsync.get().doubleValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrivalTime = ((System.nanoTime() - (startOfAync)) / 1_000_000);
        System.out.println("Price returned after " + (retrivalTime) + " mil secs");
    }

    private static List<String> findPrices(String product) {
        return shopList.parallelStream()
                .map(shop -> String.format("%s shopName price is %.2f ",
                        shop.getShopName(), shop.getPriceSync(product)))
                .collect(Collectors.toList());
    }

   /* private static List<CompletableFuture<String>> findPricesAsyncParallel(String product) {
        return shopList.parallelStream()
                .map(shop -> CompletableFuture.supplyAsync(new Supplier<String>() {
                     return String.format("%s shopName price is %.2f ",
                             shop.getShopName(), shop.getPriceAsync(product)
                } ))
                .collect(Collectors.toList());
    }*/

    private static List<String> findPrices2(String Product) {
        List<CompletableFuture<String>> getPricesAsCompletable =
                shopList.stream()
                        .map(shop -> {
                            return CompletableFuture.supplyAsync(() -> {
                                return shop.getShopName() + " this shop price is " + shop.getPriceSync(Product);
                            });
                        }).collect(Collectors.toList());

        return getPricesAsCompletable.stream()
                .map(CompletableFuture::join).
                        collect(Collectors.toList());
    }
}
