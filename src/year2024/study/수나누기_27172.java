package src.year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수 나누기
 *
 * */
public class 수나누기_27172 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int MAX_LEN = 1000001;
        int[] user = new int[N];
        boolean[] card = new boolean[MAX_LEN];
        int[] answer = new int[MAX_LEN];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            user[i] = Integer.parseInt(st.nextToken());
            card[user[i]] = true;
        }

        // dfs로 0번째 1번째, 0번째 2번쨰 ..->
        for (int u : user) {
            for (int i = u * 2; i < MAX_LEN; i += u) {
                if (card[i]) {
                    answer[i]--;
                    answer[u]++;
                }
            }
        }

        for (int n : user) sb.append(answer[n]).append(" ");
        System.out.println(sb);
        bf.close();
    }

}
