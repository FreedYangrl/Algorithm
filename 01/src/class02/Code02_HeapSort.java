package class02;

public class Code02_HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert1(arr,i);
        }
        int size=arr.length;
        swap(arr,0,--size);
        while (size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }


    }
    public static void heapInsert1(int[] arr, int index) {
       //-1/2==0
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) /2);
            index = (index - 1)/2 ;
        }
    }
    public static void heapInsert(int[] arr, int index){
        int cur =index;
        while (cur>0){
            int root = (cur-1)>>1;
            if(arr[cur]>arr[root]){
                swap(arr,cur,root);
                cur=root;
            }else {
                break;
            }
        }
    }

    public static void heapify(int[] arr, int index, int size){
        int left = 2*index+1;
        while (left<size){
            int largest=left+1<size&&arr[left+1]>arr[left]?left+1:left;
            if(arr[largest]>arr[index]){
                swap(arr,largest,index);
                index=largest;
            }else {
                break;
            }
            left=2*index+1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr1={-22, -24 ,-35 ,0 ,8 ,62 ,-8 ,14 ,15 ,23 ,31 ,40 ,3 ,43 ,13 ,72 ,9 ,16 ,14 ,61};
        for (int value:arr1) {
            System.out.print(value+" ");
        }
        System.out.println();
        heapSort(arr1);
        for (int value:arr1) {
            System.out.print(value+" ");
        }
    }
}
