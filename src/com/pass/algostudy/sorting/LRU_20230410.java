package com.pass.algostudy.sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 캐시 메모리
 * LRU(Least Recently Used)가장 최근에 사용하지 않을것을 제거하는 알고리즘을 사용한다
 *
 * */
//FIXME 다시 풀어야할 문제
public class LRU_20230410 {
    // 실제 Solution
    static class Main {
        public int[] solution(int m, int n, int[] array) {
            int[] result = new int[m];

            for (int i = 0; i < n; i++) {
                for(int j=0; j < m; j++) {
                    if(i==0 && j==0){
                        result[0] = array[0];
                    } else if (array[i] == result[j]) {
                        // 일치하는 i 인덱스을 기준으로 뒤로 밀어야한다.
                        int target = j;
                        // result의 i값을 기준으로 직전 값으로 대체한다.
                        while (target > 0) {
                            result[target] = result[target - 1];
                            target--;
                        }
                        // 0번째 값은 array[lt]로 대체한다.
                    } else {
                        if(j !=0) {
                            result[j] = result[j - 1];
                        }
                    }
                }
                array[0] = array[i];
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
        int m = kb.nextInt();
        int n = kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        System.out.println(Arrays.toString(T.solution(m, n, array)));
    }
}
