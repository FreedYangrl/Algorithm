package class01;
/*
冒泡排序要注意的事项

 */
public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        int m=arr.length;
        for(int i=m;i>0;i--){//这一层是数组的长度
            for(int j=1;j<i;j++){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}
