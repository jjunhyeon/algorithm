package com.pass.boj.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미네랄_2933 {
    static int row, col, count;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> myQ = new LinkedList<>();
    static int[] xArray = {-1, 0, 1, 0};
    static int[] yArray = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String param = bf.readLine();
            for (int j = 0; j < col; j++) {
                char c = param.charAt(j);
                // 0은 맨땅 1은 미네랄
                map[i][j] = (c == '.') ? 0 : 1;
            }
        }

        count = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < count; i++) {
            // 미네랄 부수기
            destroyMineral(row - Integer.parseInt(st.nextToken()), i);
            // 클러스터 부수기
            destroyCluster();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                sb.append(map[i][j] == 0 ? "." : "x");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void destroyCluster() {
        visited = new boolean[row][col];
        ArrayList<int[]> cluster = new ArrayList<>();
        
        // 땅에 있는 미네랄에 대한 클러스터 처리
        for(int i=0; i< col; i++){
            // 방문했거나 맨땅은 스킵
            if(map[row-1][i] == 0 || visited[row-1][i]) continue;

            visited[row-1][i] = true;
            myQ.add(new int[]{row-1,i});

            while(!myQ.isEmpty()){
                int[] cur = myQ.poll();
                for(int j=0; j<4; j++){
                    int movedX =  cur[0] + xArray[j];
                    int movedY =  cur[1] + yArray[j];
                    // 클러스터 지점 검증
                    if(movedX >=0 && movedY >=0 && movedX < row && movedY < col && !visited[movedX][movedY] && map[movedX][movedY] == 1) {
                        visited[movedX][movedY] = true;
                        myQ.add(new int[]{movedX,movedY});
                    }
                }
            }
        }

        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                // false이면서 미네랄인 지점 -> 공중
                if(!visited[i][j] && map[i][j] ==1){
                    map[i][j] = 0;
                    cluster.add(new int[]{i,j});
                }
            }
        }

        if(cluster.isEmpty()) return;
        
        // 클러스터 내리기
        boolean flag = true;
        while(flag){
            for(int[] item : cluster){
                int nowX = item[0] + 1;
                int nowY = item[1];

                if(!(nowX >=0 && nowY >=0 && nowX < row && nowY < col) || map[nowX][nowY] == 1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int[] item : cluster){
                    item[0]++;
                }
            }
        }

        for(int[] item : cluster){
            map[item[0]][item[1]] = 1;
        }

    }

    // 전달받은 파라미터의 ROW의 미네랄을 파괴한다.
    private static void destroyMineral(int num, int direction) {
        // 왼쪽 공격
        if (direction % 2 == 0) {
            for (int i = 0; i < col; i++) {
                if (map[num][i] == 1) {
                    map[num][i] = 0;
                    break;
                }
            }
        } else { // 오른쪽 공격
            for (int i = col - 1; i >= 0; i--) {
                if (map[num][i] == 1) {
                    map[num][i] = 0;
                    break;
                }
            }
        }
    }
}
