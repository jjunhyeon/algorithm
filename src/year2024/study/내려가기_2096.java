package year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] defaultInfo = new int[N + 1][3];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                defaultInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] minArray = new int[N + 1][3];
        int[][] maxArray = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            minArray[i][0] += Math.min(minArray[i - 1][0], minArray[i - 1][1]) + defaultInfo[i][0];
            minArray[i][1] += Math.min(Math.min(minArray[i - 1][0], minArray[i - 1][1]), minArray[i - 1][2]) + defaultInfo[i][1];
            minArray[i][2] += Math.min(minArray[i - 1][1], minArray[i - 1][2]) + defaultInfo[i][2];

            maxArray[i][0] += Math.max(maxArray[i - 1][0], maxArray[i - 1][1]) + defaultInfo[i][0];
            maxArray[i][1] += Math.max(Math.max(maxArray[i - 1][0], maxArray[i - 1][1]), maxArray[i - 1][2]) + defaultInfo[i][1];
            maxArray[i][2] += Math.max(maxArray[i - 1][1], maxArray[i - 1][2]) + defaultInfo[i][2];
        }

        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, minArray[N][i]);
            max = Math.max(max, maxArray[N][i]);
        }
        sb.append(max + " " + min);
        System.out.println(sb);
    }
}
