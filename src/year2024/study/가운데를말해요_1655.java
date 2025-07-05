package src.year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        // 1.set inputValue
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 1. 초기 조건
            if (maxHeap.isEmpty()) {
                maxHeap.offer(arr[i]);
            }
            else if(minHeap.isEmpty()){
                if(maxHeap.peek() > arr[i]){
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(arr[i]);
                } else{
                    minHeap.offer(arr[i]);
                }
            } else if(minHeap.size() > maxHeap.size()){
                if(minHeap.peek() > arr[i]) maxHeap.offer(arr[i]);
                else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(arr[i]);
                }
            } else if(maxHeap.size() > minHeap.size()){
                if(maxHeap.peek() >= arr[i]) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(arr[i]);
                } else{
                    minHeap.offer(arr[i]);
                }
            } else{
                if(minHeap.peek() > arr[i]) maxHeap.offer(arr[i]);
                else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(arr[i]);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }

}
