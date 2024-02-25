package com.pass.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 혼자서하는틱택토_160585 {

    static int[] xArray = {-1, 0, 1, 0, 1, -1, 1, -1};
    static int[] yArray = {0, 1, 0, -1, 1, -1, -1, 1};
    static boolean[][] visited = new boolean[3][3];
    static int[][] map = new int[3][3];
    static int[][] targetMap = new int[3][3];
    static int oCount = 0;
    static int xCount = 0;

    public static void main(String[] args) {
        String[] board = {"OXO", ".OX", "OXX"};
        solution(board);
    }

    private static int solution(String[] board) {
        // 제한사항 1) -> board 와 board[i]의 길이는 3
        for (int i = 0; i < 3; i++) {
            String row = board[i];
            for (int j = 0; j < 3; j++) {
                char c = row.charAt(j);
                // 편의를 위해 0는 0 X는 1 .은 -1로 처리
                if (c == 'O') {
                    map[i][j] = 0;
                    oCount++;
                } else if (c == 'X') {
                    map[i][j] = 1;
                    xCount++;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] != -1) {
                    bfs(i, j);
                }
            }
        }

        int max = 0;
        int min = 0;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                max = Math.max(targetMap[m][n], max);
                min = Math.min(targetMap[m][n], min);
            }
        }

        // 0의 개수 < X의 개수
        if (oCount  < xCount  ) {
            return 0;
        } else if (oCount >= xCount + 1) { //0의 개수 > X의 개수 +1
            return 0;
        } else if (min == -3 && oCount != xCount) {
            return 0;
        } else if (max == 3 && (oCount != xCount +1)) {
            return 0;
        } else if (max == 3 && min == -3) {
            return 0;
        } else if (max - Math.abs(min) > 2) {
            return 0;
        }
        return 1;
    }

    private static void bfs(int i, int j) {
        // 시작지점
        Queue<int[]> myQ = new LinkedList<>();
        myQ.offer(new int[]{i, j, -100});

        // 방문처리
        visited[i][j] = true;
        targetMap[i][j] = (map[i][j] == 0) ? 1 : -1;

        while (!myQ.isEmpty()) {
            int[] current = myQ.poll();
            int currentX = current[0];
            int currentY = current[1];
            for (int k = 0; k < 8; k++) {
                int movedX = currentX + xArray[k];
                int movedY = currentY + yArray[k];
                // validate map range
                // 방문하지 않았고 . 은 무시
                if (movedX >= 0 && movedY >= 0 && movedX < 3 && movedY < 3) {
                    // 같은 값임
                    if (map[movedX][movedY] == map[currentX][currentY]) {
                        // 같은 값 범위로 처리
                        if (current[2] == -100 || current[2] == k) {
                            myQ.offer(new int[]{movedX, movedY, k});
                            targetMap[movedX][movedY] = (map[currentX][currentY] == 0) ? targetMap[currentX][currentY] + 1 : Math.min(targetMap[movedX][movedY],targetMap[currentX][currentY] - 1);
                        }
                    }
                }
            }
        }
    }
}
