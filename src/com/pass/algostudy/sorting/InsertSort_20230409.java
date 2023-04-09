package com.pass.algostudy.sorting;

import java.util.Scanner;

/*
* 삽입 정렬(Insertion Sort)
* 삽입 정렬은 배열의 두 번째 값을 기준으로, 그 이전의 값들과 비교하여 자신보다 작은 값을 찾아 그 앞에 삽입하는 방법으로 동작합니다. 이를 반복하여 전체 배열을 정렬합니다.
* 장점 : 배열의 크기가 작을 경우 효율적입니다.
* 단점 : 시간 복잡도가 O(N^2)로 비효율적입니다.
* -> 선택 정렬, 버블 정렬, 삽입 정렬은 모두 시간 복잡도가 O(N^2)이므로, 대규모 데이터 정렬에는 비효율적이고
* 이를 개선한 퀵 정렬, 병합 정렬 등의 알고리즘이 있습니다.
* 1차원에 배열에 담긴 값을 정렬 할 때
* 제일 처음 0번쨰 부터가 아닌 , i가 1부터 순회한다.
*
* */
public class InsertSort_20230409 {
    // 실제 Solution
    static class Main {
        public String solution(int n, int[] array) {
            String result = "";
            for(int i=1; i< array.length; i++){
                int tmp = array[i],j;
                for(j= i-1; j>-1; j--){
                    if(array[j] > tmp){
                        array[j+1] = array[j];
                    } else {
                        break;
                    }
                }
                array[j+1] = tmp;
            }

            for(int i=0; i< array.length; i++){
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
