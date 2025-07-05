import java.util.*;
class Solution {
    
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
        
    public int solution(String[] board) {

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
       return bfs(startX, startY, targetX, targetY);
    }
    
    private int bfs(int startX, int startY, int targetX, int targetY) {

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

                while(movedX >= 0 && movedX < N && movedY >= 0 && movedY < M && map[movedX][movedY] != 1){
                    movedX += xRange[i];
                    movedY += yRange[i];
                }

                movedX -= xRange[i];
                movedY -= yRange[i];
                // 가장 끝지점을 offer 해야함
                // up
                if(visited[movedX][movedY] || (movedX == nowX && movedY == nowY)){
                    continue;
                }

                visited[movedX][movedY] = true;
                dis[movedX][movedY] = dis[nowX][nowY] + 1;
                myQ.add(new Node(movedX,movedY));
            }
        }

        return -1;
    }
}