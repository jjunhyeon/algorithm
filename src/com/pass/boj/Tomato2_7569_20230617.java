package com.pass.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        int x, y;

        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int resultDay = Integer.MIN_VALUE;
    // 토마토 2차원 배열 정보
    static int[][] matoInfo;
    static Queue<Tomato> qt = new LinkedList<>();
    // 최소 날짜를 구하기 위한 토마토정보 카피 이차원배열
    //static int[][] distanceMato;
    static int M = 0;
    static int N = 0;
    static int H = 0;

    // 상하좌우 + (앞,뒤) 추가해야함.
    public static ArrayList<Integer> xArray = new ArrayList<>(Arrays.asList(-1, 0, 1, 0));
    public static ArrayList<Integer> yArray = new ArrayList<>(Arrays.asList(0, 1, 0, -1, 0, 0));

    public static void main(String[] args) throws IOException {
        // 입력값 처리
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        // 첫 줄 입력값 (상자의 크기 M * N )  *  상자의 수 H
        String[] info = br.readLine().split(" ");
        M = Integer.parseInt(info[0]); // 컬럼
        N = Integer.parseInt(info[1]); // 컬럼
        H = Integer.parseInt(info[2]); // * 높이 정보

        // 배열에 앞 뒤 정보를 탐색하기 위한 앞뒤(행 정보)를 추가한다.
        xArray.add(N);
        xArray.add(-N);

        matoInfo = new int[N * H][M]; // 행 * 높이 , 열 정보로 2차원 배열 생성
        //distanceMato = new int[N * H][M];
        // 두번째줄부터는 상자에 대한 Value 정보
        for (int i = 0; i < N * H; i++) {
            String[] rowMato = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                // 0 = 익지 않는 토마토, 1 = 익은 토마토 , -1 = 토마토가 들어있지 않음
                matoInfo[i][j] = Integer.parseInt(rowMato[j]);
                if (matoInfo[i][j] == 1) {
                    qt.offer(new Tomato(i, j));
                }
            }
        }
        // 다 넣은 후 bfs 시작
        System.out.println((TomatoBFS()));
        br.close();
    }

    public static int TomatoBFS() {
        while (!qt.isEmpty()) {
            Tomato targetT = qt.poll();
            int tx = targetT.x;
            int ty = targetT.y;
            for (int i = 0; i < 6; i++) {
                int nearX = tx + xArray.get(i);
                int nearY = ty + yArray.get(i);

                // 정상 범위의 값 + 탐색하는 위치의 토마토가 감염되지 않았다면
                if (nearX >= 0 && nearX < N * H && nearY >= 0 && nearY < M && matoInfo[nearX][nearY] == 0) {
                    matoInfo[nearX][nearY] = 1;
                    qt.offer(new Tomato(nearX, nearY));
                    matoInfo[nearX][nearY] = matoInfo[tx][ty] + 1;
                }
            }
        }

        // Array의 최대값을 구해야함.
        for (int i = 0; i < N * H; i++) {
            for (int j = 0; j < M; j++) {
                if (matoInfo[i][j] == 0) {
                    return -1;
                }
                resultDay = Math.max(matoInfo[i][j], resultDay);
            }
        }
        if (resultDay == 1) {
            return 0;
        } else {
            return resultDay - 1;
        }
    }
}
