package year2024.dfs;

import java.util.Scanner;

/*
 * 섬나라 아일랜드
 * 1로 표시되어 있으면 연결됨, 0은 바다
 * DFS/ BFS 각각 풀어보기
 * DFS
 * */
public class DFS_GetIslandCount_20230519 {
    static int n; // 초기 입렵 값
    static int[][] island; // 이차원 섬의 정보를 표현하기 위한 배열
    static int result = 0; // 결과 리턴을 위한 변수
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1}; // 대각선 움직임 처리를 위한 x 좌표
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1}; // 대각선 움직임 처리를 위한 y 좌표

    static class Main {
        public static void DFS(int x, int y) {
            // x ,y 입력받은 좌표정보
            for (int i = 0; i < 8; i++) {
                int tx = dx[i] + x; // 움직인 x 좌표
                int ty = dy[i] + y; // 움직인 y 좌표
                if (tx >= 0 && tx < n && ty >= 0 && ty < n && island[tx][ty] == 1) {
                    island[tx][ty] = 0; // 이동한 좌표 지점 정보를 0으로 처리
                    DFS(tx, ty);
                }
            }
        }

        public static void solution(int[][] island) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (island[i][j] == 1) {
                        result++;
                        island[i][j] = 0; // DFS 내부에선 움직인 지점에 대한 정보를 처리하므로 시작지점은 DFS 동작 이전에 0,0으로 처리한다.
                        DFS(i, j);
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
