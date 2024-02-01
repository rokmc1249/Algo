package dynamicProgramming.example1;

import java.util.Arrays;

public class Triangle {
    static Integer[][] memo;
    public static int soulution(int[][]tri, int n){

        memo = new Integer[n][n];
        for(int i=0;i<n;i++){
            memo[n-1][i] = tri[n-1][i];
        }
        return dp(0,0,tri);
    }
    public static int dp(int row,int col,int[][]tri){

        if(memo[row][col]!=null){ // dp에 저장되어 있는지 확인
            return memo[row][col];
        }
        if(row<= tri.length-1&&col<= tri.length-1){ // 삼각형의 범위 조건
            memo[row][col]=tri[row][col]+Math.max(dp(row+1, col, tri),dp(row+1, col+1, tri));
        }
        return memo[row][col];
    }
    public static void main(String[] args) {
        int[][]tri = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2,6, 5}
        };
        int n = 5;
        System.out.println(soulution(tri,n));
    }
}
