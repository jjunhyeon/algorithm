package year2024.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 - 계단오르기
public class 계단오르기_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        // 계단
        int[] stair = new int[N + 1];
        // 현재 계단 값의 최대값을 저장할 DP 배열 생성
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) stair[i] = Integer.parseInt(bf.readLine());
        // 입력 끝
        bf.close();
        // 시작
        dp[1] = stair[1];
        if (N >= 3) {
            //한번에 2칸 vs (1칸 + 1칸)
            dp[2] = Math.max(stair[2], stair[1] + stair[2]);
            // 1칸 + 3칸 vs 2칸 + 3칸
            dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
            for (int i = 3; i <= N; i++) {
                // 전전칸까지의 최대값 + 현재칸 VS 전전전칸까지의 최대값 + 전칸 + 현재
                dp[i] = Math.max(stair[i] + dp[i - 2], stair[i] + dp[i - 3] + stair[i - 1]);
            }
        }
        System.out.println(N == 2 ? stair[1] + stair[2] : dp[N]);
    }
}
