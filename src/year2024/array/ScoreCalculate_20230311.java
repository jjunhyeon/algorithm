package year2024.array;

import java.util.Scanner;

/*
*  문제 : 점수계산
*  0과 1을 입력받은 배열에서 1은 문제를 맞춘 경우, 0은 틀린 경우이다
*  연속해서 1이 나오는 경우 가산점을 적용한다 (1,2,3,4,5...) 를 적용해 최종 점수를 리턴하자.
*  풀이 :
*  sum 변수를 만들어 1이 나올 경우 계속 누적시켜 최종 결과에 더했고 0을 만났을 경우 sum을 초기화하면 된다.
* */
public class ScoreCalculate_20230311 {
    static class Main {
        public int solution(int s,int[] k) {

            int result = 0;
            int sum =0;
            for(int i=0; i<s; i++){
                if(k[i] == 1){
                    sum = sum +1;
                    result += sum;
                } else {
                    sum = 0;
                }
            }
            return result;
        }
    }


    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int k[] = new int[s];
        for(int i=0; i<s; i++){
            int num = kb.nextInt();
            k[i] = num;
        }
        System.out.println(T.solution(s,k));
    }
}
