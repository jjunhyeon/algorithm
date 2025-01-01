package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 색종이 만들기
 * 2:20 ~
 * */
public class MakeConfetti_2630_20230625 {
    static int[][] matrix;
    static int white, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 정사각형의 가로 세로 사이즈 정보
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        solution(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    // 재귀로
    private static void solution(int size, int row, int column) {
        if (checkPartition(size, row, column)) {
            if (matrix[row][column] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int half = size / 2;
        solution(half, row + half, column); // 2사분면
        solution(half, row, column); //1사분면
        solution(half, row , column + half); // 3사분면
        solution(half, row + half, column + half); //4사분면
    }

    public static boolean checkPartition(int size, int row, int column) {
        int color = matrix[row][column];
        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (color != matrix[i][j]) { // 값이 다르다면 다른 값이 포함된것임
                    return false;
                }
            }
        }
        return true;
    }
}
