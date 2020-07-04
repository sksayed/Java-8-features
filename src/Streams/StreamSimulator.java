package Streams;

import sun.font.CreatedFontTracker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class StreamSimulator {
    public static void main(String[] args) {

        //use of filtering
        List<Dishes> vegDishes = DishDataSource
                .getDishesList()
                .stream()
                .filter(Dishes::isVegetarians)
                .collect(toList());
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

       /* 1.Given a list of numbers,
        how would you return a list of the square of each number ?
                For example , given [1,2,3,4,5] you should return [1,4,9,16,25] .*/
        List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> answereLisr = givenList.stream()
                .map(eachItem -> eachItem * eachItem)
                .collect(toList());
        System.out.println(answereLisr);

       /* 2) Given two lists of numbers ,how would you return all pairsofnumbers ?
        For example ,given alist[1,2,3] and alist[3,4] you should return[(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)].For
        simplicity , you can represent a pair as an array with two elements.*/

        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(5, 4);

        List<int[]> pair = firstList.stream()
                .flatMap( i -> secondList.stream().map( j -> new int[]{i,j}))
                .collect(Collectors.toList());

        pair.stream().forEach(intArray ->{
            System.out.println(intArray[0]+" "+intArray[1]);
        });


    }


}
