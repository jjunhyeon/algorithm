package year2024.class4;

import java.util.Scanner;

/*
* 2 * n 타일링
* DP
* 오버플로우에 주의해야하는 문제이다.
* int 범위를 벗어난 값에 대한 처리를 유의해야하는 문제
* */
public class Tile_11726_0804 {

    static int[] arrs = new int[1001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    public static int solution(int target){
        // 메모이제이션 활용해야함
        if(arrs[target] > 0){
            return arrs[target];
        }

        if(target == 1){
            return arrs[1] =1;
        } else if (target == 2){
            return arrs[2] =2;
        } else {
            arrs[target] = arrs[target-1] + arrs[target-2];
        }

        return arrs[target] = (solution(target-1) + solution(target-2)) % 10007;
    }
}
