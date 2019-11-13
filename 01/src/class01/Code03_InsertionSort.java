package class01;

import javax.tools.Tool;
import java.util.Arrays;

//插入排序
public class Code03_InsertionSort {
    public static void insertSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        int m=arr.length;
        for (int i = 1; i <m ; i++) {
            for (int j = i; j >0&&arr[j]<arr[j-1] ; j--) {
                    Tools.swap(arr,j-1,j);
            }
        }

    }


    public static void main(String[] args) {
        int[] arr1={-22, -24 ,-35 ,0 ,8 ,62 ,-8 ,14 ,15 ,23 ,31 ,40 ,3 ,43 ,13 ,72 ,9 ,16 ,14 ,61};
        int[] arr2=Tools.copyArray(arr1);
        insertSort(arr1);
        Tools.comparator(arr2);
        boolean succeed=true;
        if (!Tools.isEqual(arr1, arr2)) {
            succeed = false;
            Tools.printArray(arr1);
            Tools.printArray(arr2);

        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        Tools.printArray(arr1);
        Tools.printArray(arr1);
        Arrays.sort(arr2);
        Tools.printArray(arr2);
    }

}
