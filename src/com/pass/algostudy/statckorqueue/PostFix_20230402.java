package com.pass.algostudy.statckorqueue;

import java.util.Scanner;
import java.util.Stack;

/*
* 후위식 연산
* 확인사항
* 1. char의 int 검사
* Character.isDigit(char)
* : return if (int) : true / false
* 2. char는 int타입으로 (char) num 식으로 형변환 시 아스키값으로 바뀜
* -> Character.getNumericValue(char)
* int 값 자체로 char 타입으로 변환할 수 있음
*
* */
public class PostFix_20230402 {
    static class Main {
        public int solution(String s) {
            int result = 0;
            Stack<Integer> myStack = new Stack<>();

            for(int tmp : s.toCharArray()){
                if(Character.isDigit(tmp)){
                    myStack.push(Character.getNumericValue(tmp));
                } else {
                    int rt = myStack.pop();
                    int lt = myStack.pop();
                    int answer = 0;
                    switch(tmp){
                        case '+':
                            answer = lt + rt;
                            break;
                        case '-':
                            answer = lt - rt;
                            break;
                        case '*':
                            answer = lt * rt;
                            break;
                        case '/':
                            answer = lt / rt;
                            break;
                    }
                    myStack.push(answer);
                }
            }
            result = myStack.peek();

            return result;
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String param = kb.nextLine();

        System.out.println(T.solution(param));
    }
}
