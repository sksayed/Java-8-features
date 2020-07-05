package StreamsTest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TradesDataSource {
    private Trader[] traderArray = new Trader[]{
            new Trader("sayed", "chittagong"),
            new Trader("nayeem", "comilla"),
            new Trader("Zahid", "Dhaka"),
            new Trader("sozib", "sirajgonj"),
            new Trader("Sobuj", "Rajshahi"),
            new Trader("Rifad", "Narayangonj")
    };

    private Random random = new Random();

    private int[] yearArray = new int[]{1995, 1965, 1998, 2005, 1996, 1994};
    private int[] valueArray = new int[]{1953, 4458, 98745, 2541, 3652, 9654};

    public List<Transection> getTransectionsArray() {
        List<Transection> resultList = new ArrayList<>();
        resultList = (List<Transection>) IntStream.range(0, 10)
                .mapToObj(a ->
                {
                    int val = random.nextInt(6);
                    System.out.println(val);
                    return new Transection(traderArray[val], yearArray[val], valueArray[val]);
                }).collect(Collectors.toList());
        return resultList;
    }
}
