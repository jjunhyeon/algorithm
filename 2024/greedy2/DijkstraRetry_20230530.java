package greedy2;

import java.util.*;

/*
 * 다익스트라 다시풀기
 *
 * */
public class DijkstraRetry_20230530 {
    static ArrayList<ArrayList<Node>> edge = new ArrayList<>(); // 노드와 가중치를 표현할 그래프 정보
    static int[] dis; // 정답

    public static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) { // 정렬은 가중치의 최솟값이 정렬될 수 있게 오버라이딩 해야함
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return this.vertex + " " + this.weight;
        }
    }

    public static class Test {
        public static void solution(int x, int y) {
            PriorityQueue<Node> nQ = new PriorityQueue<>();
            nQ.offer(new Node(1, 0)); // root인 1에서 자기자신의 거리 가중치는 0임
            dis[1] =0; // 위와 같은 이유
            while (!nQ.isEmpty()) {
                Node tmp = nQ.poll();
                int now = tmp.vertex;
                int weight = tmp.weight;
                if(weight>dis[now]) continue; // 만약 현재 정점의 가중치 값보다 지금 들어온 가중치 값이 더 크면 Next
                for (Node info : edge.get(now)) {
                    if (dis[info.vertex] > info.weight + tmp.weight) {
                        dis[info.vertex] = info.weight + tmp.weight;
                        nQ.offer(new Node(info.vertex, info.weight + tmp.weight)); // q에 넣는다.
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Test T = new Test();
        Scanner kb = new Scanner(System.in);
        int vertexCount = kb.nextInt();
        int arrayCnt = kb.nextInt();

        for (int i = 0; i <= vertexCount; i++) {
            edge.add(new ArrayList<>());
        }
        // 6번 노드의 정답까지 표현할것이므로 +1 처리 한다.
        dis = new int[vertexCount+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < arrayCnt; i++) {
            int from = kb.nextInt();
            int target = kb.nextInt();
            int weight = kb.nextInt();
            edge.get(from).add(new Node(target, weight));
        }
        T.solution(1, 0);
        for(int i=1; i<=vertexCount; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
