package com.pass.programmers;

/*
 * 2,2,5,4
 * -> 2행 2열
 * 행렬 회전시키기(다시)
 * */
public class MatrixRotation_20230509 {

    public static void main(String[] args) {
        System.out.println(solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int map[][] = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = (i * columns) + j + 1 ;
            }
        }

        for(int i=0; i< map.length; i++){
        }

        // 2,2,5,4;  {2,2}부터 {5,4}까지

        return answer;
    }
}
