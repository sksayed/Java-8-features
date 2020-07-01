package AppleSimulation;

import java.util.List;

public class AppleSimulator {



    public static void main(String[] args) {
        z a = new z();
        a.doSomeThing();
    }

}

class z  {
    public void doSomeThing() {
        List<Apple> less150Apple =
                Apple.filterApple(AppleDataSource.getAppleList() , Apple::filterAppleBymoreThan150);
        for (Apple a:less150Apple
             ) {
            System.out.println(a.getColor()+" and weight is " + a.getWeight());
        }
    }
}
