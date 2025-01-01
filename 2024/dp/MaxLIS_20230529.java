package dp;

import java.util.Scanner;

/*
* 최대부분 증가수열 문제
* */
public class MaxLIS_20230529 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int answer = 0;
        int arr[] = new int[k];
        int dy[] = new int[k]; // 정답
        dy[0] = 1;
        for(int i=0; i<k; i++){
            arr[i] = kb.nextInt();
        }
        for(int i=1; i<arr.length; i++){
            int max = 0; // default 값이 0인 이유는 만약 앞에 더 큰값이 존재하지 않아도 dy[i] 값을 1로 처리하기 위한 초기화
            for(int j= i-1; j>=0; j--){
                if(arr[j] < arr[i] && dy[j] > max){
                    max = dy[j];
                }
                dy[i] = max + 1 ;
                answer = Math.max(answer,dy[i]);
            }
        }
        System.out.println(answer);
    }
}
