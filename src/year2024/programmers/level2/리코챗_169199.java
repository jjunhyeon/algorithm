package year2024.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * bfs
 * */
public class 리코챗_169199 {

    public static int[] xRange = {-1, 0, 1, 0};
    public static int[] yRange = {0, 1, 0, -1};
    public static boolean[][] visited;
    public static int[][] map;
    public static int[][] dis;
    public static int N, M;

    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        //String[] board = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board2 = new String[]{".D.R", "....", ".G..", "...D"};
        System.out.println("wha tis the answer+ zz" + solution(board2));
    }

    public static int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();

        // String[] -> iut[][] array
        map = new int[N][M];
        visited = new boolean[N][M];
        dis = new int[N][M];

        int startX = 0;
        int startY = 0;

        int targetX = 0;
        int targetY = 0;

        for (int i = 0; i < N; i++) {
            String row = board[i];
            for (int j = 0; j < M; j++) {
                char ch = row.charAt(j);
                // D,G,R
                if (ch == 'R') { // START
                    startX = i;
                    startY = j;
                } else if (ch == 'G') { // GOAL
                    targetX = i;
                    targetY = j;
                } else if (ch == 'D') { // 장애물 지점
                    map[i][j] = 1;
                }
            }
        }
        answer = bfs(startX, startY, targetX, targetY);
        return answer;
    }

    /*
     * start -> target 찾기 bfs
     * */
    private static int bfs(int startX, int startY, int targetX, int targetY) {

        Queue<Node> myQ = new LinkedList();
        myQ.offer(new Node(startX, startY));
        // 시작지점 처리
        visited[startX][startY] = true;

        while (!myQ.isEmpty()) {
            Node nowPlace = myQ.poll();
            int nowX = nowPlace.x;
            int nowY = nowPlace.y;

            // 현재 위치가 정답이면
            if (nowX == targetX && nowY == targetY) {
                return dis[nowX][nowY];
            }

            for (int i = 0; i < 4; i++) {
                int movedX = nowX + xRange[i];
                int movedY = nowY + yRange[i];

                // 마지막 지점까지 보내고
                while (movedX >= 0 && movedX < N && movedY >= 0 && movedY < M && map[movedX][movedY] != 1) {
                    movedX += xRange[i];
                    movedY += yRange[i];
                }

                // 범위 벗어난 순간 다시 원복한 지점으로 복귀
                movedX -= xRange[i];
                movedY -= yRange[i];

                // 원복한 지점이 방문했거나, 이전이랑 똑같다면
                if (visited[movedX][movedY] || (movedX == nowX && movedY == nowY)) {
                    continue;
                }

                visited[movedX][movedY] = true;
                dis[movedX][movedY] = dis[nowX][nowY] + 1;
                myQ.add(new Node(movedX, movedY));
            }
        }

        return -1;
    }
}
