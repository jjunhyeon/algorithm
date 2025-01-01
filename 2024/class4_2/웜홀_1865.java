package class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 웜홀
* 벨만포드 알고리즘
* 벨만-포드 알고리즘은 음의 가중치가 있는 경우나 음의 사이클을 감지해야 하는 경우 사용한다
* */
public class 웜홀_1865 {
    public static class Node{
        int end;
        int weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        public String toString(){
            return this.end + " " + this.weight;
        }
    }
    static int[] dist;
    static final int INF = 987654321;
    static ArrayList<ArrayList<Node>> answerList;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int testCaseCount = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while(testCaseCount-->0){

            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            answerList = new ArrayList<>();
            for(int i=0; i <= N; i++){
                answerList.add(new ArrayList<>());
            }

            // roadCount 정보 시작
            for(int i=0; i< M + W; i++){
                st = new StringTokenizer(bf.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if(i < M){
                    // 로드
                    answerList.get(start).add(new Node(end,weight));
                    answerList.get(end).add(new Node(start,weight));
                } else {
                    // 웜홀
                    answerList.get(start).add(new Node(end, -weight));
                }
            }

            boolean isMinusCycle = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i, N)) {
                    isMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }

            if (!isMinusCycle) {
                sb.append("NO\n");
            }
        }
        bf.close();
        System.out.println(sb);
    }

    public static boolean bellmanFord(int start,int N){
        Arrays.fill(dist, INF);
        dist[start] = 0; // 초기 위치 0 시작
        boolean update = false;

        // 벨만-포드 알고리즘에서 사용되는 이유는 최단 경로의 길이가 그래프의 정점의 개수보다 항상 작거나 같기 때문
        for(int i = 1; i<= N; i++){
            update = false;

            // 최단거리 초기화.
            for (int j = 1; j <= N; j++) {
                for (Node cur : answerList.get(i)) {
                    if (dist[j] != INF  && dist[cur.end] > dist[j] + cur.weight) {
                        dist[cur.end] = dist[j] + cur.weight;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }
        System.out.println(Arrays.toString(dist));

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Node road : answerList.get(i)) {
                    // 갱신이 또 발생해야 진짜 - 가중치
                    if (dist[i] != INF  && dist[road.end] > dist[i] + road.weight ) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
