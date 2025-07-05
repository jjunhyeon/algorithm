package src.year2024.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * ATM
 * : 최소의 시간을 구하는 프로그램 만들기
 * */
public class ATM_11399_20230618 {
    public static void main(String[] args) throws IOException {
        // 입력값 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pCount = Integer.parseInt(br.readLine());
        ArrayList<Integer> minimumArray = new ArrayList<Integer>();

        // 1부터 인덱스를 시작하기 위해
        int result[] = new int[pCount + 1];

        String[] value = br.readLine().split(" ");
        for (int i = 0; i < pCount; i++) {
            minimumArray.add(Integer.parseInt(value[i]));
        }
        //  오름차순 정렬
        Collections.sort(minimumArray);

        // 누적합을 가지는 배열 생성
        for (int i = 1; i <= pCount; i++) {
            for (int j = i - 1; j >= 0; j--) {
                result[i] += minimumArray.get(j);
            }
        }

        // 배열의 합 => 정답
        int sum = 0;
        for (int i = 1; i < result.length; i++) {
            sum += result[i];
        }

        System.out.println(sum);
    }
}
