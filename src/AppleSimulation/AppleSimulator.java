package AppleSimulation;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class AppleSimulator {



    public static void main(String[] args) {
        z a = new z();
        a.doSomeThing();
    }

}

class z  {
    public void doSomeThing() {
        List<Apple> less150Apple =
                Apple.filterApple(AppleDataSource.getAppleList() ,Apple.moreThan150Lessthan600 );
        for (Apple a:less150Apple
             ) {
            System.out.println(a.getColor()+" and weight is " + a.getWeight());
        }
    }

    public void sortAList () {
        List<Apple> appleList = Apple.filterApple(AppleDataSource.getAppleList() , Apple::filterAppleBymoreThan150);
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return 0;
            }
        });

    }


}
