
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
        int answer = 0;
        // 사실 홀짝은 의미없는듯
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 다르면 union
            if(find(start) == find(end)){
                answer = i + 1;
                break;
            }
            union(start,end);
        }
        System.out.println(answer);
    }

    private static void union(int start, int end) {
        int findX = find(start);
        int findY = find(end);
        // 합칠때는 더 작은 번호를 가진 부모 노드를 기준으로 병합한다.
        // 트리의 높이를 최대한 낮추어 집합 자료구조를 유지한다.
        if(findX < findY){
            parent[parent[findY]] = parent[findX];
        } else{
            parent[parent[findX]] = parent[findY];
        }
    }

    private static int find(int start) {
        if(start == parent[start]){
            return start;
        } else {
            parent[start] = find(parent[start]);
            return parent[start];
        }
    }
}
