package com.pass.algostudy.sorting;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
* 중복검사
* SORT 방식으로 정렬 후 이전값과 비교하면서 같은 값인지 체크하는 방식으로도 풀 수 있다.
* 시간 복잡도는 해쉬맵이 더 우수하다
* 결론 : 문제 의도는 정렬 하지만 성능은 해쉬맵
* */
public class CheckDuplication_20230418 {
    static class Main {
        public String solution(int n,  int[] array) {
            String answer = "U";
            Set<Integer> task = new HashSet<>();
            for(int x: array){
                task.add(x);
            }
            if(task.size() != array.length){
                answer = "D";
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
        int n = kb.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,array));
    }
}
