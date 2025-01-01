package greedy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
* 이중포문으로 풀려하면 시간초과 에러 발생 ->
* 그떄 그 순간의 최적의 결과를 리턴하는 알고리즘(그리디)
* */
public class Player_20230522 {
    static class Body implements Comparable<Body>{
        int h,w;
        Body(int h, int w){
            this.h = h;
            this.w = w;
        }
        // h(키)를 기준으로 정렬하기 위해 재정의한다.
        @Override
        public int compareTo(Body o){
            return o.h - this.h;
        }
        // 내부 value 확인을 위해 Override
        /*@Override
        public String toString(){
            return this.h +" "+ this.w;
        }*/
    }

    static class Main {
        public static int solution(ArrayList<Body> arr, int k){
            int cnt = 0;
            // compareTo 재정의를 통해 정렬을 키를 기준으로 처리한다
            // 만약 재정의를 하지 않으면 ClassCastException 발생
            Collections.sort(arr);
            int weight = Integer.MIN_VALUE;
            for(Body x : arr){
                // 신규로 들어온 인원의 몸무게가 이전의 선수들의 몸무게보다 크다면 선발기준에 충족
                if(x.w > weight){
                    cnt ++;
                    weight = x.w; // 선발인원의 값을 늘리고 늘린 선수의 몸무게를 기준점으로 대체한다.
                }
            }
            return cnt;
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<k; i++){
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(T.solution(arr,k));
    }
}
