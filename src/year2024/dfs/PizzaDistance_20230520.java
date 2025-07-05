package src.year2024.dfs;

import java.util.ArrayList;
import java.util.Scanner;
/*
* 피자집 최소거리 (다시풀기 완료)
* */
public class PizzaDistance_20230520 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, length = Integer.MAX_VALUE;
    static int result = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, ho;

    static class Main {
        public void DFS(int L, int sum) {
            // 깊이가 끝에 도달했다면
            if (L == m) {
                int add = 0;
                // 각 집들을 탐색
                for(int h=0; h<ho.size(); h++){
                    int dis = Integer.MAX_VALUE;
                    for (int i : combi) {
                        // 피자배달거리 |x1-x2|+|y1-y2|
                        dis = Math.min(dis, Math.abs(ho.get(h).x-pz.get(i).x) + Math.abs(ho.get(h).y-pz.get(i).y));
                    }
                    add += dis;
                }
                result = Math.min(add,result);
            } else {
                // 순열 만들기
                // start 4 , length 6 (6C4)
                for (int i = sum; i < length; i++) {
                    combi[L] = i;
                    DFS(L + 1, i + 1);
                }
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        // NCM 에서 X값 뒷 컴비네이션 값
        m = kb.nextInt();
        combi = new int[m];
        pz = new ArrayList<>();
        ho = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) {// 집
                    ho.add(new Point(i, j));
                } else if (tmp == 2) { // 피자집
                    pz.add(new Point(i, j));
                }
            }
        }
        length = pz.size();
        T.DFS(0, 0);
        System.out.println(result);
    }
}
