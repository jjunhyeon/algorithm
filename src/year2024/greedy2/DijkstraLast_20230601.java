package src.year2024.greedy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 다익스트라 알고리즘
* 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램 만들어보자.
* */
public class DijkstraLast_20230601 {

    // 정점과 간선의 정보를 표현할 edge
    static ArrayList<ArrayList<Edge>> edge =new ArrayList<ArrayList<Edge>>();
    // 정답 배열
    static int[] ans;
    static class Edge implements Comparable<Edge>{
        int vertex, weight; // 정점과, 가중치
        Edge(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {// 가중치가 작은 기준으로 정렬될 수 있게 오버라이딩
            return this.weight - o.weight;
        }
    }
    public static class Main{
        public static void solution(int v){
            // 1번 노드는 가중치 0이다.
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(v,0));
            ans[v] = 0;
            // 시작
            while(!pq.isEmpty()){
                Edge eg = pq.poll();
                // 초기는 1, 0
                int nowVertex = eg.vertex;
                int nowWeight = eg.weight;
                // nowWeight 추가 처리 필요,,
                if(nowWeight > ans[nowVertex]){
                    continue;
                }
                for(Edge item : edge.get(nowVertex)){
                    // 지금 1번 노드부터 N번 노드까지의 최소 거리비용이 담긴 배열보다 현재 탐색하는 노드의 가중치값 + 움직인 가중치의 합이 더 작다면 바꿔야지
                    if(ans[item.vertex] > nowWeight + item.weight){
                        ans[item.vertex] = nowWeight + item.weight;
                    }
                    pq.offer(new Edge(item.vertex, nowWeight + item.weight));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int arrayCnt = kb.nextInt();
        // 1번 노드를 중점으로 6번까지 최소거리비용을 출력해야하므로 +해서 처리한다.
        ans = new int[k+1];
        // 최대값으로 세팅(최소값을 구하기 위함)
        Arrays.fill(ans, Integer.MAX_VALUE);
        for(int i=0; i<=k; i++){ // N번 노드까지의 정보를 넣어야함.
            // edge에 Edge ArrayList 초기화 그래야 값을 넣지
            edge.add(new ArrayList<Edge>());
        }

        for(int i=0; i<arrayCnt; i++){
            int fromNode = kb.nextInt();
            int endNode = kb.nextInt();
            int weightInfo = kb.nextInt();
            edge.get(fromNode).add(new Edge(endNode,weightInfo));
        }
        // 1번 to 1번
        T.solution(1);

        for(int i=1; i<ans.length; i++){
            if(ans[i] == Integer.MAX_VALUE){
                System.out.println(i + " : impossible" );
            } else {
                System.out.println(i + " : " + ans[i]);
            }
        }
    }
}
