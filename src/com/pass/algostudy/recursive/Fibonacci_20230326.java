package com.pass.algostudy.recursive;

import java.util.Scanner;

/*
 * 피보나치 해결 방법
 * 1. 재귀 2. 단순 for문
 * 두 방식에서 성능의 우위는 for문으로 푸는 방법에 있다.
 * 그 이유는 재귀는 메모리 스택을 사용하기 때문에 메모리 사용량이 많아질 수 있기 때문이다.
 * 이를 효율적으로 개선하는 방법 메모이제이션
 * 이미 구한 재귀의 값을 기록(static array)한 뒤 활용한다는 개념
 * */
public class Fibonacci_20230326 {
    static int[] fibo;
    static class Main {
        public int DFS(int n) {

            if(fibo[n] > 0) {
                return fibo[n];
            }

            if (n == 1 || n == 2) {
                return fibo[n] = 1;
            } else {
                return fibo[n] = DFS(n - 2) + DFS(n - 1);
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        fibo = new int[num+1];
        T.DFS(num);

        for(int i=1; i<fibo.length; i++){
            System.out.print(fibo[i] + " ");
        }
    }
}
