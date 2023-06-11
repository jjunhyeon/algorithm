package com.pass.boj;

import java.util.Scanner;

public class Z_1074_20230611 {
    static int R,C, answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        R = sc.nextInt(); // 행
        C = sc.nextInt(); // 열
        solve(0, 0, (int)Math.pow(2,(N)));
    }

    public static void solve(int r, int c, int size){

        if(size == 1){
            System.out.println(answer);
            return;
        }
        // 사분면 구분을 위한 변수
        int division = size / 2;
        // r , c모두 division 값모다 작으면 1사분면
        if(R < r + division &&  C < c + division){ // 1사분면
            solve(r, c, division);
        } else if(C>= c + division  && R < r + division){ // 2사분면
            answer += (size * size) / 4;
            solve(r,c + division,division);
        } else if(R>= r + division && C < c + division){ // 3사분면
            answer += ((size * size) / 4) * 2;
            solve(r + division, c, division);
        } else if(C>= c + division && R >=  r + division){ // 4사분면
            answer += ((size * size) / 4) * 3;
            solve(r+division, c+division, division);
        }

    }
}
