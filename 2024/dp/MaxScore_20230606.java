package dp;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * dy[j] -> 최대점수(n분이 있을때 얻을 수 있는 최대 점수)
 * m -> 최대시간
 * 유한개면 뒤에서부터 앞으로 순회
 * */
public class MaxScore_20230606 {
    static int[] dy;
    static int limitTime;
    public static class Problem{
        int ps, pt; // 문제 점수, 문제 푸는 시간
        Problem(int ps, int pt){
            this.ps = ps;
            this.pt = pt;
        }
    }
    public static class Main{
        public static int solution(ArrayList<Problem> arrs){
            dy[0] = 0;
            for(int i=0; i<arrs.size(); i++){
                int time = arrs.get(i).pt;
                for(int j=limitTime; j>=time; j--){
                    dy[j] = Math.max(dy[j],dy[j - arrs.get(i).pt] + arrs.get(i).ps);
                }
            }
            return dy[limitTime];
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int problemCount = kb.nextInt();
        limitTime = kb.nextInt();
        dy = new int[limitTime+1];
        ArrayList<Problem> arrs= new ArrayList<>();
        for(int i=0; i<problemCount; i++){
            int ps = kb.nextInt();
            int pt =kb.nextInt();
            arrs.add(new Problem(ps,pt));
        }
        System.out.println(T.solution(arrs));
    }
}
