package listimpl.sorting;

public class QuickSort {
    public void sort(int[] t, int firstIndex, int lastIndex){
        if(lastIndex < 1 || lastIndex == firstIndex) return;
        int swapIndex = firstIndex;
        int pivot = t[lastIndex];
        for (int i = firstIndex; i <= lastIndex; i++) {
            if (t[i] <= pivot) {
                swap(t, i, swapIndex);
                swapIndex++;
            }
        }
        sort(t,firstIndex,swapIndex-2);
        sort(t,swapIndex,lastIndex);

    }

    private void swap(int[] t, int index1, int index2){
        int tmp = t[index1];
        t[index1] = t[index2];
        t[index2] = tmp;
    }
}
