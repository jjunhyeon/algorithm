
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 트리의 지름
* */
public class Main {
    // 그래프 정보
    static ArrayList<ArrayList<Node>> nodeInfo = new ArrayList<ArrayList<Node>>();
    static boolean[] visited;
    static int max = 0, maxIndex = 0;
    static class Node{
        int to; // target 정점
        int weight; // 가중치 값
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // Node의 수
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) { // N번까지 값을 넣아야하므로 <= 처리
            // edge에 Edge ArrayList 초기화
            nodeInfo.add(new ArrayList<>());
        }

        while (N-- > 0) {
            String[] lineNumbers = bf.readLine().split(" ");
            // 0번은 정점 정보가 아닌 시작 노드, 마지막값은 의미없는값임
            int from = -1, target = -1, weight = -1;
            for (int i = 0; i < lineNumbers.length - 1; i++) {
                if (i == 0) { // 시작 노드
                    from = Integer.parseInt(lineNumbers[i]);
                } else if (i % 2 != 0) { // 타겟 노드
                    target = Integer.parseInt(lineNumbers[i]);
                } else { // 가중치
                    weight = Integer.parseInt(lineNumbers[i]);
                }
                if (target != -1 && weight != -1) {
                    nodeInfo.get(from).add(new Node(target, weight));
                    target = -1;
                    weight = -1;
                }
            }
        }
        // 임의의 두점이므로 최대값을 구하면 됨
        // boolean의 초기값은 올 false
        visited = new boolean[nodeInfo.size()];
        dfs(1,0);

        visited = new boolean[nodeInfo.size()]; // 리셋, 최대 정점을 구한 값으로 다시
        dfs(maxIndex, 0);
        System.out.println(max);
    }

    /*
    * @param to : 도착 정점
    * @param weight : 가중치 값
    * */
    static void dfs(int to, int weight){

        if(weight > max){
            max = weight;
            maxIndex = to;
        }

        visited[to] = true;
        for(Node n : nodeInfo.get(to)){
            if(!visited[n.to]){
                dfs(n.to,weight+n.weight);
            }
        }
    }
}
