

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 문제의 최대 설정 범위
    // 길이별 이친수의 개수를 저장할 dp array(값의 범위 : 1 ~ 90)
    // 90이면 int로 처리 불가 -> long 사용
    static long[] dp = new long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        // 기본값 설정
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        setDpArray(N);
        System.out.println(dp[N]);
    }

    private static long setDpArray(int number) {
        if (dp[number] != 0) {
            return dp[number];
        }
        return dp[number] = setDpArray(number - 2) + setDpArray(number - 1);
    }
}
