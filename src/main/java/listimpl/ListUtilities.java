package listimpl;

import java.util.ArrayList;
import java.util.List;

public class ListUtilities {
    public static void display(IList list){
        for (int i = 0; i < list.size();i++)
            System.out.print(list.get(i)+" ");
        System.out.println();
    }

    public static void display(List list){
        for (int i = 0; i < list.size();i++)
            System.out.print(list.get(i)+" ");
        System.out.println();
    }



    public static void mergeSort(List<Integer> mergeTable){
        int[] tmpMerge = new int[mergeTable.size()];

        for (int i = 0; i<mergeTable.size();i++) {
            tmpMerge = new int[mergeTable.size()];
            tmpMerge[i] = mergeTable.get(i);
            }
        for (int i = 0; i<mergeTable.size()-1;i++){
            if (tmpMerge[i]>tmpMerge[i+1]) {
//                tmpMerge[i] = mergeTable.get(i+1);
                int tmp = tmpMerge[i];
                tmpMerge[i] = tmpMerge[i + 1];
                tmpMerge[i + 1] = tmp;
            }
           for (int j=i;j<mergeTable.size();j++) {
                if (tmpMerge[i] <= tmpMerge[j]) {
                    tmpMerge[i] = mergeTable.get(i);
                    tmpMerge[j] = mergeTable.get(j);
//                    mergeTable.set(i,tmpMerge[i]);
//                    mergeTable.set(i+1,tmpMerge[j]);

                } else if(mergeTable.get(i)>mergeTable.get(j))
                    tmpMerge[i] = mergeTable.get(j);
                    tmpMerge[j] = mergeTable.get(i);


                }
            mergeTable.set(i,tmpMerge[i]);
            }
        }



    public static void insertSort (IList<Integer> firstTable){
        int unsortedIndex =1;
        do {
            if (firstTable.get(unsortedIndex) <= firstTable.get(0))
                moveValue(firstTable, unsortedIndex, 0);
            else {
                for(int i=0; i<unsortedIndex-1;i++){
                    if(firstTable.get(unsortedIndex)>= firstTable.get(i) &&
                    firstTable.get(unsortedIndex)<= firstTable.get(i+1)) {
                        moveValue(firstTable, unsortedIndex,i+1);
                        break;
                    }
                }
            }
            unsortedIndex++;
        }while(unsortedIndex!=firstTable.size());

    }

    private static void moveValue (IList list, int fromIndex, int toIndex){
        list.add(list.get(fromIndex),toIndex);
        list.remove(fromIndex+1);
    }
}
