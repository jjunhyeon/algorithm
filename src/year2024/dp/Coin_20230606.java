package src.year2024.dp;

import java.util.Arrays;
import java.util.Scanner;
/*
* 동전교환(냅색 알고리즘)
* dy[i] : i 금액을 만드는데 드는 최소 동전 개수
* dy[10] : 10원을 만드는데 필요한 동전의 개수
* */
public class Coin_20230606 {
    static int[] dy; // 최초는 가장 큰 값으로 초기화
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int coinTypeCount = kb.nextInt();
        Integer[] coinType = new Integer[coinTypeCount];
        for(int i=0; i<coinTypeCount; i++){
            coinType[i] = kb.nextInt();

        }
        int money = kb.nextInt();
        dy = new int[money+1];
        Arrays.fill(dy,Integer.MAX_VALUE);
        dy[0] = 0;

        for(int i=0; i<coinTypeCount; i++){
            for(int j=coinType[i]; j<=money; j++){
                dy[j] = Math.min(dy[j], dy[j-coinType[i]] + 1);
            }
        }
        System.out.println(dy[money]);
    }
}
