package com.pass.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 백준 7569번 토마토
 * 기존 풀었던 문제랑 요구사항 같음
 * 달라진조건 ) 상하좌우앞뒤 모두 익는 날짜 구하기
 * */
public class Tomato2_7569_20230617 {
    // bfs 탐색 처리를 위한 toamto 클래스 생성
    public static class Tomato {
        int x, y, h;

        Tomato(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static int resultDay = Integer.MIN_VALUE;
    // 토마토 2차원 배열 정보
    static int[][][] matoInfo;
    static Queue<Tomato> qt = new LinkedList<>();

    static int M = 0;
    static int N = 0;
    static int H = 0;

    // 상하좌우 + (앞,뒤) 추가해야함.
    public static int[] xArray = {-1, 0, 1, 0, 0, 0};
    public static int[] yArray = {0, 1, 0, -1, 0, 0};
    public static int[] hArray = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        // 입력값 처리
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        // 첫 줄 입력값 (상자의 크기 M * N )  *  상자의 수 H
        String[] info = br.readLine().split(" ");
        M = Integer.parseInt(info[0]); // 컬럼
        N = Integer.parseInt(info[1]); // 컬럼
        H = Integer.parseInt(info[2]); // * 높이 정보

        matoInfo = new int[N][M][H]; // 행 * 높이 , 열 정보로 2차원 배열 생성
        //distanceMato = new int[N * H][M];
        // 두번째줄부터는 상자에 대한 Value 정보
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                String[] rowMato = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    matoInfo[i][j][k] = Integer.parseInt(rowMato[j]);
                    if (matoInfo[i][j][k] == 1) {
                        qt.offer(new Tomato(i, j, k));
                    }
                }
            }
        }
        // 다 넣은 후 bfs 시작
        System.out.println((TomatoBFS()));
        br.close();
    }

    public static int TomatoBFS() {
        int Height = 1;
        while (!qt.isEmpty()) {
            Tomato targetT = qt.poll();
            int tx = targetT.x;
            int ty = targetT.y;
            int th = targetT.h;
            for (int i = 0; i < 6; i++) {
                int nearX = tx + xArray[i];
                int nearY = ty + yArray[i];
                int nearH = th + hArray[i];
                // 정상 범위의 값 + 탐색하는 위치의 토마토가 감염되지 않았다면
                if (nearX >= 0 && nearX < N * Height && nearY >= 0 && nearY < M && nearH >= 0 && nearH < H
                        && matoInfo[nearX][nearY][nearH] == 0) {
                    matoInfo[nearX][nearY][nearH] = 1;
                    qt.offer(new Tomato(nearX, nearY, nearH));
                    matoInfo[nearX][nearY][nearH] = matoInfo[tx][ty][th] + 1;
                }
            }
        }
        // Array의 최대값을 구해야함
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (matoInfo[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    resultDay = Math.max(matoInfo[i][j][k], resultDay);
                }
            }
        }

        // 최대 값 1 -> 원래 익었음
        if (resultDay == 1) {
            return 0;
        } else {
            return resultDay - 1;
        }
    }
}
