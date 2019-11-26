package InsertionSort;

import java.io.File;
import java.io.FileNotFoundException;

public class TestInsertionSort {

    public static void main(String[] args) throws FileNotFoundException {
        InsertionSort insertion = new InsertionSort();

        File F = new File("data02.txt");

        //int[] arr = insertion.insert(F);
        int[] arr = insertion.insert(F);

        System.out.println("< Insertion Sort >  201602066");
        insertion.InsertionSort(arr);
        insertion.write(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }

}