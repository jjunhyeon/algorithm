package com.pass.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;


/*
* 연속된 부분 순열
* */
public class Subsequence_20230710 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int k = 7;
        System.out.println(Arrays.toString(twoPointer(arr, k)));
    }

    public static int[] twoPointer(int[] arr, int k){
        int sum = 0;
        int[] result = new int[2];
        int p1 = 0;
        int p2= 0;
        int minValue = Integer.MAX_VALUE;
        while(true){
            if(sum >= k){
                sum -= arr[p1++]; // 값이 더 커지면 다시 왼쪽으로 한칸
            } else if(p2 >= arr.length){
                break;
            } else{
                // 값이 더 작은 케이스 right Pointer 증가
                sum += arr[p2++];
            }

            if(sum == k){
                if(minValue > p2 - p1){
                    minValue = p2 - p1;
                    result[0] = p1;
                    result[1] = p2 -1;
                }
            }
        }
        return result;
    }
    
    // fail
    // 한쪽으로만 값을 증가시켰을때, target값이 초과했을떄 돌아올 수가 없었음
    private static int[] solution(int[] arr, int k) {
        Arrays.sort(arr); // 정렬
        int sum = 0;
        int[] result = new int[2];
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            answerList.add(i); // 인데스번호 넣기
            if(sum == k){
                if(answerList.size() == 1){
                  result[0] = result[1] = answerList.get(0);
                  break;
                }
                // 비어있지 않고 교체할 수 있다면
                if(answerList.isEmpty() || (answerList.size() > (result[1] - result[0] + 1))){
                    result[0] = answerList.get(0);
                    result[1] = answerList.get(i);
                    answerList.clear();
                    sum = 0;
                }
            } else if(sum > k){
                sum = 0;
                answerList.clear();
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
