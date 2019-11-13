package class01;
//二分找到数值中最大值
public class Code06_GetMax {
    public static int getMax(int[] arr) {
        return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr,int l,int r){
        if(l == r){
            return arr[r];
        }
        int mid = l+((r-l)>>1);
        return Math.max(process(arr,l,mid),process(arr,mid+1,r));
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,1,2,8,3,4,5,2};
        System.out.println(getMax(arr));
    }
}
