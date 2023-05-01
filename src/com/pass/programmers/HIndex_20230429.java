package com.pass.programmers;

import java.util.Arrays;

/*
* h-index 만약 갯수만큼 인용된 횟수가 있따면 그 값을 찾아야한다.
* 이중 포문
* 첫번재 포문의 값과
* 두번째 포문에서 비교함
* 그 값 이상의 수가 갯수이상 있으면 그 값을 우선 저장하고 넘김
* 좋은 방법은 우선 정렬한뒤에 사이즈이하의 값을 찾는다.
*
*
*
*
* */
public class HIndex_20230429 {

    public static void main(String[] args) {
        int[] intArray = new int[]{46,327,7343,162,6};
        System.out.println(solution(intArray));
    }

    public static int solution(int[] array){
        int answer=0;
        for(int i=0; i<array.length; i++){
            int count =0;
            int tmp = array[i];
            for(int j=0; j< array.length; j++){
                if(array[i] <= array[j]){
                    count +=1;
                    if(count >= tmp && answer < tmp){
                        answer = tmp;
                    }
                }
            }
        }
        return answer;
    }
}
