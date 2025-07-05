package src.year2024.array;

import java.util.Scanner;

/*
* 문제 : 피보나치 수열
*     : 입력받은 수의 값만큼의 피보나치 수열이 나오게 한다.
* 그냥 풀 수 있는 문제
* */
public class Fibo_20230307 {
    // 실제 Solution
    static class Main {
        public void solution(int s) {
            int[] fibo = new int[s];
            fibo[0] =1;
            fibo[1] =1;
            System.out.print(fibo[0] + " " + fibo[1] + " ");
            for(int i =2; i<fibo.length; i++){
                fibo[i] = fibo[i-1] + fibo[i-2];
                System.out.print(fibo[i] + " ");
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();

        T.solution(s);
    }
}
