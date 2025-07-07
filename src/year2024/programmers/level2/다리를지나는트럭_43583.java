package year2024.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class 다리를지나는트럭_43583 {

    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7, 4, 5, 6};
        solution(bridgeLength, weight, truckWeights);
    }

    private static int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        Queue<Integer> readyQ = new LinkedList<>();
        readyQ.addAll(Arrays.stream(truckWeights).boxed().collect(Collectors.toList()));
        Queue<Integer> bridgeQ = new LinkedList<>();
        bridgeQ.addAll(Arrays.stream(new int[bridgeLength]).boxed().collect(Collectors.toList()));


        int totalWeight = 0;
        while (!bridgeQ.isEmpty()) {
            // 다리를 지나는 트럭에서 무게를 감소시킴
            totalWeight -= bridgeQ.poll();
            // 비어있으면 대기 중인 트럭 없음
            if (readyQ.isEmpty()) {
                answer += bridgeLength;
                break;
            } else {
                // 트럭이 더 올라올수 있는 상태
                if ((totalWeight + readyQ.peek()) <= weight) {
                    totalWeight += readyQ.peek();
                    bridgeQ.offer(readyQ.poll());
                } else {
                    // 이걸?
                    bridgeQ.offer(0);
                }
            }
            answer++;
        }
        System.out.println("ans" + answer);
        return answer;
    }

}
