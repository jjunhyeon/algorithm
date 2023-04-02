package com.pass.algostudy.statckorqueue;
/*
* 응급실
* : N명의 대기 환자 목록에 대해 위험도가 주어지는데
*  첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어질 때
*  M번째 환자의 몇 번째로 진료받는지 출력한다.
* 1. 제일 첫 환자는 0번재이다.
* 2. 두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
* // 다시 풀어
*
* */
import java.util.ArrayDeque;

import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom_20230402 {
    static class Main {
        public int solution(int k, int j , int[] intArray) {
            int result = 1;


            Queue<Integer> myqueue = new ArrayDeque<>();

            for(int i=0; i< intArray.length; i++){
                myqueue.offer(intArray[i]);
            }
            
            // 큐가 비어있지 않고
            // 배열의 값 중 target보다 큰 값이 존재하지 않는다면 바로 탈출 및 결과 1
            // 그렇지 않다면 target을 다시 큐에 넣는다.\
            // FIXME 다시 해결
            while(!myqueue.isEmpty()){
                // int priority = myqueue.poll();

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
        int k = kb.nextInt();
        int j = kb.nextInt();

        int[] intArray =  new int[k];

        for(int i=0; i<k; i++){
            intArray[i] = kb.nextInt();
        }

        System.out.println(T.solution(k,j,intArray));
    }
}
