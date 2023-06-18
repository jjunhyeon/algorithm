
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 연결요소의 개수 구하기
* 연결요소의 개수 :  연결된 정점 그룹의 개수
* 정점의 개수 : N,  간선의 개수 : M
* */
public class Main {

    static boolean visited[];
    static int N; // 정점의수
    static int M; // 간선의 수
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        graph = new int[N+1][N+1];
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            graph[a][b] =1;
            graph[b][a] =1;
        }
        int result = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]){
                continue;
            }
            DFS(i);
            result ++;
        }
        System.out.println(result);
    }

    private static void DFS(int V) {
        visited[V] = true;
        // 1번 정점부터 DFS 시작
        for(int i=0; i<graph[V].length; i++){
            // 탐색하지 않았고 그래프의 경로에 접근할 수 있는 노드 정보가 있다면
            if(graph[V][i] != 0 && !visited[i]){
                // 해당 노드를 방문으로 수정
                DFS(i); // 재귀 호출
            }
        }
    }
}
