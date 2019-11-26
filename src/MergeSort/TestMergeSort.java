package MergeSort;

import java.io.File;
import java.io.FileNotFoundException;

public class TestMergeSort {

    public static void main(String[] args) throws FileNotFoundException {
        MergeSort merge = new MergeSort();

        File F = new File("data02.txt");

        int[] arr = merge.insert(F);

        System.out.println("< Merge Sort >  201602066");
        merge.MergeSort(arr, 0, arr.length-1);
        merge.write(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }
}
