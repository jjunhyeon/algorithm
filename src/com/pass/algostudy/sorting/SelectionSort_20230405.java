package com.pass.algostudy.sorting;

import java.util.Scanner;

public class SelectionSort_20230405 {
    // 실제 Solution
    static class Main {
        public String solution(int n, int[] array) {
            String result = "";
            for(int i=0; i<array.length; i++){
                int tmp = i;
                for(int j=i+1; j<n; j++){
                    if(array[tmp] > array[j]){
                        tmp = j;
                    }
                }
                int t = array[tmp];
                array[tmp] = array[i];
                array[i] = t;

                result += array[i] + " ";
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
        int n = kb.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,array));
    }
}
