package com.pass.programmers;

import java.util.*;

public class 방문길이_49994 {
    private static int[] dy = new int[] {-1, 1, 0, 0};
    private static int[] dx = new int[] {0, 0, 1, -1};

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        solution(dirs);
    }

    private static void solution(String dirs) {
        // map은 5 X 5 고정
        int[][] map = new int[5][5];

        // 방문한 길의 좌표를 저장할 Set
        Set<String> visited = new HashSet<>();

        // 현재 위치
        // 다시 고민해보자
        // FIXME
        int nowX = 0, nowy = 0;
        int prevX = 0, prevY = 0;
        int maxLen = 1;
        for(char c : dirs.toCharArray()){
            prevX = nowX;
            prevY = nowy;
            Place nextMove = new Place(0,0);
            switch(c){
                case 'U':
                    nextMove = new Place(0,1);
                    break;
                case 'D':
                    nextMove = new Place(0,-1);
                    break;
                case 'L':
                    nextMove = new Place(-1,0);
                    break;
                case 'R':
                    nextMove = new Place(1,0);
                    break;
            }

            int nextX = prevX + nextMove.x;
            int nextY = prevY + nextMove.y;

            if(nextX >= -5 && nextY >= -5 && nextX <= 5 && nextY <= 5){
                // 이전 좌표와 현재 좌표로 이동한 길의 표시
                //String path = "" + prevX + prevY + x + y;
                //String reversePath = "" + x + y + prevX + prevY;

//                if (!visited.contains(path) && !visited.contains(reversePath)) {
//                    visited.add(path);
//                    visited.add(reversePath);
//                    maxLen++;
//                }
            }
        }
        System.out.println("maxLen::" + maxLen);
    }

    public static class Place{
        int x;
        int y;
        Place(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
