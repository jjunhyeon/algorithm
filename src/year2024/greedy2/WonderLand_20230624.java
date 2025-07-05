package src.year2024.greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 원더랜드
 * 트리와 그래프의 차이점에 대해
 * 트리 : 돌아오는 회선 정보가 없음 (간선은 노드의 수 -1)
 * 그래프 : 모든 노드들이 연결 됨
 * 지금 0624 18 : 10
 * */
public class WonderLand_20230624 {
    static int[] relation;

    public static class Node implements Comparable<Node> {
        // 출발 노드
        int fromVertex;
        // 도착 노드
        int targetVertex;
        // 가중치 값
        int weight;

        Node(int fromVertex, int targetVertex, int weight) {
            this.fromVertex = fromVertex;
            this.targetVertex = targetVertex;
            this.weight = weight;
        }

        @Override // 가중치 값이 작은 순서대로 정렬될 수 있게한다.
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        @Override // 값 확인위해 사용
        public String toString() {
            return this.fromVertex + " " + this.targetVertex + " " + this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int arrCount = Integer.parseInt(st.nextToken());
        ArrayList<Node> nodeArray = new ArrayList<Node>();

        relation = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            relation[i] = i;
        }

        for (int i = 0; i < arrCount; i++) {
            String[] nodeInfo = bf.readLine().split(" ");
            int from = Integer.parseInt(nodeInfo[0]);
            int to = Integer.parseInt(nodeInfo[1]);
            int weight = Integer.parseInt(nodeInfo[2]);
            nodeArray.add(new Node(from, to, weight));
        }
        Collections.sort(nodeArray);
        // 해결
        System.out.println(solution(nodeArray));
    }

    private static int solution(ArrayList<Node> nodeArray) {
        int result = 0;
        int cnt = 0;
        for (Node item : nodeArray) {
            int fv1 = find(item.fromVertex);
            int fv2 = find(item.targetVertex);

            // 트리가 완성되었다면 더이상 뒤 간선 정보를 순회할 필요 없음
            if (cnt == nodeArray.size() - 1) {
                break;
            }

            if (fv1 != fv2) {
                cnt++;
                result += item.weight;
                Union(item.fromVertex, item.targetVertex);
            }
        }
        return result;
    }

    // 노드 관계 연결
    private static void Union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            relation[fa] = fb;
        }
    }

    // 관계 검증
    private static int find(int V) {
        if (relation[V] == V) {
            return V;
        } else {
            // 길이진 관계에 대해 바로 처리하기 위한 코드
            // realtion[V]값에 find에 대한 결과값을 바로 넣음으로써 재귀 호출을 최소화한다.
            return relation[V] = find(relation[V]);
        }
    }
}
