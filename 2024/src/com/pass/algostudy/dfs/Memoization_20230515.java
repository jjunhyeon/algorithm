package com.pass.algostudy.dfs;

import java.util.Scanner;

/*
* 조합수(메모이제이션)
* nCr = (n-1)C(r-1) + (n-1)C(r)
*
* */
public class Memoization_20230515 {
    // staic 접근을 위해 static변수 선언
    static int[][] storage = new int[35][35];
    static class Main {
        public int Memoization(int n, int r) {
            
            // 존재하면 n,r 그 값을 리턴해
            if(storage[n][r] > 0){
                return storage[n][r];
            }

            if(n == r || r ==0){
                return 1;
            } else{
                // 저장하고 storage[n][r]를 리턴
                return storage[n][r] = Memoization(n-1, r-1) + Memoization(n-1,r);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        //: 출발점 체크
        System.out.println(T.Memoization(n, r));
    }
}
