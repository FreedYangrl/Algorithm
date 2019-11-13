package class01;

public class Code04_1_BSExist {
    public  static boolean exit(int[] sortedArr, int num){
        if(sortedArr==null || sortedArr.length<2){
            return false;
        }
        int l=0,r=sortedArr.length-1;
        while (l<=r){
            int mid = l+((r-l)>>1);
            if(sortedArr[mid]==num){
                return true;

            }else{
                if(sortedArr[mid]>num){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return false;
    }

}
