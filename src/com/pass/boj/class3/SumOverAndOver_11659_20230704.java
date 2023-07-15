package com.pass.boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 누적합구하기
 * 시간초과
 * */
public class SumOverAndOver_11659_20230704 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bf.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] arr = new int[N + 1];
        String[] num = bf.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(num[i - 1]) + arr[i - 1];
        }

        while (M-- > 0) {
            String[] nums = bf.readLine().split(" ");
            int from = Integer.parseInt(nums[0]);
            int to = Integer.parseInt(nums[1]);
            System.out.println(arr[to] - arr[from - 1]);
        }
    }
}
