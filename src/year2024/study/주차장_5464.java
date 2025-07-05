package src.year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 주차장
// 자료구조(availableSpots)
// 19 : 40 ~
public class 주차장_5464 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        // 주차장 사이즈
        int PARK_COUNT = Integer.parseInt(st.nextToken());
        
        // 주차하는 차량의 수
        int CAR_COUNT = Integer.parseInt(st.nextToken());
        
        // 주차 공간의 요금 정보를 저장
        int[] parkRates = new int[PARK_COUNT + 1];
        for (int i = 1; i <= PARK_COUNT; i++) {
            parkRates[i] = Integer.parseInt(bf.readLine());
        }
        
        // 차량의 무게 정보를 저장
        int[] carWeights = new int[CAR_COUNT + 1];
        for (int i = 1; i <= CAR_COUNT; i++) {
            carWeights[i] = Integer.parseInt(bf.readLine());
        }
        
        int[] arr = new int[CAR_COUNT + 1];
        PriorityQueue<Integer> availableSpots = new PriorityQueue<>();
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 1; i <= PARK_COUNT; i++) {
            availableSpots.add(i);
        }
        
		int result = 0;

		for (int i = 0; i < 2 * CAR_COUNT; i++) {
			int num = Integer.parseInt(bf.readLine());
			if (num > 0) { // 차량 출입
				// 주차 공간이 비어있는지?
				if (availableSpots.isEmpty()) {
					temp.add(num); // 주차장 번호 저장
				} else { // temp에 차량 번호 저장
					arr[num] = availableSpots.poll();
				}
			} else {// 차량 무게 * 단위 무게당 요금 더한다. 
				num = Math.abs(num);
				result += carWeights[num] * parkRates[arr[num]];
				// 대기중인 차량이 있을경우 주차 공간을 넣어준다.
				if (!temp.isEmpty()) {
					arr[temp.poll()] = arr[num];
				} else { // 대기 중인 차량이 없다면 빈 주차 공간(queue)에 저장
					availableSpots.add(arr[num]);
				}
			}
		}
		System.out.println(result);
    }
}