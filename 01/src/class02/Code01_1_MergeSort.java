package class02;

public class Code01_1_MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }
    public static void mergeSort(int[]arr,int s,int e){
        if(s==e){
            return;
        }
        int mid = s+((e-s)>>1);
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }
    public static void merge(int[] arr,int s1,int e1,int e2){
        int[] temp=new int[e2-s1+1];
        int index=0;
        int l=s1,r=e1+1;
        while(l<=e1&&r<=e2){
            if(arr[l]<arr[r]){
                temp[index++]=arr[l++];
            }else{
                temp[index++]=arr[r++];
            }
        }
        while (l<=e1){
            temp[index++]=arr[l++];
        }
        while (r<=e2){
            temp[index++]=arr[r++];
        }
        l=s1;
        for (int i = 0; i <temp.length ; i++) {
            arr[l++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr1={-22, -24 ,-35 ,0 ,8 ,62 ,-8 ,14 ,15 ,23 ,31 ,40 ,3 ,43 ,13 ,72 ,9 ,16 ,14 ,61};
        for (int value : arr1) {
            System.out.print(value+" ");
        }
        System.out.println();
        mergeSort(arr1);
        for (int value : arr1) {
            System.out.print(value+" ");
        }
    }
}
