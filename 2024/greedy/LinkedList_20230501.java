package greedy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 경로 탐색(인접리스트)
 * 노드의 개수가 매우 많을 때 인접행렬로 풀기에 적합하지 않음
 * 갈 수 있는 정점을 보기 위해선 노드의 개수만큼 돌기때문에
 * 메모리 낭비가 심해짐
 * 이를 해결 할 수 있는 방법 중 하나가 인접리스트를 사용하는 방법이다.
 */
public class LinkedList_20230501 {
    static class Main {
        static int n, m, answer = 0;
        static ArrayList<ArrayList<Integer>> graph;
        static int ch[];

        public void LinkedList(int V) {

            if (V == n) {
                answer++;
            } else {
                // V번 ArrayList
                for (int nv : graph.get(V)) {
                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        LinkedList(nv);
                        ch[nv] = 0;
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
            graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= n; i++) {
                // 접근한값에 대해 null pointer 에러가 나오지 않도록 하기 위해 객체를 생성해야한다.
                graph.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < m; i++) {
                int a = kb.nextInt();
                int b = kb.nextInt();
                graph.get(a).add(b);
            }

            ch[1] = 1;
            T.LinkedList(1);
            System.out.println(answer);
        }
    }
}
