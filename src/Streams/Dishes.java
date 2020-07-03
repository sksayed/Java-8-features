package Streams;

public class Dishes {
    /*
    we will make this class
    * an immutable class
    * */

    private final String name ;
    private final boolean vegetarians ;
    private final int  calories ;
    private final Type type ;

    public Dishes(String name, boolean vegetarians, int calories, Type type) {
        this.name = name;
        this.vegetarians = vegetarians;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarians() {
        return vegetarians;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT,
        FISH,
        OTHERS
    }

}
