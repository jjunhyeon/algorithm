package com.pass.programmers.level1;

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2,3,2,4,2};
        solution(answers);
    }
    public static int[] solution(int[] answers) {
        ArrayList<ArrayList<Integer>> student = new ArrayList<>();

        // array list add value
        student.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
        student.add(new ArrayList<Integer>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5)));
        student.add(new ArrayList<Integer>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)));

        int len = answers.length;

        int[] score = new int[3];
        for (int i = 0; i < len; i++) {
            int target = answers[i];
            if (target == student.get(0).get(i % 5)) {
               score[0] ++;
            }

            if (target == student.get(1).get(i % 8)) {
                score[1] ++;
            }

            if (target == student.get(2).get(i % 10)) {
                score[2] ++;
            }
        }

        /*
         * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
         * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
         * */
        List<Integer> answerList = new ArrayList<>();
        int max = 0;
        for(int i=0; i<3; i++){
            if(score[i] >= max){
                max = score[i];
                answerList.add(i+1);
            }
        }
        Collections.sort(answerList);
        // 가장 큰 value값의 키를 리턴해야하는 문제임
        int result[] = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) result[i] = answerList.get(i);
        return result;
    }
}
