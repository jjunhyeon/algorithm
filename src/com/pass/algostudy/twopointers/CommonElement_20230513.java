package com.pass.algostudy.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 투 포인터 알고리즘을 사용해야하는 문제
 * 처음엔 그냥 정렬했음
 *
 * 실제 기대하는 알고리즘을 사용해서 효율성을 올려야함
 * 아래 코드는 그냥 합쳐서 정렬하는 코드
 *
 * */
public class CommonElement_20230513 {
    // 실제 Solution
    static class Main {
        // 평범한 풀이
        public void solution(int k, int[] kArray, int j, int[] jArray) {
            ArrayList<Integer> answer = new ArrayList<>();
            int p1 = 0, p2 = 0;

            while (p1 < k && p2 < j) {
                if (kArray[p1] <= jArray[p2]) {
                    if(kArray[p1] == jArray[p2]){
                        answer.add(kArray[p1]);
                    }
                    p1++;
                } else {
                    if(kArray[p1] == jArray[p2]) {
                        answer.add(jArray[p2]);
                    }
                    p2++;
                }
            }

            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int[] kArray = new int[k];
        for (int i = 0; i < k; i++) {
            kArray[i] = kb.nextInt();
        }
        int j = kb.nextInt();
        int[] jArray = new int[j];
        for (int i = 0; i < j; i++) {
            jArray[i] = kb.nextInt();
        }
        Arrays.sort(kArray);
        Arrays.sort(jArray);
        T.solution(k, kArray, j, jArray);
    }
}
