
import java.util.Scanner;

public class Main {
    static int result = Integer.MAX_VALUE;

    public static class Test {
        public static int solution(int num) {
            int[] dp = new int[num + 1];
            dp[1] = 0;

            for (int i = 2; i <= num; i++) {
                dp[i] = dp[i - 1] + 1;

                if (i % 2 == 0)
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);

                if (i % 3 == 0)
                    dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            return dp[num];
        }
    }

    public static void main(String[] args) {
        Test T = new Test();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        System.out.println(T.solution( num));

    }
}
