package programmers.level2;

/*
 * 점찍기
 * K 떨어진 위치
 * D 거리
 * 점을 찍는 포인트는 a * k , b * k
 * 거리만큼의 dfs를 그린다.
 * 그 중 k조건에 부합하는 개수의 카운트를 리턴한다.
 * */
public class 점찍기_140107_20230910 {
    static int count = 0;

    public static void main(String[] args) {
        int k = 1;
        int d = 5;
        //long dd = (long) d * d;
        //int[] result = new int[2];
        //dfs( 0, k, d, result);
        solution(k, d);
        System.out.println("what is ans" + count);
    }

    /*
     * dfs .. -> 시간초과
     * */
    public static void dfs(int depth, int condition, int target, int[] result) {
        int maxValue = (int) Math.sqrt((long) target * target - Math.pow(result[0], 2));
        if (depth == 2) {
            if (result[0] % condition == 0 && result[1] % condition == 0) {
                count++;
            }
            return;
        }

        for (int i = 0; i <= maxValue; i++) {
            result[depth] = i;
            dfs(depth + 1, condition, target, result);
            result[depth] = 0;
        }
    }


    /*
     * 해결
     * */
    public static void solution(int k, int d) {
        for (int i = 0; i <= d; i++) {
            // 최대거리 값
            if (i % k == 0) {
                int maxValue = (int) Math.sqrt((long) d * d - Math.pow(i, 2));
                // 최대값의 점의 개수 +1은 0,0 처리
                count += (maxValue / k) + 1;
            }
        }
    }
}

