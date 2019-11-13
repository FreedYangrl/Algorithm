package class02;
//计算逆序对数有优势，打印逆序对没有优势
//我的算法写得有问题
public class Code01_3_ReverseSum {
    public static void getReverse(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        System.out.println(mergeSort(arr,0,arr.length-1));
    }
    public static int mergeSort(int[]arr,int s,int e){
        if(s==e){
            return 0;
        }
        int mid = s+((e-s)>>1);
      return   mergeSort(arr,s,mid)+mergeSort(arr,mid+1,e)+merge(arr,s,mid,e);
    }
    public static int merge(int[] arr,int s1,int e1,int e2){
        int[] temp=new int[e2-s1+1];
        int sum=0;
        int index=0;
        int l=s1,r=e1+1;
        while(l<=e1&&r<=e2){
            if(arr[l]<arr[r]){
                temp[index++]=arr[l++];
            }else{
                sum += e1-l+1;
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
        return sum;
    }
    public static void main(String[] args) {
        int[] arr={2,5,4,1,3};
        getReverse(arr);
    }
}
