import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> readyPQ = new LinkedList();
        Queue<Integer> crossingPQ = new LinkedList();
        
        // 다리를 건너기 위해 기다리고 있는 trcuk 배열
        readyPQ.addAll(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));
        
        // 다리를 건너고 있는 truck 배열
        crossingPQ.addAll(Arrays.stream(new int[bridge_length]).boxed().collect(Collectors.toList()));
        

        int nowWeight = 0;
        // 대기중인 트럭 배열이 빌때까지
        while(!crossingPQ.isEmpty()){

            nowWeight -= crossingPQ.poll();            
            if(readyPQ.isEmpty()){
                answer += bridge_length;
                break;
            } else {
                if((nowWeight + readyPQ.peek()) <= weight){                    
                    nowWeight += readyPQ.peek();
                    crossingPQ.offer(readyPQ.poll());
                }   else {
                    crossingPQ.offer(0);
                }
            }
            
            answer ++;
        }
        return answer;
    }
}