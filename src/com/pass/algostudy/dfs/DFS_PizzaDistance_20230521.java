package com.pass.algostudy.dfs;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * N×N 크기의 도시지도에서
 * 0은 빈칸, 1은 집, 2는 피자집으로 표현된다.
 * 도시에는 각 집 마다 '피자배달거리'가 있는데 각 집의 피자 배달거리는 해당 집과 도시에
 * 존재하는 피자집들과의 거리 중 최소값을 해당 집의 '피자배달거리'라고 한다.
 * 피자배달거리|x1-x2|+|y1-y2|
 *
 * 최소 피자집만 두고 나머지 피자집을 폐업시키려고 할 때 도시의 피자배달거리가 최소가 되는
 * M개의 피자집을 선택했을때의 피자배달거리를 구하자.
 * 1. 입렵값 : N M  (N : 도시의 가로세로, M 남는 피자집의 수)
 * 2. 이차원배열을 돌면서 M개의 피자집이 선택된 XCM의 케이스로 이차원배열을 구성한다,
 * 3. XCM 케이스 중 하나의 지도의 케이스일 경우의 맵의 피자 배덜거리를 DIS에 그린다.
 * 4. DIS의 result에 저장하고 가장 작은 값을 리턴한다
 *
 * */
public class DFS_PizzaDistance_20230521 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs; //hs : 일반집 , pz : 피자집
    static class Main {
        // 조합 경우의수 구하는건 외워
        // int L : 시작지점(array 0부터 시작했음)
        public void DFS(int L, int s) {
            if (L == m) { // m개의 케이스를 구했을때의 경우 xCm에서 m의 값
                // 하나의 조합에 따른 계산
                int sum = 0;
                for (Point h : hs) {
                    int dis = Integer.MAX_VALUE;
                    for (int i : combi) {
                        // dis 집의 배달거리
                        // 피자배달거리 |x1-x2|+|y1-y2|
                        dis = Math.min(dis, Math.abs(h.x-pz.get(i).x) + Math.abs(h.y-pz.get(i).y));
                    }
                    sum += dis;
                }
                answer = Math.min(sum, answer);
            } else {
                // 피자집 len에서 m개 뽑기
                for (int i = s; i < len; i++) {
                    combi[L] = i;
                    DFS(L + 1, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) {
                    hs.add(new Point(i, j));
                } else if (tmp == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }
        len = pz.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
