package com.pass.boj.class3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coin_20230529 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int money = kb.nextInt();
        int answer = 0;
        Integer[] coinType = new Integer[k];
        for(int i=0; i<k; i++){
            coinType[i] = kb.nextInt();
        }

        // 큰 돈순으로 정렬
        Arrays.sort(coinType, Collections.reverseOrder());
        for(int i=0; i<k; i++){
            if(coinType[i] <= money){
                answer += (money / coinType[i]);
                money = money % coinType[i];
            }
        }
        System.out.println(answer);
    }
}
