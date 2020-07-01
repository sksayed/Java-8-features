package AppleSimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppleDataSource {
    private static List<Apple> appleList;

    static {
        appleList = new ArrayList<>();
        int value = 10;
        appleList = IntStream.rangeClosed(1, 100)
                .mapToObj(intValue -> {
                    return new Apple().setColor("sayed" + intValue)
                            .setWeight(intValue * 10);
                }).collect(Collectors.toList());

    }

    public static List<Apple> getAppleList () {
        return appleList ;
    }

    enum AppleName {
        BigApple,
        SmallApple,
        LeonasApple,
        RezasApple;
    }


}
