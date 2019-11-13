package class02;
/**
 * 归并排序的扩展
 小和问题和逆序对问题
 小和问题
 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组
 的小和。 求一个数组 的小和。
 例子:[1,3,4,2,5]
 1左边比1小的数， 没有;
 3左边比3小的数， 1;
 4左边比4小的数， 1、 3;
 2左边比2小的数， 1;
 5左边比5小的数， 1、 3、 4、2;
 所以小和为1+1+3+1+1+3+4+2=16
 逆序对问题 在一个数组中， 左边的数如果比右边的数大， 则折两个数
 构成一个逆序对， 请打印所有逆序 对。
 */
public class Code01_2_SmallSum {
    //改写归并排序
    public static int getSmallSum(int[] arr){
       return mergeSort(arr,0,arr.length-1);
    }
    public static int mergeSort(int[]arr,int s,int e){
        if(s==e){
            return 0;
        }
        int mid = s+((e-s)>>1);
        return mergeSort(arr,s,mid)+mergeSort(arr,mid+1,e)+merge(arr,s,mid,e);
    }
    public static int merge(int[] arr,int s1,int e1,int e2){
        int sum=0;
        int[] temp=new int[e2-s1+1];
        int index=0;
        int l=s1,r=e1+1;
        while(l<=e1&&r<=e2){
            if(arr[l]<arr[r]){
                sum += (e2-r+1)*arr[l];
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
        return  sum;
    }

    public static void main(String[] args) {
        int[] arr={1,3,4,2,5};
        System.out.println(getSmallSum(arr));
    }
}
