package AppleSimulation;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    private String color ;

    public String getColor() {
        return color;
    }

    public Apple() {
    }

    public Apple setColor(String color) {
        this.color = color;
        return this ;
    }

    public int getWeight() {
        return weight;
    }

    public Apple setWeight(int weight) {
        this.weight = weight;
        return this ;
    }

    private int weight ;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public static boolean filterAppleBymoreThan150 (Apple apple) {
           return apple.getWeight() > 150 ;
    }

    public  boolean filterAppleByLessThan150(Apple apple) {
        return apple.getWeight() < 150 ;
    }


    public static List<Apple> filterApple (List<Apple> inventoryApple , Predicate<Apple> predicate ) {
        List<Apple> resultList = new ArrayList<>();
        for (Apple apple: inventoryApple){
            if(predicate.test(apple)){
                resultList.add(apple);
            }
        }
        return resultList ;
    }

    public  List<Apple> filterAppleNonStatic (List<Apple> inventoryApple , Predicate predicate ) {
        List<Apple> resultList = new ArrayList<>();
        for (Apple apple: inventoryApple){
            if(predicate.test(apple)){
                resultList.add(apple);
            }
        }
        return resultList ;
    }

    public static Apple getInstance () {
        return new Apple();
    }



}
