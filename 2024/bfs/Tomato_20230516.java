package bfs;

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
    static int column,row;
    static int[][] tomato; // 토마토의 정보
    static int[][] dis; // 토마토의 정보를 바탕으로 [][] 를 채워나갈 떄 사용할 배열
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point> Q = new LinkedList<>();

    static class Point{
        private int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Main{
        public static void DFS(){
            // 이미 큐에 1,1 포인트 지점의 정보가 담겨 있음
            while(!Q.isEmpty()){
                Point tmp = Q.poll();
                for(int i=0; i<4; i++){
                    int xPoint = tmp.x + dx[i];
                    int yPoint = tmp.y + dy[i];
                    if(xPoint >= 0 && xPoint < column && yPoint >=0 && yPoint < row && tomato[xPoint][yPoint] == 0){
                        tomato[xPoint][yPoint] = 1;
                        Q.offer(new Point(xPoint,yPoint));
                        //  day 구분을 위해 새 배열 dis에서 +1 처리를 한다.
                        dis[xPoint][yPoint] = dis[tmp.x][tmp.y] + 1;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        row = kb.nextInt();
        column =  kb.nextInt();

        tomato = new int[column][row];
        dis = new int[column][row];
        for(int i=0; i<column; i++){
            for(int j=0; j<row; j++){
                tomato[i][j] = kb.nextInt();
                // i,j가 1일 시 미리 큐에 담아 놓는다.
                if(tomato[i][j] == 1){
                    Q.offer(new Point(i,j));
                }
            }
        }
        T.DFS();
        // flag
        boolean flag = true;
        int result = Integer.MIN_VALUE;
        for(int i=0; i<column; i++){
            for(int j=0; j<row; j++){
                if(tomato[i][j] == 0 ){
                    flag = false;
                }
            }
        }

        if(flag){
            for(int i=0; i<column; i++){
                for(int j=0; j<row; j++){
                    result = Math.max(result, dis[i][j]);
                }
            }
        } else{
            result = -1;
        }
        System.out.println(result);
    }
}
