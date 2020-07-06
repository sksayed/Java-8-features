package StreamsTest;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Comparator;

public class MainClass {
    private TradesDataSource dataSource = new TradesDataSource();
    private static MainClass mainClass = new MainClass();

    public static void main(String[] args) {

        //allValues();

        // ansOne();
        // ansTwo();
        ansThree();
        //ansFour();
        //ansFive();
        //ansSix();
        // ansSeven();
        // ansEight();

    }

    private static void allValues() {
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .forEach(transection -> System.out.println(transection.toString()));
    }

    /* 1 Find all transactions in the year 1994 and sort them by value (smalltohigh).*/
    private static void ansOne() {
        //SQL => SELECT * FROM Transection Where year = 1994 Order by value
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .filter(transection -> {
                    return transection.getYear() == 1994;
                }).sorted((t1, t2) -> {
            return t1.getValue() > t2.getValue() ? 1 : -1;
        }).forEach(transection -> System.out.println(transection));

        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .filter(transection -> transection.getYear() == 1994)
                .sorted(Comparator.comparing(Transection::getValue))
                .forEach(transection -> System.out.println(transection));
    }

    /*2.What are all the unique cities where the traders work ?*/
    private static void ansTwo() {
        /*SQL=> SELECT distinct(Trader.city) from Transection*/
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .map(transection -> transection.getTrader().getCity())
                .distinct()
                .forEach(city -> System.out.println(city));

    }

    //3.Find all traders from Rajshahi and sort them by name.
    private static void ansThree() {
        //SQL => SELECT Trader FROM Transection WHERE Trader.city == "Rajshahi" ORDER BY Trader.name ASC;
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                //where clause
                .filter(transection -> transection.getTrader().getCity() == "Rajshahi")
                .distinct()
                //order by clause
                .sorted((t1, t2) -> {
                    return t1.getTrader().getName().compareToIgnoreCase(t2.getTrader().getName());
                })
                //Select clause
                .map(transection -> {
                    return transection.getTrader();
                }).forEach(System.out::println);


    }

    /*4. Return a string of all trader's names sorted alphabetically*/
    private static void ansFour() {
        //SQL=>SELECT Trader.name from Trasection ORDER BY Trader.name ASC
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                //select clause
                .map(t -> t.getTrader().getName())
                .sorted((t1, t2) -> t1.compareToIgnoreCase(t2))
                .forEach(System.out::println);
    }

    /*5 Are any traders based in comilla?*/
    private static void ansFive() {
        //SQL=> SELECT Trader from Transection where Trader.city == "comilla"
        mainClass.dataSource
                .getTransectionsArray().stream()
                .filter(t -> t.getTrader().getCity() == "comilla")
                .findAny()
                .ifPresent(t -> {
                    System.out.println(t);
                });
    }

    /*6. Print all transaction's values from the traders living in Rajshahi*/
    private static void ansSix() {
        //SQL=> Select * from Transection where Transection in (Select * from
        // transection where trasection.city == "Rajshahi");
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .filter(t -> t.getTrader().getCity() == "Rajshahi")
                .forEach(System.out::println);
    }

    /*7.What’s the highest value of all the transactions ?*/
    private static void ansSeven() {
        //sql => SELECT MAX(VALUE) from Transection ;
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .max((t1, t2) -> t1.getValue() > t2.getValue() ? t1.getValue() : t2.getValue())
                .ifPresent(System.out::println);
    }

    /*8.Find the transaction with the smallest value.*/
    private static void ansEight() {
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .min((t1, t2) -> t1.getValue() < t2.getValue() ? t1.getValue() : t2.getValue())
                .ifPresent(System.out::println);
    }

}
