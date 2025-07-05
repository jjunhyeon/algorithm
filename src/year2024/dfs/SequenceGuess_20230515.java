package src.year2024.dfs;

import java.util.Scanner;

/*
 * 수열 추측하기
 * 가장 윗줄에 1부터 N까지의 숫자가 한개씩 적혀 있고 둘째 줄 부터 삼각형처럼 위의 두개를 더한 값이 저장하게 된다.
 * 가장 윗줄에 있는 숫자의 갯수와 마지막 줄에 있는 수가 주어질 때 가장 윗줄에 있는 숫자를 출력해라.
 *
 * */
public class SequenceGuess_20230515 {
    static int n, f;
    static boolean flag;
    static int[] b, p;
    static int[] ch;
    static int[][] dy = new int[100][100];

    static class Main {
        public int combi(int n, int r) {
            if (dy[n][r] > 0) {
                return dy[n][r];
            }
            if (n == r || r == 0) {
                return 1;
            } else {
                return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
            }
        }

        public void DFS(int L, int sum) {
            if (flag) {
                return;
            }

            if (L == n) {
                if (sum == f) {
                    for (int x : p) System.out.print(x + " ");
                    flag = true;
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    if (ch[i] == 0) {
                        ch[i] = 1;
                        p[L] = i;
                        DFS(L + 1, sum + (p[L] * b[L]));
                        ch[i] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        //: 출발점 체크
        T.DFS(0, 0);
    }
}
