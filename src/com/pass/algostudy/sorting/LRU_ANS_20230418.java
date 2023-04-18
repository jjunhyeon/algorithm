package com.pass.algostudy.sorting;

import java.util.Scanner;

public class LRU_ANS_20230418 {
    // 실제 Solution
    static class Main {
        public String solution(int size, int n, int[] array) {
            String answer = "";
            // size만큼의 cahce 생성
            int[] cache = new int[size];
            for(int x : array){
                int pos = -1;
                for(int i=0; i<size; i++) {
                    // 같은 값이 있다 -> HIT
                    if (x == cache[i]) {
                        pos = i;
                    }
                }
                // MISS
                if(pos == -1){
                    for(int i = size-1; i >=1; i--){
                        cache[i] = cache[i-1];
                    }
                } else { // HIT
                    for(int i=pos; i>=1; i--){
                        cache[i] = cache[i-1];
                    }
                }
                cache[0] = x;
            }
            for(int i=0; i< cache.length; i++){
                answer += cache[i];
            }

            return answer;
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
        System.out.println((T.solution(m, n, array)));
    }
}
