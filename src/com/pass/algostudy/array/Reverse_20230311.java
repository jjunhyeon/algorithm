package com.pass.algostudy.array;

import java.util.Scanner;

/*
*  문제 : 뒤집은 소수
*  설명 : 입력받은 수를 뒤집은 후 뒤집은 수가 소수라면 출력한다.
*  EX : 21 -> 12 : X 32 -> 23 : O 210 -> 12 : X
*  풀이 :
*   1. 갑 입력 받기
*   2. 입력받은 수를 뒤집어 배열에 담는다.
*   3. 소수 구하는 알고리즘을 사용해 최종 결과 출력한다.
* */
public class Reverse_20230311 {
    static class Main {
        public String solution(int s,int[] k) {

            int reverse[] = new int[s];

            for(int i=0; i<s; i++){
                String reversed = new StringBuilder(Integer.toString(k[i])).reverse().toString();
                int lt =0;
                while(lt < reversed.length() && reversed.charAt(lt) == '0'){
                    lt++;
                }
                reverse[i] = Integer.parseInt(reversed.substring(lt));
            }

            // 최종결과 출력을 위한 변수
            StringBuilder forAdd = new StringBuilder();

            // 소수 선별
            for(int i=0; i< reverse.length; i++){

                int lt = 2;
                while(lt < reverse[i]){
                    if(reverse[i] % lt == 0){
                        break;
                    } else if(reverse[i] % lt != 0 && lt == reverse[i] -1){
                        forAdd.append(reverse[i] + " ");
                    }
                    lt++;
                }

                if(reverse[i] == 2){
                    forAdd.append(reverse[i] + " ");
                }

            }
            return forAdd.toString();
        }
    }


    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int k[] = new int[s];
        for(int i=0; i<s; i++){
            int num = kb.nextInt();
            k[i] = num;
        }
        System.out.println(T.solution(s,k));
    }
}
