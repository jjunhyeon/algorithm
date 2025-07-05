package src.year2024.stackorqueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
* 공주 구하기
* Queue
* 넣는 방법
* Queue.offer(x)
* : 해당 자료구조에 x값을 넣는다
* Queue.poll(x)
* : 해당 자료구조에 x를 뺀다
* 큐의 핵심 -> FIFO : First in First out
* Queue.peeK() 제일 앞의 값을 확인한다.
* Queue.size() 큐안에 몇개가 있는지 확인
* Queue.contains(x) : x가 있는지 확인
* return (if x contain) true / false
* */
public class Princess_20230402 {
    static class Main {
        public int solution(int k, int j) {
            int result = 0;

            Queue<Integer> myQueue = new ArrayDeque<>(k);
            for(int i=1; i<=k; i++){
                myQueue.offer(i);
            }


            while(myQueue.size() != 1){
                for(int i=1; i<j; i++){
                    myQueue.offer(myQueue.poll());
                }
                myQueue.poll();
            }

            result = Integer.parseInt(myQueue.peek().toString());
            return result;
        }
    }
    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int j = kb.nextInt();

        System.out.println(T.solution(k,j));
    }
}
