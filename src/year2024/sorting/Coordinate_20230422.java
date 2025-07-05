package src.year2024.sorting;

import java.util.*;

/*
* 좌표 정렬
* X 좌표 , Y좌표 순서대로 정렬한 결과를 리턴하는 프로그램 개발
*
* */
public class Coordinate_20230422 {
    static class Main {
        public void solution(int n,  int[][] array) {

            ArrayList<Point> arr = new ArrayList<Point>();

            for(int i=0; i<n; i++){
                arr.add(new Point(array[i][0],array[i][1]));
            }
            Collections.sort(arr);

            for (Point o : arr) {
                System.out.println(o.x + " " + o.y);
            }
        }

        class Point implements Comparable<Point>{
            public int x, y;
            Point(int x, int y){
                this.x =x;
                this.y =y;
            }

            @Override
            public int compareTo(Point o) {
                if(this.x == o.x){
                    return this.y - o.y;
                }
                return this.x- o.x;
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[][] cor = new int[n][2];
        for(int i=0; i< n; i++) {
            cor[i][0] = kb.nextInt();
            cor[i][1] = kb.nextInt();
        }

        T.solution(n, cor);
    }
}
