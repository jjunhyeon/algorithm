package greedy2;

/*
* 강의 n일 안에와서 강의를 해주면 n만큼의 돈을 줄때
* 최대로 돈을 번 금액을 리턴하자.
* */
import java.util.*;

public class Lecture_20230527 {
    public static int maxDay = Integer.MIN_VALUE;
    public static class Lecture implements Comparable<Lecture> {
        int money,day;

        Lecture(int money, int day){
            this.money = money;
            this.day =day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day;
        }

        @Override
        public String toString(){
            return this.money +" "+ this.day;
        }
    }
    public static class Main {

        public static int solution(List<Lecture> arr) {
            Collections.sort(arr);
            int maxMoney = 0;
            int day = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = maxDay; i>=1; i--){
                for(; day<arr.size(); day++){
                    if(arr.get(day).day < i){
                        break;
                    } else{
                        pq.offer(arr.get(day).money);
                    }
                }
                if(!pq.isEmpty()){
                    maxMoney += pq.poll();
                }
            }
            return maxMoney;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        List<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int money = kb.nextInt();
            int day = kb.nextInt();
            arr.add(new Lecture(money,day));
            if(maxDay < day){
                maxDay = day;
            }
        }
        System.out.println(T.solution(arr));
    }
}
