package src.year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 최소스패닝트리_1197
 * author         : junhyeon
 * date           : 2024-04-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-28        junhyeon       최초 생성
 */
public class 최소스패닝트리_1197 {
    static int[] parent ;
    static int result ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Node> PQ = new PriorityQueue<>(Comparator.comparingInt(Node -> Node.value));

        int nodeCount = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        for(int i=0; i<count; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            PQ.offer(new Node(start,end,value));
        }

        parent = new int[nodeCount+1];
        for(int i=1; i<=nodeCount; i++) parent[i] = i;

        while(!PQ.isEmpty()){
            Node cur = PQ.poll();
            if(!isSameParent(cur.start,cur.end)){
                union(cur.start,cur.end);
                // 최소 스패닝 트리는 가장 작은 비용이 드는 것을 먼저 연결(PQ의 정렬에 의해)
                // 가장 마지막에 연결한 요소가 가장 큰 비용
                result += cur.value;
            }
        }

        System.out.println(result);
    }

    private static boolean isSameParent(int start, int end) {
        int fx = find(start);
        int fy = find(end);
        if(fx != fy) return false;
        return true;
    }

    public static void union(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy) {
            parent[fy] = fx;
        }
    }

    private static int find(int start) {
        if(start == parent[start]){
            return start;
        }
        return parent[start] = find(parent[start]);
    }

    static class Node{
        int start;
        int end;
        int value;
        Node(int start,int end,int value){
            this.start =start;
            this.end =end;
            this.value = value;
        }
    }
}
