package programmers.level2;

import java.util.PriorityQueue;

public class 더맵게_42626 {
    public static void main(String[] args){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        solution(scoville,k);
    }


    public static int solution(int[] scoville, int K) {
        int answer = 0;
        // array to PriorityQueue
        PriorityQueue<Integer> mypq = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++){
            mypq.offer(scoville[i]);
        }

        // pq에 담긴 값들을 앞의값부터 섞은후 넣는다.
        // 가장 앞에 있는 값이 원하는 스코빌 지수보다 클떄까지
        while((mypq.size() > 1) && mypq.peek()  < K){
            // 1번 ,2번 값
            int firstValue = mypq.poll();
            int secondValue = mypq.poll();
            // 두 값을 섞어야함
            int newValue = firstValue + (secondValue * 2);
            mypq.offer(newValue);
            answer ++;
        }

        return (mypq.peek() >= K) ? answer : -1;
    }
}
