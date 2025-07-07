package year2024.array;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 큰 수 출력
* 문제 : 정수 입력 받은후 자신의 직전 앞 수 보다 큰 수만 출력
* 풀이
*  1. 입력받는다
*  2. 비교한다
*  3. 출력
* */
public class BigNumber_20230302 {
    // 실제 Solution
    static class Main {
        public ArrayList<Integer> solution(int s, int[] num) {
            ArrayList<Integer> result = new ArrayList<Integer>();

            for(int i=0; i<s; i++){
                if(i==0){
                    result.add(num[i]);
                } else if(num[i-1] < num[i]){
                    result.add(num[i]);
                }
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
        int s = kb.nextInt();
        int[] arr = new int[s];
        for(int i=0; i<s; i++){
            arr[i] = kb.nextInt();
        }
        for(int x : T.solution(s,arr)){
            System.out.print(x + " ");
        }
    }
}
