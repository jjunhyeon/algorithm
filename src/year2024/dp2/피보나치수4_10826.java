package src.year2024.dp2;

import java.math.BigInteger;
import java.util.Scanner;

public class 피보나치수4_10826 {

    public static BigInteger[] fibo = new BigInteger[10001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        BigInteger target = getFibo(N);
        System.out.println(target);
        sc.close();
    }

    private static BigInteger getFibo(int n) {

        if (fibo[n] != null) {
            return fibo[n];
        }

        if (n == 0) {
            return fibo[n] = BigInteger.valueOf(0);
        } else if (n == 1 || n == 2) {
            return fibo[n] = BigInteger.valueOf(1);
        }

        return fibo[n] = getFibo(n - 1).add(getFibo(n - 2));
    }
}
