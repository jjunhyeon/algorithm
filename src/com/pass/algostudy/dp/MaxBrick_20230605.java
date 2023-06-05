package com.pass.algostudy.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
* 최대 벽돌 높이 구하기(다시풀어보자)
* */
public class MaxBrick_20230605 {
    static int[] result;
    // 밑면이 가장 넓은 순으로 오름차순 정렬
    public static class Brick implements Comparable<Brick>{
        int width,height,weight;
        Brick(int width, int height, int weight){
            this.width =width;
            this.height =height;
            this.weight = weight;
        }
        @Override
        public int compareTo(Brick o) {
            return o.width - this.width;
        }
        @Override
        public String toString(){
            return this.width +" "+ this.height + " " + this.weight;
        }
    }

    public static class Main{
        public static int solution(ArrayList<Brick> bricks){
            int answer = Integer.MIN_VALUE;
            Collections.sort(bricks);
            result[0] = bricks.get(0).height;
            answer = result[0];
            for(int i=1; i< bricks.size(); i++){
                int max_h =0;
                for(int j=i-1; j>=0; j--) {
                    if (bricks.get(j).weight > bricks.get(i).weight && result[j] > max_h) {
                            max_h = result[j];
                    }
                }
                result[i] = max_h + bricks.get(i).height;
                answer = Math.max(answer,result[i]);
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
