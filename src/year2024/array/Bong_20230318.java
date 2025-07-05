package src.year2024.array;


import java.util.Scanner;

/* 문제 : 봉우리
*  봉우리 ? : 입력받은 2차원 배열 내부 상하좌우 값보다 큰 지점을 봉우리라고한다.
*  풀이 : 봉우리 지점을 배열을 순회하면서 찾아 결과값을 증가시킨다.
*  ++ ArrayOutOfIndex 처리해야하는 문제
*  ++ 발생할 수 있는 지점인 첫 순회지점에서 이전 인덱스, 마지막 순회지점에서 다음 인덱스 조회할때 값을 임의로 0으로 처리해서 해결
* */
public class Bong_20230318 {
    // 실제 Solution
    static class Main {
        public int solution(int s, int[][] num) {
            int result =0;
            for(int i=0; i<s; i++){
                for(int j=0; j<s; j++){
                    int prev = i == 0 ? 0 : num[i-1][j]; // i가 0일 경우에는 prev를 0으로 처리
                    int next = i == num.length-1 ? 0 : num[i+1][j]; // i가 마지막 인덱스일 경우에는 next를 0으로 처리
                    int up = j == 0 ? 0 : num[i][j-1];
                    int down = j == num.length-1 ? 0 : num[i][j+1];
                    if(num[i][j] > prev && num[i][j] > next && num[i][j] > up && num[i][j] > down){
                        result ++;
                    }
                }
            }

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
        int[][] num = new int[s][s];
        for(int i=0; i<s; i++){
            for(int j=0; j<s; j++){
                int k =  kb.nextInt();
                num[i][j] = k;
            }
        }
        System.out.println(T.solution(s,num));
    }
}
