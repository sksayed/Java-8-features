package Streams;

import sun.font.CreatedFontTracker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSimulator {
    public static void main(String[] args) {

        //use of filtering
        List<Dishes> vegDishes = DishDataSource
                .getDishesList()
                .stream()
                .filter(Dishes::isVegetarians)
                .collect(Collectors.toList());
        //.forEach(System.out::println);
        vegDishes.stream().forEach(d -> System.out.println(d.getName()));

        //use of distinct
        //skip and limits are complementary to each other
        //
        IntStream.of(1, 2, 1, 5, 3, 2, 3, 5, 6, 4, 5, 7, 9, 8, 9, 7, 1, 6)
                .filter(i -> i % 2 == 0)
                .distinct()
                .skip(9)
                .limit(2)
                .forEach(System.out::println);

        DishDataSource.getDishesList()
                .stream()
                .map(dish -> {
                    //System.out.println(dish.getName().length());
                    return dish.getName().length();
                })
                .filter(length -> {
                    return length < 12;
                })
                .forEach(System.out::println);


    }


}
