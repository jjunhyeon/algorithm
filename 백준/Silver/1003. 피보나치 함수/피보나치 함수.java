
import java.io.*;

// 피보나치
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // TESTCASE COUNT
        int T = Integer.parseInt(bf.readLine());

        int[] fibo = new int[41];
        fibo[1] = 1;
        fibo[2] = 1;
        fibo[3] = 2;
        getFiboNum(40, fibo);
        while (T-- > 0) {
            int N = Integer.parseInt(bf.readLine());
            StringBuilder answer = new StringBuilder();
            if (N == 0) {
                answer.append(1 + " " + 0);
            } else {
                answer.append(fibo[N - 1] + " " + fibo[N]);
            }
            bw.write(answer.toString());
            bw.newLine();
        }
        bf.close();
        bw.close();
    }

    // 피보나치 수 구하기
    private static int getFiboNum(int n, int[] fibo) {
        if (fibo[n] != 0) {
            return fibo[n];
        }
        return fibo[n] = getFiboNum(n - 1, fibo) + getFiboNum(n - 2, fibo);
    }
}
