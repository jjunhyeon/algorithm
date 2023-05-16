package com.pass.algostudy.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 토마토 문제
 * 앞에 푼 미로문제와 유사한 문제이다
 * 1 : 익은 토마토
 * 0 : 익지 않는 토마토
 * -1 : 토마토가 들어가 있지 않는 칸
 * 익은 토마토의 인접한 곳에 있는 익지 않는 토마토들은 익은 토마토의 영향을 받아 익게된다.
 * 모두 익을때까지의 최소 날짜를 출력해보자.
 * */
public class Tomato_20230516 {

    static class Mato {
        private int x, y;
        Mato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int[][] tomato;
    static int[][] dis;
    static int result = 0;
    static Queue<Mato> Q = new LinkedList<>();

    static class Main {
        public static void BFS(int x, int y) {
            while (!Q.isEmpty()) {
                Mato tmp = Q.poll();
                for (int i = 0; i < 4; i++) {
                    // tmp.x -> q에 들어있는 1,1 지점의 tomato 좌표의 x값
                    // tmp.y -> q에 들어있는
                    int xm = tmp.x + xMove[i];
                    int ym = tmp.y + yMove[i];
                    // 익은 토마토 근접의 토마토가 익지 않은 상태라면
                    if (xm >= 0 && xm < x && ym >= 0 && ym < y && tomato[xm][ym] == 0) {
                        // 가장 오래 걸리기 위해 만든 dis 이차원 배열에 날짜 식별을 위해 +1 을 해서 처리한다.
                        tomato[xm][ym] = 1;
                        Q.offer(new Mato(xm, ym));
                        dis[xm][ym] = dis[tmp.x][tmp.y]+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        // 6행 4열의 이차원 배열
        int y = kb.nextInt();
        int x = kb.nextInt();
        tomato = new int[x][y];
        dis = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tomato[i][j] = kb.nextInt();
                if (tomato[i][j] == 1) {
                    Q.offer(new Mato(i, j));
                }
            }
        }

        T.BFS(x, y);
        boolean flag = true;
        // 종료조건
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // 0 익지 않은 토마토가 있다면
                if (tomato[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    result = Math.max(result, dis[i][j]);
                }
            }
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
