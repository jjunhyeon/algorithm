

import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 절댓값 힙
* input value가 0이 아니라면 배열에 x라는 값을 넣는 연산이고,
* x가 0이라면 배열에서 절대값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
* 절대값이 같다면 값이 더 작은 값을 우선으로 처리 해야한다.
* */
public class Main {
    public static class Absolute implements Comparable<Absolute>{
        int value;
        Absolute(int value){
            this.value = value;
        }

        @Override
        public int compareTo(Absolute o) { // 작은값이 정렬될 수 있도록 생성한다.
            // 절대값이 같은 경우에 대해서 처리 필요
            if(Math.abs(o.value) == Math.abs(this.value)){
                return this.value - o.value;
            } else {
                return Math.abs(this.value) - Math.abs(o.value);
            }
        }

        @Override
        public String toString(){
            return this.value + " ";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valueCount = sc.nextInt();
        PriorityQueue<Absolute> pq = new PriorityQueue<>();
        for(int i=0; i<valueCount; i++){
            int value = sc.nextInt();
            // 0에 대한 분기 처리 0
            if(value != 0) {
                // 0이라면 pq에 offer
                pq.offer(new Absolute(value));
            } else if(value == 0 && !pq.isEmpty()){
                // 0이 아니라면, poll
                System.out.println(pq.poll().toString());
            } else {
                System.out.println("0");
            }
        }
    }
}
