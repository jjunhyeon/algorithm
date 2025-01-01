package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 음악프로그램_2623
 * author         : junhyeon
 * date           : 2024-04-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-21        junhyeon       최초 생성
 */
public class 음악프로그램_2623 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int TEAM_COUNT = Integer.parseInt(st.nextToken());
        int PD_COUNT = Integer.parseInt(st.nextToken());
        int[] EDGE_COUNT = new int[TEAM_COUNT + 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= TEAM_COUNT; i++) {
            graph.add(new ArrayList<>());
        }

        int TEMP = 0;
        for (int i = 0; i < PD_COUNT; i++) {
            st = new StringTokenizer(bf.readLine());
            int COUNT = Integer.parseInt(st.nextToken());

            for (int j = 0; j < COUNT; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (j != 0) {
                    graph.get(TEMP).add(value);
                    EDGE_COUNT[value]++;
                }
                TEMP = value;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        // 진입차수가 0인 값을 큐에 넣어야한다.
        for (int i = 1; i <= TEAM_COUNT; i++) {
            if (EDGE_COUNT[i] == 0) {
                Q.offer(i);
            }
        }

        while (!Q.isEmpty()) {
            // 현재 노드
            int cur = Q.poll();
            sb.append(cur).append("\n");

            for (Integer item : graph.get(cur)) {
                // 인접 노드 정보 차감
                EDGE_COUNT[item]--;
                if (EDGE_COUNT[item] == 0) {
                    Q.offer(item);
                }
            }
        }
        System.out.println(sb.length() / 2 < TEAM_COUNT ? 0 : sb);
        bf.close();
    }
}
