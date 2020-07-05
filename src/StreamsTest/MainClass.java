package StreamsTest;

public class MainClass {
    private TradesDataSource dataSource = new TradesDataSource();

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.dataSource
                .getTransectionsArray()
                .stream()
                .forEach(transection -> System.out.println(transection.toString()));
    }


}
