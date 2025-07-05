

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 배추
 * */
public class Main {
    static int row;
    static int col;
    static int point;
    static int[][] arr;
    static int[] xBase = {-1, 0, 1, 0};
    static int[] yBase = {0, 1, 0, -1};
    static int[] result;
    static class Matrix {
        int x, y;
        Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Test {
        public static void BFS(int x, int y) {
            Queue<Matrix> Q = new LinkedList<>();
            Q.offer(new Matrix(x,y));

            while(!Q.isEmpty()){
                Matrix target = Q.poll();
                for(int i=0; i<4; i++){
                    int tx = target.x + xBase[i];
                    int ty = target.y + yBase[i];
                    if(tx >= 0 && tx < col && ty >=0 && ty < row && arr[tx][ty] == 1){
                        arr[tx][ty] =0;
                        Q.offer(new Matrix(tx,ty));
                    }
                }
            }
        }

        public void solution(int num) {
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (arr[i][j] == 1) {
                        // 지렁이 개수 +1
                        result[num]++;
                        BFS(i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Test T = new Test();
        Scanner kb = new Scanner(System.in);

        int testCount = kb.nextInt();
        result = new int[testCount];
        // 테스트 수 만큼
        for (int i = 0; i < testCount; i++) {
            col = kb.nextInt();
            row = kb.nextInt();
            point = kb.nextInt();
            arr = new int[col][row];
            for(int j=0; j<point; j++) {
                int x = kb.nextInt();
                int y = kb.nextInt();
                arr[x][y] = 1;
            }
            T.solution(i);
        }

        for(int a =0; a<testCount; a++){
            System.out.println(result[a]);
        }
    }
}
