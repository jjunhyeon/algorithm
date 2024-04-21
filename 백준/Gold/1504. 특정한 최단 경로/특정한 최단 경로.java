
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 특정한최단_1504
 * author         : junhyeon
 * date           : 2024-04-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-21        junhyeon       최초 생성
 */
public class Main {
    static ArrayList<ArrayList<Node>> mapInfo = new ArrayList<>();
    static int EDGE_COUNT = 0;
    static int LINE_COUNT = 0;
    static int[] TARGET;
    static int[] dis;
    static boolean[] visited;
    static int INF = 200000000;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        EDGE_COUNT = Integer.parseInt(st.nextToken());
        LINE_COUNT = Integer.parseInt(st.nextToken());

        for(int i=0; i<=EDGE_COUNT; i++){
            mapInfo.add(new ArrayList<>());
        }

        for(int i=0; i<LINE_COUNT; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            // 양방향 관계
            mapInfo.get(start).add(new Node(end,dist));
            mapInfo.get(end).add(new Node(start,dist));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dis = new int[EDGE_COUNT+1];
        TARGET = new int[]{start,end};
        visited = new boolean[EDGE_COUNT+1];
        bf.close();

        // 실제 탐색 시작

        int ans1 = 0;
        ans1 += find(1,TARGET[0]);
        ans1 += find(TARGET[0], TARGET[1]);
        ans1 += find(TARGET[1], EDGE_COUNT);

        int ans2 = 0; // 1 > v2 > v1 > N
        ans2 += find(1, TARGET[1]);
        ans2 += find(TARGET[1], TARGET[0]);
        ans2 += find(TARGET[0], EDGE_COUNT);

        if(ans1 >= INF && ans2 >= INF) answer = -1; //경로가 없는 경우
        else answer = Math.min(ans1, ans2); //경로가 있을 경우 더 작은 값
        System.out.println(answer);
    }

    private static int find(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        int[] dis = new int[EDGE_COUNT+1];
        Arrays.fill(dis,INF);
        Arrays.fill(visited, false);

        dis[start] = 0;
        pq.add(new Node(start,0));


        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dis[cur.idx] < cur.distance) continue;

            for(Node next : mapInfo.get(cur.idx)){
                // 정점 이동 비용이 갱신되어있는 값보다 작으면서 수색 범위보다 크지 않는 경우
                if(dis[next.idx] > dis[cur.idx] + next.distance){
                    dis[next.idx] = dis[cur.idx] + next.distance;
                    pq.offer(new Node(next.idx,dis[next.idx]));
                }
            }
        }

        return dis[end];
    }


    static class Node{
        private int idx;
        private int distance;
        Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }
}
