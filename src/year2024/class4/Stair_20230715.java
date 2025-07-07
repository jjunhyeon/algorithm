package year2024.class4;

import java.util.Scanner;
/*
* 계단 오르기
* */
public class Stair_20230715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] stair = new int[K+1];
        int[] score = new int[K+1];
        for(int i=1; i<=K; i++){
            stair[i] = sc.nextInt();
        }

        if(K == 1){
            System.out.println(stair[1]);
        } else if(K==2){
            System.out.println(stair[1] + stair[2]);
        } else {
            score[1] = stair[1];
            score[2] = stair[1] + stair[2];
            score[3] = Math.max(stair[1], stair[2]) + stair[3];
            for(int i=4; i<=K; i++){
                score[i] = Math.max(score[i-3] + stair[i-1], score[i-2])+ stair[i];
            }
            System.out.println(score[K]);
        }
    }
}
