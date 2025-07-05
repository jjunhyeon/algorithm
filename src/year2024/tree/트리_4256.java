package src.year2024.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리_4256 {
    static int[] preOrder, inOrder;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            preOrder = new int[N];
            inOrder = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
            }

            findPostOrder(0, 0, N - 1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    public static void findPostOrder(int idx, int start, int end) {

        if (idx >= N) {
            return;
        }

        int root = preOrder[idx];

        for (int i = start; i <= end; i++) {
            if (root == inOrder[i]) {
                // 재귀 파라미터 왜?
                findPostOrder(idx + 1, start, i);
                findPostOrder(idx + i + 1 - start, i + 1, end);
                sb.append(root + " ");
                return;
            }
        }


    }
}
