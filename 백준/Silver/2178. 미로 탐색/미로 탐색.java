
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int col,row;
    static int[][] map, dis;  // 미로 맵,최소 경로를 찾기 위해 새로 그리는 맵
    static int[] xBase = {-1, 0, 1, 0}; // 미로 탐색을 위한 X 좌표
    static int[] yBase = {0, 1, 0, -1}; // 미로 탐색을 위한 Y 좌표
    public static class Matrix { // 미로 주변 탐색을 위해 Queue<T>에 사용할 Matrix Class
        int x, y;
        Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Test {
        public static void BFS(int x, int y) {
            Queue<Matrix> mq = new LinkedList<>();
            map[y][x] = 0; // 초기 방문
            mq.offer(new Matrix(x, y));
            while (!mq.isEmpty()) {
                Matrix tmp = mq.poll();
                for (int i = 0; i < 4; i++) {
                    int tx = tmp.x + xBase[i];
                    int ty = tmp.y + yBase[i];
                    if (tx >= 0 && tx < col && ty >= 0 && ty < row && map[tx][ty] == 1) {
                        map[tx][ty] = 0; // 방문한 지점은 0으로 바꾸꼬
                        mq.offer(new Matrix(tx, ty));
                        dis[tx][ty] = dis[tmp.x][tmp.y] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Test T = new Test();
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(kb.readLine());

        col = Integer.parseInt(st.nextToken()); // 세로
        row = Integer.parseInt(st.nextToken()); // 가로
        map = new int[col][row];
        dis = new int[col][row];
        for (int i = 0; i < col; i++) {
            String x = kb.readLine();
            int[] inputArr = new int[x.length()];
            for(int j=0; j<inputArr.length; j++){
                char ch = x.charAt(j);
                map[i][j] = Character.getNumericValue(ch);
            }
        }
        T.BFS(0, 0);
        System.out.println(dis[col-1][row-1] + 1);
    }
}
