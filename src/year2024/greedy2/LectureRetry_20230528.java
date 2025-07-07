package year2024.greedy2;

import java.util.*;

/*
 * Lecture 문제 재도전
 * */
public class LectureRetry_20230528 {

    public static int maxDay = 0;
    public static class Lecture implements Comparable<Lecture>{
        int money,day;
        Lecture(int time,int day){
            this.money = time;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day;
        }
    }


    public static class Main{
        public static int solution(List<Lecture> arr){
            Collections.sort(arr); // day기준으로 정렬 (위 compareTo 오버라이드)
            // 우선순위큐 선언 (최대 금액부터 정렬시키기 위해 reverOrder 적용)
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int money =0;
            int j =0;
            for(int i=maxDay; i>=1; i--){
                for(; j<arr.size(); j++){
                    if(i > arr.get(j).day){
                        break;
                    } else {
                        pq.offer(arr.get(j).money);
                    }
                }
                if(!pq.isEmpty()){
                    money += pq.poll();
                }
            }
            return money;
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        List<Lecture> arr = new ArrayList<>();
        for(int i=0; i<k; i++){
            int time = kb.nextInt();
            int day = kb.nextInt();
            arr.add(new Lecture(time,day));
            if(maxDay < day){
                maxDay = day;
            }
        }

        System.out.println(T.solution(arr));
    }
}
