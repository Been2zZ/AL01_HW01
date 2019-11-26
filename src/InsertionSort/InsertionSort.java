package InsertionSort;

import java.io.*;
import java.util.Arrays;

public class InsertionSort {

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
        File file = new File("ResultInsertionSort.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.write("< Insertion Sort >    201602066\n");
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

    public int[] InsertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {   // 1번째 원소부터 끝까지 반복
            int temp = arr[i];
            int j = i - 1;                  // temp의 전 원소

            while(j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];        // swap
                j--;                        // j 1 감소
            }
            arr[j+1] = temp;                // swap
        }
        return arr;
    }
}
