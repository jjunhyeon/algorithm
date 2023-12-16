
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
* 트리의 부모 찾기
* */
public class Main {


    public static ArrayList<Integer> list[];
    public static int[] parent; //부모노드
    public static boolean[] isVisited; // 방문여부


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 간선 관계 정보
        int N = Integer.parseInt(bf.readLine());
        isVisited = new boolean[N + 1];
        list = new ArrayList[N+1];
        parent = new int[N+1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parentValue =  Integer.parseInt(st.nextToken());
            int childValue = Integer.parseInt(st.nextToken());

            list[parentValue].add(childValue);
            list[childValue].add(parentValue);
        }
        dfs(1);

        for(int i=2; i<parent.length; i++) System.out.println(parent[i]);
        bf.close();

    }

    public static void dfs(int index){
        isVisited[index] = true;
        for(int i: list[index]){
            if(isVisited[i]) continue;
            parent[i] = index;
            dfs(i);

        }

    }
}
