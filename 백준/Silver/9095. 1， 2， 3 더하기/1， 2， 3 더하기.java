
import java.util.Scanner;

/*
 * 1, 2, 3 더하기
 * 정수 N을 1,2,3의 합으로 나타내는 방법을 구하자
 * */
public class Main {
    static int[] storage = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        for (int i = 0; i < numCount; i++) {
            int k = sc.nextInt();
            // k 시작
            System.out.println(makeSum(k));
        }
    }

    private static int makeSum(int k) {

        if(storage[k] > 0) {
            return storage[k];
        }

        if (k == 1) {
            return storage[k] = 1;
        } else if (k == 2) {
            return storage[k] = 2;
        } else if (k == 3) {
            return storage[k] = 4;
        } else {
            return makeSum(k - 3) + makeSum(k - 2) + makeSum(k - 1);
        }
    }
}
