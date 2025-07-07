package year2024.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는수열_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        // 현재까지의 증가하는 수열의 개수를 저장할 배열
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열의 최대값을 저장하기 위한 변수
        int max = 0;
        for (int i = 0; i < N; i++) {
            // 시작 배열의 기본값 설정
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 현재 기준의 값이 현재 값보다 크다면
                if (arr[i] > arr[j]) {
                    // 이전에 저장된 값에서 값을 하나씩 증가시킴(지금까지 증가하는 수열의 개수)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(max);
        bf.close();
    }

}
