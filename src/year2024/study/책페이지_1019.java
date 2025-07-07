package year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 책페이지_1019 {
    static int[] cnt = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int targetNum = Integer.parseInt(bf.readLine());

        int start = 1;
        int digit = 1;
        // 초기값보다 입력값이 작아질대까지
        while(start <= targetNum){

            while(start % 10 != 0 && start <= targetNum){
                count(start,digit);
                start ++;
            }

            while(targetNum % 10 != 9 && start <= targetNum){
                count(targetNum, digit);
                targetNum--;
            }

            if(start > targetNum) break;

            // 마지막 자릿수를 제거한다.
            start /= 10;
            targetNum /= 10;

            for(int i=0; i<10; i++){
                cnt[i] += (targetNum - start +1) * digit;
            }

            digit = digit * 10;
        }

        for(long c : cnt) System.out.print(c + " ");
    }

    private static void count(int n, int digit) {
        while(n > 0){
            // cnt 배열에 값 적재
            cnt[n % 10] += digit;
            n = n / 10;
        }
    }
}
