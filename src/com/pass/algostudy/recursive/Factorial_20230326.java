package com.pass.algostudy.recursive;

import java.util.Scanner;

/*
 * 팩토리얼 문제
 * 재귀로 풀기
 * */
public class Factorial_20230326 {
    static class Main {
        public int DFS(int n) {
            if (n == 1) {
                return 1;
            } else {
                return n*DFS(n - 1);
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int factorial = kb.nextInt();
        System.out.println(T.DFS(factorial));
    }
}
