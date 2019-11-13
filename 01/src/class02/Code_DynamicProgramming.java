package class02;

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
     * @param arr
     * @return
     */
    public static int triangleSum(List<List<Integer>> list){
        return 0;
    }
}
