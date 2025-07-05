import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] xMove = new int[]{-1, 0, 1, 0};
    static int[] yMove = new int[]{0, 1, 0, -1};
    static int col = 0;
    static int row = 0;
    static int[][] islandMap;

    static class Point {
        // x,y 좌표
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 public static int BFS(int x, int y) {

        Queue<Point> pq = new LinkedList<>();
        pq.offer(new Point(x, y));

        int result = islandMap[x][y];

        while (!pq.isEmpty()) {
            Point target = pq.poll();
            int nowX = target.x;
            int nowY = target.y;
            for (int i = 0; i < 4; i++) {
                int movedX = nowX + xMove[i];
                int movedY = nowY + yMove[i];
                // 정상 범위의 경로와 방문하지 않은 지점일때만
                if (movedX >= 0 && movedX < col && movedY >= 0 && movedY < row && !visited[movedX][movedY] && islandMap[movedX][movedY] != 0) {
                    visited[movedX][movedY] = true;
                    pq.offer(new Point(movedX, movedY));
                    result += islandMap[movedX][movedY];
                }
            }
        }
        return result;
    }    
public static ArrayList<Integer> solution(String[] maps) {
        // 일차원 배열 TO 이차원배열로 바꾼다.
        // 파라미터를 이차원 배열로 수정한다. 이후 bfs에서 처리하기 편하게 위함

        ArrayList<Integer> answer = new ArrayList<>();
        col = maps.length;
        row = maps[0].length();

        islandMap = new int[col][row];
        visited = new boolean[col][row];
    
        boolean flag = false;
    
        for (int i = 0; i < col; i++) {
            String strRow = maps[i];
            for (int j = 0; j < row; j++) {
                if (strRow.charAt(j) == 'X') {
                    islandMap[i][j] = 0;
                } else {
                    flag = true;
                    islandMap[i][j] = Integer.parseInt(String.valueOf(strRow.charAt(j)));
                }
            }
        }
    
        if(!flag){
            answer.add(-1);
            return answer;
        }

        // 다 넣은후에 시작해야함
        for (int i = 0; i < col; i++) {
            int idx = 0;
            for (int j = 0; j < row; j++) {
                // 0이 아닌지점에서 시작한다.
                if (islandMap[i][j] != 0 && !visited[i][j]) {
                    // 현재 위치는 방문 한걸로 업뎃하고 시작
                    visited[i][j] = true;
                    int sum = BFS(i, j);
                    if (sum == 0) {
                        answer.add(1);
                    } else {
                        answer.add(sum);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}