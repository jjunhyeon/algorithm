
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        // 집의수1000 색깔의 수(red,green,blue)
        int[][] dp = new int[1001][3];
        int[][] rgb = new int[1001][3];


        StringTokenizer st;
        for(int i=1; i <=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        // red,green,blue 순서 탐색
        // 첫색 선택
        for(int i=0; i<3; i++){

            // 첫줄
            for(int j = 0; j<3; j++){
                if(j == i) {
                    dp[1][j] = rgb[1][j];
                } else {
                    dp[1][j] = 1000 * 3; // 충분히 큰 값으로 초기화
                }
            }

            for(int k=2; k<=N; k++){
                // 레드 최소
               dp[k][0] = Math.min(dp[k-1][1], dp[k-1][2]) + rgb[k][0];
               dp[k][1] = Math.min(dp[k-1][0], dp[k-1][2]) + rgb[k][1];
               dp[k][2] = Math.min(dp[k-1][0], dp[k-1][1]) + rgb[k][2];
            }

            // 마지막 집과 첫 번째 집이 동일하면 스킵
            for(int m = 0; m<3; m++){
                if(i == m) continue;
                answer = Math.min(answer, dp[N][m]);
            }
        }

        System.out.println(answer);
    }
}
