package com.pass.algostudy.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_20230529 {
    public static class Edge implements Comparable<Edge> {
        int vex; // 간선
        int cost; // 가중치
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost; // poll이 될 떄 가장 작은값의 코스트(데이터)가 나옴
        }
    }
    static int n, m; // 정점의수 , 간선의 수
    static int[] dis; // 정답 array
    static ArrayList<ArrayList<Edge>> graph; // graph 정보

    public static class Test {
        public static void solution(int v) {
            PriorityQueue<Edge> pQ = new PriorityQueue<>(); // o(log n) 우선순위큐를 활용해 시간복잡도를 줄여서 처리
            pQ.offer(new Edge(v,0)); // 초기 vertex정보 셋 (1,0)  1번 to 1번은 0
            dis[v] =0; // 위와 같은 이유
            while(!pQ.isEmpty()){
                Edge tmp = pQ.poll();
                int now = tmp.vex; // 현재 들어가 있는 최소의 정점의 값
                int nowCost = tmp.cost; // 해당 정점의 최소 가중치 값
                if(nowCost>dis[now]) continue; // 만약 현재 정점의 가중치 값보다 지금 들어온 가중치 값이 더 커버리면 아래 로지글 수행할 필요 없다.
                for(Edge ob : graph.get(now)){ // graph.get(now) -> (2,13) (3,14) 등의 정점에서 (간선, 가중치) 정보가 리스트로 들어가 있음.
                    if(dis[ob.vex] > nowCost + ob.cost){ // ob.vex -> 위 리스트에서 뽑은 정점 , ob.ost -> 위 리스트에서 뽑은 가중치
                        dis[ob.vex] = nowCost + ob.cost; // 현재 가중치 + 이동하는데 필요한 가중치 값 < 이전 가중치 값 이라면 대체한다.
                        pQ.offer(new Edge(ob.vex, nowCost + ob.cost)); // q에 넣는다.
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Test T = new Test();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>()); // 객체 생성
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE); // 정답에는 최솟값이 세팅되므로 default값으로 max값을 설정한다.
        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b,c)); // 그래프에 간선 정보를 담는다.
        }
        T.solution(1);
        for(int i=1; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
