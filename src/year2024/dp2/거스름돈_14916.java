package src.year2024.dp2;

import java.util.Arrays;
import java.util.Scanner;

public class 거스름돈_14916 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] dp = new int[100001];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i=6;i <=K; i++){
            if(dp[i-2] == -1){
                dp[i] = dp[i-5] + 1;
            } else if(dp[i-5] == -1){
                dp[i] = dp[i-2] + 1;
            } else {
                dp[i] = Math.min(dp[i-5],dp[i-2]) + 1;
            }
        }

        System.out.println(dp[K]);
        sc.close();
    }
}
