import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 백준 그래프 생성 문제
* 다익스트라 알고리즘
* 모든 정점으로부터 가는 최단 경로를 알려주는 알고리즘
*
*/
public class Main {

    public static int[] shortestPathArray;
    public static ArrayList<ArrayList<Node>> myGraph = new ArrayList<ArrayList<Node>>();
    public static class Node implements Comparable<Node>{
        int targetNode;
        int weight;
        Node(int targetNode, int weight){
            this.targetNode = targetNode;
            this.weight = weight;
        }

        public String toString(){
            return this.targetNode + " " + this.weight;
        }

        // 가중치가 작은 기준으로 정렬될 수 있게 오버라이딩
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // node의 수가 result 배열의 크기
        shortestPathArray = new int[N + 1];
        Arrays.fill(shortestPathArray, Integer.MAX_VALUE);

        // 그래프 관계 그리기
        st = new StringTokenizer(bf.readLine());
        int startNode = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) myGraph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int targetNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            myGraph.get(fromNode).add(new Node(targetNode,weight));
        }
        // 다익스트라 시작
        dijkstra(startNode);

        for(int i=1; i<=N; i++) {
            if(shortestPathArray[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(shortestPathArray[i]);
        }
    }

    // startNode까지의 거리를 구하는 알고리즘을 작성한다.
    public static void dijkstra(int startNode){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode,0));

        // 시작노드는 0으로 설정
        shortestPathArray[startNode] = 0;

        while(!pq.isEmpty()){

            Node nowNode = pq.poll();
            int currentTargetNode = nowNode.targetNode;
            int currentWeight = nowNode.weight;

            if(shortestPathArray[currentTargetNode] < currentWeight) continue;

            for(Node next : myGraph.get(currentTargetNode)){
                int nextTargetNode = next.targetNode;
                int nextWeight = next.weight;
                if(shortestPathArray[nextTargetNode] > currentWeight + nextWeight){
                    shortestPathArray[nextTargetNode] = currentWeight + nextWeight;
                    pq.offer(new Node(nextTargetNode, currentWeight + nextWeight));
                }
            }

        }

    }
}
