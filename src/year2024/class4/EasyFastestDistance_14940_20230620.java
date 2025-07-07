package year2024.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* 쉬운 최단거리(BFS)
* 지도 주어지면 모든 지점에 대해서 목표지점까지의 거리 구한다.
* */
public class EasyFastestDistance_14940_20230620 {
    static class MyMap{
        int x,y;
        MyMap(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R ; // 열
    static int C ; // 행
    static int[][] map;
    static int[][] dis;
    static boolean[][] isVisited;
    static final int[] xMove = {-1,0,1,0};
    static final int[] yMove = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bf.readLine().split(" ");

        C = Integer.parseInt(size[0]);
        R = Integer.parseInt(size[1]);

        map = new int[C][R];
        dis = new int[C][R];
        isVisited = new boolean[C][R];
        int startX = -1, startY = -1;
        for(int i=0; i<C; i++){
            map[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<R; j++){
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        BFS(startX,startY);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                if (!isVisited[i][j] && map[i][j] == 1) {
                    sb.append(-1 + " ");
                }
                else {
                    sb.append(dis[i][j] + " ");
                }
            } sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int x , int y) {
        Queue<MyMap> qm = new LinkedList<>();
        qm.offer(new MyMap(x,y));
        isVisited[x][y] = true;

        while(!qm.isEmpty()){
            MyMap place = qm.poll();
            int tx = place.x;
            int ty = place.y;
            for(int i=0; i < 4; i++){
                int movedX = tx + xMove[i];
                int movedY = ty + yMove[i];
                // 정상범위값 + 움직일 곳이 갈 수 있다면~!
                if(movedX < 0 || movedX >= C || movedY < 0 || movedY >= R) continue;
                if(map[movedX][movedY] == 0 || isVisited[movedX][movedY]) continue;
                isVisited[movedX][movedY] = true;
                qm.offer(new MyMap(movedX, movedY));
                dis[movedX][movedY] = dis[tx][ty] + 1;
            }
        }
    }
}
