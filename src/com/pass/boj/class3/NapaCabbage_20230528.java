package com.pass.boj.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 배추 (BFS문제)
 * 앞서 풀었던 토마토 유형의 문제와 거의 비슷하다.
 * */
public class NapaCabbage_20230528 {
    static int row; // 가로
    static int col; // 열
    static int point; // 배추의 수
    static int[][] arr; // 배추 맵
    static int[] xBase = {-1, 0, 1, 0}; // 배추 주변 탐색을 위한 X 좌표
    static int[] yBase = {0, 1, 0, -1}; // 배추 주변 탐색을 위한 Y 좌표
    static int[] result; // 정답
    static class Matrix { // 배추 주변 탐색을 위해 Queue<T>에 사용할 Matrix Class
        int x, y;
        Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Test {
        public static void BFS(int x, int y) {
            Queue<Matrix> Q = new LinkedList<>();
            // Queue를 사용하는 이유는 BFS 탐색을 하며 FIFO 순서를 따른다는 점과 인접한 노드를 먼저 방문하는 탐색 방법에 적합한 자료구조이기 때문이다.
            Q.offer(new Matrix(x,y));

            while(!Q.isEmpty()){
                Matrix target = Q.poll(); // 초기 지렁이의 위치 값을 Q에서 가져온다.
                for(int i=0; i<4; i++){ // 상하좌우 4방향 탐색을 하기 위한 for
                    int tx = target.x + xBase[i];  // target x지점
                    int ty = target.y + yBase[i];  // target y지점
                    if(tx >= 0 && tx < col && ty >=0 && ty < row && arr[tx][ty] == 1){ // 맵 위에서 움직이기 위해서 그리고 인접노드에 배추가 있는지 확인한다.
                        arr[tx][ty] =0; // 방문했으므로 해당 지점을 0으로 업데이트 하고 Q에 해당 지점 주변 탐색을 위해 Q에 넣는다.
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
