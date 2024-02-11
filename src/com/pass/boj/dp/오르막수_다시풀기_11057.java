package com.pass.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 오르막길 문제 다시풀기
public class 오르막수_다시풀기_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        // 입력받는 길이의 정보까지 dp 구조를 잡기 위함
        long[][] dp = new long[N+1][10];

        for(int i=0; i<10; i++){
            // 각 길이의 첫번째 배열의 값을 모두 1로 초기화한다.
            dp[0][i] =1;
        }

        for(int i=1; i<=N; i++){
            for(int j=0; j<10; j++){
                long temp =0;
                for(int k=0; k<=j; k++){
                    temp += dp[i-1][k];
                }
                dp[i][j] = temp % 10007;
            }
        }


        long answer = 0;
        for(int i=0; i<10; i++){
            answer += dp[N-1][i];
        }
        System.out.println(answer % 10007);
        bf.close();
    }
}
