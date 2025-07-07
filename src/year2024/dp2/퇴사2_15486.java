package year2024.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 퇴사2_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] tArray = new int[N + 1];
        int[] mArray = new int[N + 1];

        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            String[] input = bf.readLine().split(" ");
            int T = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            tArray[i] = T;
            mArray[i] = M;
        }

        for (int i = N; i >= 1; i--) {
            if (i + tArray[i] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], mArray[i] + dp[i + tArray[i]]);
            }
        }

        System.out.println(dp[1]);
    }
}
