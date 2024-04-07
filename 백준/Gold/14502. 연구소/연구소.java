import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] map;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int[][] copyMap;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        copyMap = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < col; j++) {
                // 0 : 디폴트 공간
                // 1 : 벽
                // 2 : 바이러스
                copyMap[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dfs & bfs start.. ->
        boolean[][] visited = new boolean[row][col];
        dfs(0, visited);

        System.out.println(answer);
    }

    // row, col 시작 지점 정보
    private static void dfs(int count, boolean[][] visited) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    copyMap[i][j] = 1;
                    visited[i][j] = true;
                    dfs(count + 1, visited);
                    visited[i][j] = false;
                    copyMap[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> myQ = new LinkedList<>();
        int[][] newMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMap[i][j] = copyMap[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 바이러스
                if (newMap[i][j] == 2) {
                    myQ.offer(new int[]{i, j});
                }
            }
        }

        while (!myQ.isEmpty()) {
            int[] cur = myQ.poll();
            int nowX = cur[0];
            int nowY = cur[1];
            for (int i = 0; i < 4; i++) {
                int moveX = nowX + xMove[i];
                int moveY = nowY + yMove[i];
                if (moveX >= 0 && moveX < row && moveY >= 0 && moveY < col) {
                    // 감염
                    if (newMap[moveX][moveY] == 0) {
                        newMap[moveX][moveY] = 2;
                        myQ.offer(new int[]{moveX, moveY});
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (newMap[i][j] == 0) sum++;
            }
        }

        answer = Math.max(answer, sum);
    }
}
