package year2024.class4;

import java.util.Scanner;

/*
 * 피보나치 함수에서
 * 0과 1이 리턴되는 개수를 리턴해라.
 * */
public class Fibo_20230528 {
    public static int[] fiboArr = new int[41];
    static StringBuilder sb;
    public static class Main {
        public static void soltuion(int[] arr) {

            for (int x : arr) {
                sb = new StringBuilder();
                fibo(x);
                System.out.println(sb);
            }
        }

        public static void fibo(int n) {
            fiboArr[1] = 1;
            if (n == 0) {
                sb.append("1 0");
            } else if (n == 1) {
                sb.append("0 1");
            } else {
                // fiboarr이 호출되었을때 f0과 f1이 의 합을 리턴하게 되면 된다.
                for (int i = 2; i <= n; i++) {
                    fiboArr[i] = fiboArr[i - 2] + fiboArr[i - 1];
                }
                for (int i = 0; i < n; i++) {
                    if(i == n-1) {
                        sb.append(fiboArr[n - 1] + " " + fiboArr[n]);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = kb.nextInt();
        }
        T.soltuion(arr);
    }
}
