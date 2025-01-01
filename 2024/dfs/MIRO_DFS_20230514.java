package dfs;

import java.util.Scanner;

/*
 * 미로 찾기 DFS 7,7까지 갈 수 있는 모든 방법을 리턴해보자
 * DFS 활용한다.
 * */
public class MIRO_DFS_20230514 {

    static class Main {
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};
        static int[][] board;
        static int result = 0;

        public void DFS(int x, int y) {
            // 종료는 xy가 7,7이 되었을 때이다.
            if (x == 7 && y == 7) {
                result ++;
            } else {
                for (int i = 0; i < 4; i++) {
                    int tx = x + dx[i];
                    int ty = y + dy[i];
                    if (tx >= 1 && tx <= 7 && ty >= 1 && ty <= 7 && board[tx][ty] == 0) {
                        // 방문표시
                        board[tx][ty] = 1;
                        DFS(tx, ty);
                        board[tx][ty] = 0;
                    }
                }
            }
        }

        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            board = new int[8][8];
            for (int i = 1; i <= 7; i++) {
                for (int j = 1; j <= 7; j++) {
                    board[i][j] = kb.nextInt();
                }
            }
            //: 출발점 체크
            board[1][1] = 1;
            T.DFS(1, 1);
            System.out.println("result" + result);
        }
    }
}
