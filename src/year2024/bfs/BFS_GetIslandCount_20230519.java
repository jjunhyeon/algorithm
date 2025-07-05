package src.year2024.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 아일랜드 섬 구하기
 * BFS로 풀기(설명은 DFS로 풀었던 주석 참고)
 * */
public class BFS_GetIslandCount_20230519 {
    static int n; // 초기 입렵 값
    static int[][] island; // 이차원 섬의 정보를 표현하기 위한 배열

    static int result = 0; // 결과 리턴을 위한 변수
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1}; // 대각선 움직임 처리를 위한 x 좌표
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1}; // 대각선 움직임 처리를 위한 y 좌표
    static Queue<Point> Q = new LinkedList<>();
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Main {
        public static void BFS(int ax,int ay) {
            Q.offer(new Point(ax, ay));
            while (!Q.isEmpty()) {
                Point tmp = Q.poll();
                for (int i = 0; i < 8; i++) {
                    int x = tmp.x + dx[i];
                    int y = tmp.y + dy[i];
                    if (x >= 0 && x < n && y >= 0 && y < n && island[x][y] == 1) {
                        island[x][y] = 0;
                        Q.offer(new Point(x, y));
                    }
                }
            }
        }
        public static void solution(int[][] island) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (island[i][j] == 1) {
                        result++;
                        island[i][j] = 0; // 내부에선 움직인 지점에 대한 정보를 처리하므로 시작지점은 동작 이전에 0,0으로 처리한다.
                        BFS(i,j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        island = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = kb.nextInt();
            }
        }
        T.solution(island);
        System.out.println(result);
    }
}
