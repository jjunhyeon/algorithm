package com.pass.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class maxHeap_11279_20230611 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 , 내부적으로 값이 오름차순으로 정렬 된다.

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!pq.isEmpty()) {
                    // 비어 있찌 않으면
                    System.out.println(pq.poll());
                } else {
                    System.out.println("0");
                }
            } else {
                pq.offer(num); //값 추가
            }
        }
    }
}
