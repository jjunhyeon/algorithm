package com.pass.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는수열_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        // 현재까지의 최대 수열의 개수를 저장할 dp 배열 생성
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 입력끝
        bf.close();

        int max = 1;
        for(int i=0; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max,  dp[i]);
                }
            }
        }
        System.out.println(max);
    }

}
