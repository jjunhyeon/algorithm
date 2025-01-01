package com.pass.algostudy.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *  최단거리 미로찾기 문제
 *  끝 지점 7,7에 갈 수 있는 최단거리를 찾는 문제
 *  BFS는 Q
 *  이 문제에 BFS를 사용하는 이유?
 * 1. BFS는 너비를 우선적으로 탐색하기때문에 최단거리르 보장한다.
 * 2. 큐를 활용하여 탐색 순서를 관리하고 먼저 들어온 노드부터 처리하며 진행하기 때문에 최단거리를 찾는 문제에 적합하다.
 * 3. 모든 경로 탐색 : BFS는 너비 우선 탐색하기 때문에 최단 거리 이내에 있는 모든 노드들을 탐색할 수 있다.
 * */
public class MIRO_BFS_20230514 {
    static class Point{
        public int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static class Main {
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};
        static int[][] board, dis;

        public void BFS(int x, int y) {
            Queue<Point> Q = new LinkedList<>();
            // 초기값 insert
            Q.offer(new Point(x,y));
            board[x][y] = 1; // 방문 지점 체크
            while(!Q.isEmpty()){
                Point tmp = Q.poll();
                for(int i=0; i<4; i++){
                    int tx = tmp.x + dx[i];
                    int ty = tmp.y + dy[i];
                    if(tx >= 1 && tx <=7 && ty >=1 && ty <=7 && board[tx][ty] == 0){
                        board[tx][ty] =1;
                        Q.offer(new Point(tx,ty));
                        // tmp.x, tmp.y : 현재지점 +1
                        // dis에 경로까지는 최단거리의 정보를 그린다.
                        dis[tx][ty] = dis[tmp.x][tmp.y] + 1;
                    }
                }
            }
        }

        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            board = new int[8][8];
            dis = new int[8][8];
            for (int i = 1; i <= 7; i++) {
                for (int j = 1; j <= 7; j++) {
                    board[i][j] = kb.nextInt();
                }
            }

            T.BFS(1, 1);
            if (dis[7][7] == 0) {
                System.out.println(-1);
            } else {
                System.out.println(dis[7][7]);
            }
        }
    }
}
