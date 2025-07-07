package year2024.class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DiameterOfTree_1167_20230712 {
    // 그래프 정보
    static ArrayList<ArrayList<Node>> nodeInfo = new ArrayList<ArrayList<Node>>();
    // 정답 정보
    static int[] answer;
    static boolean flag = false;
    static int result = 0;

    public static class Node implements Comparable<Node> {
        // 정점과 가중치 정보
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) { // 가중치 값이 작은값 우선순위
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return this.vertex + " " + this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // Node의 수
        int N = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];
        for (int i = 0; i <= N; i++) { // N번까지 값을 넣아야하므로 <= 처리
            // edge에 Edge ArrayList 초기화
            nodeInfo.add(new ArrayList<>());
        }

        while (N-- > 0) {
            String[] lineNumbers = bf.readLine().split(" ");
            // 0번은 정점 정보가 아닌 시작 노드, 마지막값은 의미없는값임
            int from = -1, target = -1, weight = -1;
            for (int i = 0; i < lineNumbers.length - 1; i++) {
                if (i == 0) { // 시작 노드
                    from = Integer.parseInt(lineNumbers[i]);
                } else if (i % 2 != 0) { // 타겟 노드
                    target = Integer.parseInt(lineNumbers[i]);
                } else { // 가중치
                    weight = Integer.parseInt(lineNumbers[i]);
                }
                if (target != -1 && weight != -1) {
                    nodeInfo.get(from).add(new Node(target, weight));
                    target = -1;
                    weight = -1;
                }
            }
        }
        // 임의의 두점이므로 최대값을 구하면 됨
        int val = BFS(1);
        System.out.println(val);
    }

    private static int BFS(int V) {
        Arrays.fill(answer, 0);
        int idx = 0;

        PriorityQueue<Node> nq = new PriorityQueue<>();
        nq.offer(new Node(V, 0));
        // 초기값 SET
        answer[V] = 1;
        while (!nq.isEmpty()) {
            Node target = nq.poll();
            int nowVertex = target.vertex;
            int nowWeight = target.weight;
            // 1번 노드부터 시작
            for (Node tn : nodeInfo.get(nowVertex)) {
                // 거리비교
                if (answer[tn.vertex] == 0) {
                    // 현재 위치 + 움직인 가중치로 업데이트 한다.
                    nq.offer(new Node(tn.vertex, nowWeight + tn.weight));
                    answer[tn.vertex] = tn.weight + nowWeight;
                }
            }
        }

        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == 0) {
                continue;
            }
            if (result < answer[i]) {
                idx = i;
            }
            result = Math.max(result, answer[i]);
        }

        if (!flag) {
            flag = true;
            // idx -> 최대거리의 정점 정보
            BFS(idx);
        } else {
            for (int i = 1; i < answer.length; i++) {
                result = Math.max(result, answer[i]);
            }
        }
        return result;
    }
}
