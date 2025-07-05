package src.year2024.class4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 케빈 베이컨의 6단계 인싸들의 법칙
* */
public class Kevin6Rule_1389_2030611 {
    static int result = Integer.MAX_VALUE;
    static int pNumber = 0;
    static int[][] relationShip;
    static int[] visited,dis;
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       // 사람의 수
       int node = sc.nextInt();
       visited = new int[node+1];
       dis = new int[node+1];
       // 관계의 수
       int rCount = sc.nextInt();
       relationShip = new int[node+1][node+1];
       for(int i=1; i<=rCount; i++){
           int a = sc.nextInt();
           int b = sc.nextInt();
           relationShip[a][b] = 1; // 친구관계 연결
           relationShip[b][a] = 1;
       }

        for(int i=1; i<=node; i++){
            int sum =0;
            solution(i);
            for(int j=1; j<=node; j++){
                sum += dis[j];
            }
            if(result > sum){
                result = Math.min(result,sum);
                pNumber = i;
            }
        }
        System.out.println(pNumber);
    }

    private static void solution(int V) {
        Queue<Integer> Q = new LinkedList<>();
        Arrays.fill(visited,0);
        Arrays.fill(dis,0);
        visited[V] = 1;
        dis[V] = 0;
        Q.offer(V);
        while(!Q.isEmpty()){
            int tg = Q.poll();
            for(int i=1; i<relationShip[tg].length; i++){
                if(visited[i] == 0 && relationShip[tg][i] == 1){ // 경로가 이어져 있고, 아직 방문하지 않았다면
                    visited[i] = 1; // 방문했음으로 업데이트
                    Q.offer(i);  // 그 다음 탐색해야하므로 Q에 Offer
                    dis[i] = dis[tg] +1; // i까지의 노드 거리를 구해야하므로 이전 거리의 +1 값으로 업데이트한다.
                }
            }
        }
    }
}
