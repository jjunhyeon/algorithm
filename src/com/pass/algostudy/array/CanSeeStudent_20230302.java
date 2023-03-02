package com.pass.algostudy.array;

import java.util.Scanner;

/*
* 문제 : 보이는 학생
* 자기보다 앞에 있는 학생들보다 크면 출력한다.
* 풀이
* 1. 첫 배열 값은 바로 출력
* 2. 두번째부터는 자신의 인덱스보다 작은 인덱스의 번호까지를 루프 돌며 순회하면서 같거나 큰 값이 있으면 break;
*    자기 직전의 값까지 비교했을떄도 해당 index의 값이 더 크면 result에 add
* 3. result 출력
*
* -- 강사님 풀이 --
* 1. 입력받은 배열을 순회할때  가장 큰 값을 max 변수로 가지고 있는다
* 2. max 변수보다 큰 인덱스의 값만 최종 result에 add해서 출력한다.
* 3. 출력
* */
public class CanSeeStudent_20230302 {

    // 실제 Solution
    static class Main {
        public int solution(int s, int[] num) {
            int result =0;

            for(int i=0; i<s; i++){
                if(i==0){
                    result += 1;
                }
                int lt =0;
                while(lt<i){
                    if(num[lt] >= num[i]){
                        break;
                    } else if(lt == i-1 && num[lt] < num[i]){
                        result+=1;
                    }
                    lt ++;
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

       System.out.print( T.solution(s,arr));
    }
}
