package com.pass.algostudy.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * DP - 벽돌 쌓기
 * 다시풀기
 * */
public class MaxBrickRetry_20230606 {
    static int[] result;

    // 밑면이 가장 넓은 순으로 오름차순 정렬
    public static class Brick implements Comparable<Brick> {
        int width, height, weight;

        Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return this.width + " " + this.height + " " + this.weight;
        }

        // 밑면 값으로 내림차순 정렬
        @Override
        public int compareTo(Brick o) {
            return o.width - this.width;
        }
    }

    public static class Main {
        public static int solution(ArrayList<Brick> bricks) {
            Collections.sort(bricks); // 밑 넓이 기준으로 내림차순 정렬될 수 있게 sort 사용
            result[0] = bricks.get(0).height; // result[0]은 최초 높이
            int answer = result[0]; // 정답에도 해당값으로 초기화
            for(int i=1; i< bricks.size(); i++){  // 벽돌의 길이만큼 순회
                int max_H = 0; //
                for(int j=i-1; j>=0; j--){
                    if(bricks.get(j).weight > bricks.get(i).weight && result[j] > max_H){
                        max_H = result[j]; // 다음 벽돌이 조건에 충족된다면 벽돌의 max_h교체
                    }
                }
                result[i] = max_H + bricks.get(i).height; // max_h에 i번쨰 벽돌을 올리는것
                answer = Math.max(answer, result[i]);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        ArrayList<Brick> bricks = new ArrayList<>();
        int brickCnt = kb.nextInt();
        result = new int[brickCnt];
        for (int i = 0; i < brickCnt; i++) {
            int width = kb.nextInt();
            int height = kb.nextInt();
            int weight = kb.nextInt();
            bricks.add(new Brick(width, height, weight));
        }

        System.out.println(T.solution(bricks));
    }
}
