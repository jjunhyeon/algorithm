package greedy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 결혼식
 * 친구가 오는 시간 : 13 , 가는시간 15라면 13시에는 존재 15시 정각에는 존재하지 않는것이다.
 * 피로연장에 동시에존재하는 최대 인원을 구하자.
 * 내부 클래스 정렬 조건 생성 시 time과 info를 활용하는것이 핵심
 * */
public class Wedding_20230527 {
    public static class Time implements Comparable<Time> {
        // 시간, 타입
        int time;
        char info;

        Time(int time, char info) {
            this.time = time;
            this.info = info;
        }

        // 클래스 비교 조건을 재정의하기 위해 생성
        @Override
        public int compareTo(Time o) {
            if(this.time == o.time){
                return this.info - o.info;
            } else {
                return this.time - o.time;
            }
        }

        @Override
        public String toString(){
            return this.time +" "+ this.info;
        }
    }

    public static class Main {
        public static int solution(ArrayList<Time> listArr) {
            Collections.sort(listArr);
            int result = Integer.MIN_VALUE;
            int tmp = 0;
            for (int i = 0; i < listArr.size(); i++) {
                if(listArr.get(i).info=='S'){
                    tmp ++;
                } else{
                    tmp --;
                }
                result = Math.max(result, tmp);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        ArrayList<Time> listArr = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int st = kb.nextInt();
            int et = kb.nextInt();
            listArr.add(new Time(st, 'S'));
            listArr.add(new Time(et, 'E'));
        }
        System.out.println(T.solution(listArr));
    }
}
