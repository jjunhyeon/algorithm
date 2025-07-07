package year2024.dp2;

import java.util.Arrays;
import java.util.Scanner;

// 백준 - 1로만들기
/*
 * TOP - DOWN
 * 문제를 해겨하는 함수를 재귀 호출을 통해 구현한다.
 * 문제의 크기를 줄여가면서, 작은 부분 문제들을 해결하고, 그 결과를 (DP) 등에 저장해둬서 중복 계산을 피한다.
 * 주로 메모이제이션을 활용한다.
 *
 * BOTTOM-UP
 * 작은 부분 문제부터 시작하여 전체 문제를 해결하는 방식의 코드
 * 반복문을 사용하여 작은 부분 문제들을 해결하고, 그 결과를 저장해가면서 전체 문제를 해결한다.
 * 주로 반복문을 사용하여 작은 문제부터 큰 문제 순으로 해결하기 때문에 효율적이다.
 *
 * */
public class MakeOne_1463 {
    static int N;

    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        dp = new int[N + 1];
        Arrays.fill(dp, -1); // 초기값으로 -1을 설정
        dp[1] = 1;
        System.out.println(dfs(N) - 1);
    }

    private static int dfs(int current) {

        // 값이 존재하면 탈출
        if (dp[current] > 0) {
            return dp[current];
        }

        if (current % 6 == 0) {
            dp[current] = Math.min(dfs(current / 2), dfs(current / 3)) + 1;
        } else if (current % 2 == 0) {
            dp[current] = Math.min(dfs(current / 2), dfs(current - 1)) + 1;
        } else if (current % 3 == 0) {
            dp[current] = Math.min(dfs(current / 3), dfs(current - 1)) + 1;
        } else dp[current] = dfs(current - 1) + 1;
        return dp[current];
    }
}
