package stackorqueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/*
* 교육과정설게
* checkString값으로 들어온 과정의 커리큘럼을 구성했는지 확인하는 문제
* checkString값을 queue값으로 만들어 curriCulum과 비교한다.
* */
public class Curriculum_20230402 {
    static class Main {
        public String solution(String checkString, String curriCulum) {
            String result = "YES";

            Queue<Character> myqueue = new ArrayDeque<>();
            for(char str : checkString.toCharArray()){
                myqueue.offer(str);
            }

            for(char str : curriCulum.toCharArray()){
                if(!myqueue.isEmpty() && myqueue.peek().equals(str)){
                    myqueue.poll();
                }
            }

            if(!myqueue.isEmpty()){
                result = "NO";
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

        String param = kb.nextLine();
        String nextParam = kb.nextLine();

        System.out.println(T.solution(param,nextParam));
    }
}
