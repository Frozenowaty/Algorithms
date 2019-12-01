package listimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        int numbersCount = 10;
        for (int i = 0; i < numbersCount;i++)
            list.add(rand.nextInt(100));
        ListUtilities.display(list);
        ListUtilities.mergeSort(list);
        ListUtilities.display(list);
//        list.add(11,2);
//        ListUtilities.display(list);
//        list.remove(9);
//        ListUtilities.display(list);
//        System.out.println(list.size());
//        System.out.println(list.get(4));
//        list.set(888,4);
//        list.swap(2,8);
//        System.out.println(list.get(4));
//        ListUtilities.display(list);
//
//        ListUtilities.display(list);
//        ListUtilities.insertSort(list);
//        ListUtilities.display(list);


    }
}
