package dynamicProgramming.example2;

import java.util.Arrays;

public class Leaves {

    public static int solution(int[][]counselor,int n){
        int []dp = new int[n+1];
        for(int i=0;i<n;i++){
            int p = counselor[i][0];
            int m = counselor[i][1];
            if(i+p<=n){
                dp[i+p]=Math.max(dp[i+p],dp[i]+m);
            }
            dp[i+1]=Math.max(dp[i+1],dp[i]);
        }
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 7;
        int[][]counselor = {
                {3, 10},
                {5, 20},
                {1, 10},
                {1, 20},
                {2, 15},
                {4, 40},
                {2, 200}
                //{1, 8},
                //{1 ,9},
                //{1, 10}
        };

        System.out.println(solution(counselor,n));
    }
}
