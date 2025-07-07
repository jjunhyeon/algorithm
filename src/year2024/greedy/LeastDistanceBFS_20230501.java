package year2024.greedy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS로 그래프 최단거리 해결하기
 * 1. LEVEL로 풀기
 * 2. DIS 설정해서 풀기
 */
public class LeastDistanceBFS_20230501 {
    static class Main {
        static int n, m;
        static int[] ch,dis;
        static ArrayList<ArrayList<Integer>> graph;

        public void BFS(int V) {
            Queue<Integer> Q = new LinkedList<>();
            ch[V] = 1;
            dis[V] = 0;
            Q.offer(V);
            while (!Q.isEmpty()) {
                int val = Q.poll();
                for (int nv : graph.get(val)) {
                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        Q.offer(nv);
                        dis[nv] = dis[val] +1;
                    }
                }
            }
        }

        public static void main(String args[]) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            graph = new ArrayList<ArrayList<Integer>>();
            int n = kb.nextInt();
            int m = kb.nextInt();
            ch = new int[n+1];
            dis = new int[n+1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < m; i++) {
                int a = kb.nextInt();
                int b = kb.nextInt();
                graph.get(a).add(b);
            }
            T.BFS(1);

            for(int i=2; i<n; i++){
                System.out.println(i + ":" + dis[i]);
            }
        }
    }
}
