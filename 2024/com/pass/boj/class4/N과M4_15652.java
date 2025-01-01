package com.pass.boj.class4;


import java.util.Scanner;

/*
 * 14 : 33 ~
 * N과 M
 * 같은 수를 여러번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * */
public class N과M4_15652 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // MAX 값
        int N = sc.nextInt();
        // COL의 수
        int M = sc.nextInt();
        boolean[] visited = new boolean[N + 1];
        getDFS(N, M, new StringBuilder(), 1);
        System.out.println("what is the ans::" + N + " M:" + M);
    }

    /*
     * @param n : max값
     * @param m : line 수
     * */
    private static void getDFS(int n, int m, StringBuilder stBuilder, int depth) {

        if (stBuilder.length() / 2 == m) {
            System.out.println(stBuilder);
            return;
        }

        for (int i = depth; i <= n; i++) {
            stBuilder.append(i).append(" ");
            getDFS(n, m, stBuilder, i);
            stBuilder.delete(stBuilder.length() - 2, stBuilder.length());
        }
    }
}
