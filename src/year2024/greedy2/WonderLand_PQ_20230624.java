package src.year2024.greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 원더랜드
 * 트리와 그래프의 차이점에 대해
 * 트리 : 돌아오는 회선 정보가 없음 (간선은 노드의 수 -1)
 * 그래프 : 모든 노드들이 연결 됨
 * PriortyQueue 사용
 * */
public class WonderLand_PQ_20230624 {
    // 방문정보
    static int[] visited;

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
        ArrayList<ArrayList<Node>> nodeArray = new ArrayList<ArrayList<Node>>();

        visited = new int[nodeCount + 1];
        for(int i=0; i<=nodeCount; i++){
            nodeArray.add(new ArrayList<>());
        }

        for (int i = 0; i < arrCount; i++) {
                String[] nodeInfo = bf.readLine().split(" ");
                int from = Integer.parseInt(nodeInfo[0]); // 시작 
                int to = Integer.parseInt(nodeInfo[1]); // 도착
                int weight = Integer.parseInt(nodeInfo[2]); // 가중치
                nodeArray.get(from).add(new Node(from, to, weight));
                nodeArray.get(to).add(new Node(to, from, weight)); // 양방향 정보 세팅
        }
        // 해결
        System.out.println(solution(nodeArray));
    }

    private static int solution(ArrayList<ArrayList<Node>> nodeArray) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,1,0));

        int result = 0;
        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            int tv = tmp.targetVertex;
            if(visited[tv] == 0){
                visited[tv] =1;
                result += tmp.weight;
                for (Node item : nodeArray.get(tv)) {
                    if(visited[item.targetVertex] == 0){
                        pq.offer(new Node(0,item.targetVertex, item.weight));
                    }
                }
            }
        }
        return result;
    }
}
