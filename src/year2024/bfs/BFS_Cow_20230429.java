package year2024.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * BFS(레벨 탐색) 완전 탐색
 * 송아지찾기 - 최단거리 찾기
 *
 * */
public class BFS_Cow_20230429 {
    static class Main {
        // DEPTH 확장 시 설정되는 값 (부모노드 값의 -1, +1, +5 설정)
        int[] dis = {1,-1,5};
        // 탐색 및 검색을 위한 배열
        int[] ch; 
        Queue<Integer> Q = new LinkedList<Integer>();
        public int BFS(int n, int m) {
            // 좌표는 1부터 10000까지 이므로 
            ch = new int[100001];
            // 초기 root 값 설정
            ch[n] = 1;
            // q에 root 값 넣고 시작
            Q.offer(n);
            // LEVEL
            int L = 0;
            // Q가 비어있다 -> 말단노드까지 다 그림
            while(!Q.isEmpty()){
                int len = Q.size();
                for(int i=0; i<len; i++){
                    // 현재 노드의 값을 뽑는다.
                    int val = Q.poll();

                    // 자식노드를 그리는데 위에서 설정한 값 만큼 +,-를 주면서 그려나간다.
                    for(int j=0; j<dis.length; j++){
                        int nx = val + dis[j];
                        // 그려 나갈때 값이 송아지의 위치와 일치한다면 (자식노드를 그리는 시점엔 아직 LEVEL 증가 전이므로)
                        if(nx == m){
                            return L+1;
                        }
                        // nx의 값은 문제에서 0부터 10000까지라했고 ch[nx]가 0이라는건 아직 방문하지 않았단걸 의미
                        if(nx > 0 && nx < 10001 && ch[nx] == 0){
                            ch[nx] =1;
                            Q.offer(nx);
                        }
                    }
                }
                L ++;
            }
            return L;
        }
    }

    public static void main(String args[]) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        System.out.println(T.BFS(n,m));
    }
}
