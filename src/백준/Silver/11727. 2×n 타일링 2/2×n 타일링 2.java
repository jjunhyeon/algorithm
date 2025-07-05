
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 값의 범위 1 ~ 1000(int 처리 불가)
    static long[] dp = new long[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        setTileDp(N);
        System.out.println(dp[N]);
    }

    private static long setTileDp(int n) {
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = (setTileDp(n - 1) + (2 * setTileDp(n-2))) % 10007;
    }
}
