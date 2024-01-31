package com.pass.boj.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        // 1.set inputValue
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N ; i++) {
            pq.offer(arr[i]);
            int size = (pq.size() % 2 == 0) ? pq.size() - 1 : pq.size();
            int value = pq.peek();
            List<Integer> temp = new ArrayList<>();
            for(int k=0; k<size; k++){
                if(k == size/2){
                    value = pq.peek();
                }
                temp.add(pq.poll());
            }
            for(int j=0; j<temp.size(); j++){
                pq.add(temp.get(j));
            }
            
            System.out.println(value);
            bf.close();
        }
    }
}
