package year2024.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Partner_20230419 {
    // Solution
    static class Main {
        public String solution(int size, int[] array) {
            String answer = "";

            int[] tmp = array.clone();
            Arrays.sort(tmp);

            for(int i=0; i<size; i++){
                if(array[i] != tmp[i]){
                    answer += i+1 + " ";
                }
            }

            return answer;
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        System.out.println((T.solution(n, array)));
    }
}
