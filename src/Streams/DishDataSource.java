package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishDataSource {
    public static List<Dishes> getDishesList () {
        List<Dishes> dishes = Arrays.asList(
                new Dishes("Dal bhorta" , true , 164 , Dishes.Type.OTHERS),
                new Dishes("Murgir mangso" , false , 658 , Dishes.Type.MEAT),
                new Dishes("Macher Matha ghnto" , true , 558 , Dishes.Type.FISH),
                new Dishes("Alu Bhorta" , true , 120 , Dishes.Type.OTHERS),
                new Dishes("alu bhaji " , true , 165 , Dishes.Type.OTHERS),
                new Dishes("Gorur Kala bhuna " , false , 458 , Dishes.Type.MEAT),
                new Dishes("Khasir rezala  " , false , 781 , Dishes.Type.MEAT),
                new Dishes("Chingrir do piyaja" , false , 487 , Dishes.Type.FISH),
                new Dishes("Rui machh er kopta" , false , 354 , Dishes.Type.FISH)
        );
        return dishes ;
    }
}
