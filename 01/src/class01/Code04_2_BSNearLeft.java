package class01;
//在一个有序数组中， 找>=某个数最左侧的位置
public class Code04_2_BSNearLeft {
    public static int nearestIndex(int[] arr, int value){
        if (arr==null  ){
            return -1;
        }
        int index=-1,L=0,R=arr.length-1;
        while(L <= R){
            int mid = L+((R-L)>>1);
            if(arr[mid]>=value){
                index =mid;
                R = mid-1;
            }else {
                L=mid+1;
            }
        }
        return index;
    }

}
