package year2024.greedy;

import java.util.Scanner;

/**
 * 그래프
 * G(V,E)
 * Vertex와 Edge로 이루어져 있다.
 * [1,2],[1,3][2,4],[2,5]... 등의 형식으로 인접행렬이 들어온다.
 * 2차원 배열
 * 간선정보가 2차원 배열안에 들어있다.
 * graph[a][b] = 1; -> 연관 관계가 있다.
 * graph[b][a] = 1; -> [1,2] 간서 정보 표현 방식
 * <p>
 * 방향그래프(2차원 배열)
 * 1 2 -> 1에서 2로 방향에 대한 정보
 * 2 3 -> 2에서 3으로 가는 방향에 대한 정보
 * <p>
 * 가중치 방향 그래프
 * 방향 정보에 가중치 값이 들어있음
 */
public class Graph_20230501 {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    static class Main {
        public void DFS(int V) {
            // v의 값은 node의 개수
            if (V == n) {
                // 마지막 노드까지의 케이스를 찾음
                answer++;
            } else { // 1번 노드부터 그래프 정보를 탐색하면서 개수를 찾아간다.
                for (int i = 1; i <= n; i++) { // root부터 연결된 정보를 찾아가는데
                    if (ch[i] == 0 && graph[V][i] == 1) { // 방문하지 않았는데 인접 정보가 있다면 찾아나감
                        ch[i] = 1; // 해당 노드를 방문했음을 저장하고
                        DFS(i); // 하위 노드를 호출한다. (DFS(1) -> DFS(2) 호출)
                        ch[i] = 0; // 호출 이후 다시 방문정보를 0으로 지워준다.
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ch = new int[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
