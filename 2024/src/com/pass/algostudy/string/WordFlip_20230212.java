package com.pass.algostudy.string;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 4번 단어 뒤집기
* param 첫줄엔 자연수 N
* 두번째 줄부터 N개의 단어가 각 줄에 하나씩 넘어옴
* StringBuilder를 사용해 reverse : 뒤집기
* String.valueOf : 배열을 스트링화 시킨다.
* */
public class WordFlip_20230212 {
    static class Main {
        public ArrayList<String> solution(long wordCount, String[] str) {
            ArrayList<String> answer = new ArrayList<>();
            for(String x : str){
                // 문자 하나하나에 대해서 처리하기 위해서 char 문자배열로 만든다.
                // x.toCharArray -> 단어를 가지는 String이 char 배열로 만들어진다.
                char[] st = x.toCharArray();
                int lt = 0;
                int rt = x.length() -1;
                while(lt < rt){
                    char tmp = st[lt];
                    st[lt] = st[rt];
                    st[rt] = tmp;
                    lt ++;
                    rt --;
                }
                String result = String.valueOf(st);
                answer.add(result);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];

        for(int i=0; i<n; i++){
            str[i] = kb.next();
        }
        for(String x : T.solution(n, str)){
            System.out.println(x);
        }
    }
}
