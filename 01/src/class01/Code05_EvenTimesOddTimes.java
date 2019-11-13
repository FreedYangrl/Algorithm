package class01;
/*

异或运算的性质与扩展
1） 0^N == N N^N == 0
2） 异或运算满足交换律和结合率
3） 不用额外变量交换两个数
4） 一个数组中有一种数出现了奇数次， 其他数都出现了偶数次， 怎么找到这一个数
5） 一个数组中有两种数出现了奇数次， 其他数都出现了偶数次， 怎么找到这两个数
 */
public class Code05_EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr){
        if(arr == null)return;
        int temp=0;
        for (int i = 0; i <arr.length ; i++) {
            temp = temp ^ arr[i];
        }
        System.out.println(temp);
    }
    public static void printOddTimesNum2(int[] arr) {
        int e1=0,e=0;
        for(int cur : arr){
            e ^= cur;
        }
        int r=e & (~e +1);
        for (int cur : arr){
            if((cur & r) !=0){
                e1 ^= cur;
            }
        }
        System.out.println(e1+" "+(e^e1));
    }

    public static void main(String[] args) {
        int[] arr2={48,22,14,56,48,56};
        printOddTimesNum2(arr2);
    }
}
