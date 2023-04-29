package com.pass.algostudy.sorting;
import java.util.Arrays;
import java.util.Scanner;

/*
* 결정알고리즘2
* : 마구간 정하기
*
* */
public class DecisionAlgorithm2_20230423 {
    // 실제 Solution
    static class Main {
        public int solution(int m, int[] array) {
            // 정답
            int answer = 0;

            // 1. 마구간 정렬 (삽입정렬)
            for(int i=0; i< array.length; i++){
                int tmp = array[i],j;
                for(j = i-1; j>-1; j--){
                    if(array[j] > tmp){
                        array[j+1] = array[j];
                    } else {
                        break;
                    }
                }
                array[j+1] = tmp;
            }

            int lt =1;
            int rt =array[array.length-1];

            while(lt <= rt){
                int mid = (lt+rt) / 2;
                if(m <= getMaxDistnace(array,mid)){
                    answer = mid;
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            return answer;
        }

        // 적재가능한 말의 수를 구한다.
        public int getMaxDistnace(int[] arr,int distance){
            int count = 1;
            int val = arr[0];
            for(int i=1; i< arr.length; i++){
                if(arr[i] - val >= distance){
                    count ++;
                    val = arr[i];
                }
            }
            return count;
        }
    }
    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        System.out.println((T.solution(m, array)));
    }
}
