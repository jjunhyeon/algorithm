package com.pass.boj.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 오르막수_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // dp의 i배열은 N사이즈 크기만큼, j에는 0부터 ~ 9까지의 값을 할당하기 위한 공간으로 할당
        // dp 값의 의미는 현재 i,j 값의 총 오르막수의 값
        long[][] dp = new long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] = dp[i][j] % 10007;
            }
        }

        long answer = 0;

        for(int i=0; i<10; i++){
            answer += dp[N][i];
        }
        System.out.println(answer % 10007);
        bf.close();

    }
}