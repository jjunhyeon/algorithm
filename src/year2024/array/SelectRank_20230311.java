package src.year2024.array;

import java.util.Scanner;

/*
 *  등수구하기
 *  첫 줄에 점수의 개수, 두번째 줄에는 국어점수가 입력된다.
 *  점수의 순서대로 등수를 출력한다.
 *  방법 :
 *
 * */
public class SelectRank_20230311 {

    static class Main {
        public String solution(int s, int[] k) {

            String result = "";
            int[] rank = new int[s];

            // 순서 정렬 안한다면
            int tmp = 0;
            for (int i = 0; i < s; i++) {
                int num = 0;
                for (int j = 0; j < s; j++) {
                    if (k[i] == k[j] && i != j) { // 같은 수에 대해서 같은 등수로 처리
                        // 같은 값이라면
                        // k[i] = k[j] 이고 그 다음 순이 값에 대해선 + 같은 값의 갯수만큼 증가해야함
                        tmp++;
                    } else if (k[i] < k[j]) {
                        num++;
                    }
                }
                if(tmp == 0){
                    rank[i] = s - (s - num - 1) ;
                } else {
                    rank[i] = s - (s - num ) + 1;
                }
                //rank[i] = s - (s - num) + tmp;
                tmp = 0; // 같은 등수 초기화
            }

            for (int i = 0; i < rank.length; i++) {
                result += rank[i] + " ";
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
        for (int i = 0; i < s; i++) {
            int num = kb.nextInt();
            k[i] = num;
        }
        System.out.println(T.solution(s, k));
    }
}
