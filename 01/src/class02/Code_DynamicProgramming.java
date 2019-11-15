package class02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划的四个步骤
 * 1.问题拆解，找出问题之间的关联
 * 2.状态定义
 * 3.递推方程推导
 * 4.实现
 */
public class Code_DynamicProgramming {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * @param n
     * @return
     */
    public static int stairs(int n){
        if(n<=2){
            return n;
        }
        int[] dp =new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }

    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * 例如，给定三角形：
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     *
     * @return
     */
    /*
 给定一个三角形数组，需要求出从上到下的最小路径和，也和之前一样，按照四个步骤来分析：
问题拆解：
这里的总问题是求出最小的路径和，路径是这里的分析重点，路径是由一个个元素组成的，和之前爬楼梯那道题目类似，[i][j] 位置的元素，
经过这个元素的路径肯定也会经过 [i - 1][j] 或者 [i - 1][j - 1]，
因此经过一个元素的路径和可以通过这个元素上面的一个或者两个元素的路径和得到。

状态定义
状态的定义一般会和问题需要求解的答案联系在一起，这里其实有两种方式，一种是考虑路径从上到下，
另外一种是考虑路径从下到上，因为元素的值是不变的，所以路径的方向不同也不会影响最后求得的路径和，
如果是从上到下，你会发现，在考虑下面元素的时候，起始元素的路径只会从[i - 1][j] 获得，
每行当中的最后一个元素的路径只会从 [i - 1][j - 1] 获得，中间二者都可，这样不太好实现，
因此这里考虑从下到上的方式，状态的定义就变成了 “最后一行元素到当前元素的最小路径和”，
对于 [0][0] 这个元素来说，最后状态表示的就是我们的最终答案。

递推方程
“状态定义” 中我们已经定义好了状态，递推方程就出来了dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]

实现
这里初始化时，我们需要将最后一行的元素填入状态数组中，然后就是按照前面分析的策略，从下到上计算即可
     */
    public static int triangleSum(List<List<Integer>> triangle){
        int n =triangle.size();
        int[][] dp=new int[n][n];
        List<Integer> lastRow=triangle.get(n-1);
        for(int i=0;i<lastRow.size();i++){
            dp[n-1][i]=lastRow.get(i);
        }
        for (int i=n-2;i>=0;i--){
            List<Integer> curlist=triangle.get(i);
            for(int j=0;j<curlist.size();j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+curlist.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 最大子序和
     * 示例：
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums){
        if (nums==null || nums.length==0)return Integer.MIN_VALUE;
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int result=0;
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1],0)+nums[i];
            result=Math.max(dp[i],result);
        }
        return result;
    }

    public static void main(String[] args) {
//        List<List<Integer>> triangle=new ArrayList<List<Integer>>() ;
//        triangle.add(Arrays.asList(2));
//        triangle.add(Arrays.asList(3,4));
//        triangle.add(Arrays.asList(6,5,7));
//        triangle.add(Arrays.asList(4,1,8,3));
//        System.out.println(triangleSum(triangle));

    }
}
