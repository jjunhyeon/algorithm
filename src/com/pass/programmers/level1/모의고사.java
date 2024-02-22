package com.pass.programmers.level1;

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        //int[] answers = {5, 5, 4, 2, 3};
        int[] answers = {1,2,3,4,5};
        solution(answers);
    }
    public static int[] solution(int[] answers) {

        int[] s1 = new int[]{1, 2, 3, 4, 5};
        int[] s2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int len = answers.length;

        int[] score = new int[3];
        for (int i = 0; i < len; i++) {
            int target = answers[i];
            if (target == s1[i % s1.length]) {
               score[0] ++;
            }

            if (target == s2[i % s2.length]) {
                score[1] ++;
            }

            if (target == s3[i % s3.length]) {
                score[2] ++;
            }
        }

        /*
         * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
         * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
         * */
        List<Integer> answerList = new ArrayList<>();

        int base = Math.max(score[0],Math.max(score[1],score[2]));

        if(base == score[2]){
            answerList.add(3);
        }

        if(base == score[1]){
            answerList.add(2);
        }

        if(base == score[0]){
            answerList.add(1);
        }

        Collections.sort(answerList);
        return answerList.stream().mapToInt(i->i.intValue()).toArray();
    }
}
