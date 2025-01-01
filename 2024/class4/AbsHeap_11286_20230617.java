package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
* 절댓값 힙
* input value가 0이 아니라면 배열에 x라는 값을 넣는 연산이고,
* x가 0이라면 배열에서 절대값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
* 절대값이 같다면 값이 더 작은 값을 우선으로 처리 해야한다.
*
* */
public class AbsHeap_11286_20230617 {
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

    public static void main(String[] args) throws IOException {
        /*
        * Scanner와 BufferedReader 두 클래스 모두 입력을 받는데 사용하는 주요 클래스
        * Scanner는 간편한 사용법을 제공하지만, 내부적으로 System.in을 반복저으로 호출하기 때문에 큰 인풋 데이터 처리 시 비효율
        * 반면에 BufferedReader 방식은 입력된 데이터를 버퍼에 미리 저장하고 한줄씩 처리하므로 I/O 작업을 최적화하여 성능을 향상시킨다.
        * 그러므로 BufferedReader class 사용을 지향하자.
        * */
        //Scanner sc = new Scanner(System.in);
        //int valueCount = sc.nextInt();

        // 클래스 생성 후 처리하는 방식
        //PriorityQueue<Absolute> pq = new PriorityQueue<>();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int valueCount = Integer.parseInt(br.readLine());

        // 내부 람다식을 활용해 처리하는 방식
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        );

        for(int i=0; i<valueCount; i++){
            //int value = sc.nextInt();
            int value = Integer.parseInt(br.readLine());
            // 0에 대한 분기 처리 0
            if(value != 0) {
                // 0이라면 pq에 offer
                pq.offer(value);
            } else if(value == 0) {
                // 0이 아니라면, poll
                if(pq.isEmpty()){
                    System.out.println("0");
                } else{
                    System.out.println(pq.poll().toString());
                }
            }
        }
    }
}
