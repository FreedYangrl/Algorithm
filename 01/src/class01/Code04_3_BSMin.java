package class01;

//局部最小值问题
//一定会存在局部最小值
public class Code04_3_BSMin {

    public static int getLessIndex(int[] arr){
       if(arr==null || arr.length==0){
           return -1;
       }
       if(arr.length==1 || arr[0] < arr[1]){
           return 0;
       }
       if(arr[arr.length-1]<arr[arr.length-2]){
           return arr.length-1;
       }
       int l=1;
       int r=arr.length-2;
       while(l<=r){
           int mid=l+((r-l)>>1);
           if(arr[mid-1]<arr[mid]){
               r = mid-1;
           }else if(arr[mid+1] < arr[mid]){
               l = mid+1;
           }else {
               return mid;
           }
       }
       return  -1;

    }

    public static int getLessIndex1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = { 6, 5, 7, 8, 6, 7, 8 };
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);
    }
}
