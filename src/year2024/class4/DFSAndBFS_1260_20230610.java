package src.year2024.class4;

import java.util.*;

public class DFSAndBFS_1260_20230610 {
    static int[][] graph;
    static int n, m = 0;
    static int[] ch;
    static ArrayList<Integer> dfsAnswerInfo = new ArrayList<>();
    static ArrayList<Integer> bfsAnswerInfo = new ArrayList<>();

    public static class Main{
        public static void DFS_Solution(int V){
            // V -> 방문노드 정보(Node)
            dfsAnswerInfo.add(V);
            // IF - ELSE 처리
            // 종료조건
            if(V > 1000) {
                return ;
            } else {
                for(int i=1; i<= n; i++){
                    if(ch[i] == 0 && graph[V][i] == 1){
                        ch[i] = 1;
                        DFS_Solution(i);
                    }
                }
            }
        }
        public static void BFS_Solution(int startNode) {
            Queue<Integer> q = new LinkedList<>();
            ch[startNode] = 1;
            q.offer(startNode);
            // 시작값 넣기
            bfsAnswerInfo.add(startNode);
            while(!q.isEmpty()){
                int val = q.poll();
                for(int i=1; i<graph[val].length; i++){
                    if(ch[i] == 0  && graph[val][i] == 1){
                        ch[i] =1;
                        q.offer(i);
                        bfsAnswerInfo.add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        // 정점 수
        n = sc.nextInt();
        // 간선 수
        m = sc.nextInt();
        int startNode = sc.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n + 1];
        for (int j = 0; j < m; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 연결정보 저장
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        ch[startNode] = 1;
        T.DFS_Solution(startNode);
        for(int i=0; i < dfsAnswerInfo.size(); i++){
            System.out.print(dfsAnswerInfo.get(i) + " ");
        }
        System.out.println();
        Arrays.fill(ch,0);
        T.BFS_Solution(startNode);

        for(int i=0; i < bfsAnswerInfo.size(); i++){
            System.out.print(bfsAnswerInfo.get(i) + " ");
        }
    }
}
