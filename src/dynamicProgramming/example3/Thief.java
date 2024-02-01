package dynamicProgramming.example3;

import java.util.Arrays;

public class Thief {

    public static int solution(int[]arr){
        int n = arr.length;
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[1] = arr[0];

        for (int i = 2; i <= n; i++) {
            // 현재 집을 털 경우 vs 이전 집을 털 경우 중 큰 값 선택
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int []arr={2,18,9,13,14};
        System.out.println(solution(arr));
    }
}
