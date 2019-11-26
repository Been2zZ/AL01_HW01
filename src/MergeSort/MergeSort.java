package MergeSort;

import java.io.*;
import java.util.Arrays;

public class MergeSort {

    int[] array;

    public int[] insert(File F) throws FileNotFoundException {
        FileReader fr = new FileReader(F);
        BufferedReader br = new BufferedReader(fr);

        String inputArr[];      // input String -> split(",") Array

        try {
            String line = "";
            while((line = br.readLine()) != null){
                inputArr = line.split(",");
                // lambda expression(String array -> Int array)
                array = Arrays.stream(inputArr).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }

        return array;
    }

    public void write(int[] arr) {
        File file = new File("ResultMergeSort.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.write("< Merge Sort >    201602066\n");
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i] + "\r\n");
                writer.flush();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int[] Merge(int[] arr, int l, int mid, int r) {
        // 합치기
        int i = l, j = mid + 1, k = l;
        int temp[] = new int[arr.length];

        while(i <= mid && j <= r) {
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= r)
            temp[k++] = arr[j++];

        for(i = l; i <= r; i++)
            arr[i] = temp[i];

        return array;
    }

    public int[] MergeSort(int[] arr, int l, int r) {
        // Recursive
        int mid;

        if(l < r) {
            mid = (l + r) / 2;
            MergeSort(arr, l, mid);
            MergeSort(arr, mid + 1, r);
            Merge(arr, l, mid, r);
        }

        return arr;
    }
}
