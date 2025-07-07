package year2024.array;

import java.util.Scanner;
/*
*  문제 : 격자판 합 구하기
*  2차원 배열의 값을 입력받아 행의합, 열의합, 대각선(반대포함) 중 가장 큰 갑을 출력하는 문제
* */
public class TwoLattice_20230314 {

    // 실제 Solution
    static class Main {
        public int solution(int s, int[][] num) {
            int result = 0;
            for(int i=0; i<s; i++){
                int rowMax = 0;
                int columnMax =0;
                for(int j=0; j<s; j++){
                    rowMax += num[i][j];
                    columnMax += num[j][i];
                }
                // 행의 합
                result = Math.max(result,rowMax);
                // 열의 합
                result = Math.max(result,columnMax);
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<s; i++){
                // 대각선
                sum1 += num[i][i];
                // 반대 대각선
                sum2 += num[i][s-i-1];
            }
            result = Math.max(result,sum1);
            result = Math.max(result,sum2);

            return result;
        }
    }
    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int[][] arr = new int[s][s];
        for(int i=0; i<s; i++){
            for(int j=0; j<s; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(s,arr));
    }
}
