package src.year2024.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다리놓기_1010 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            String[] line = bf.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            sb.append(comb(M,N)).append("\n");
        }
        System.out.println(sb);
    }

    public static int comb(int n, int r){

        // 이미 풀린 경우 바로 반환
        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        // 2번 성질
        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        // 1번 성질
        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);

    }
}
