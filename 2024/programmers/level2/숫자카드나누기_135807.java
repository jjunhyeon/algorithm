package programmers.level2;

import java.util.ArrayList;

/*
 * 1. 최대 공약수를 구한다.
 * 2. 최대 공약수중 상대 배열을 나눌 수 없는 최대의 값을 구한다.
 * */
public class 숫자카드나누기_135807 {
    public static void main(String[] args) {
        /*int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};*/
        int[] arrayA = {5};
        int[] arrayB = {8};
        int result = solution(arrayA, arrayB);
    }

    public static int solution(int[] arrA, int[] arrB) {
        int answerA = Integer.MIN_VALUE;
        int answerB = Integer.MIN_VALUE;

        int maxA = 0;
        int maxB = 0;

        // arrA와 arrB의 길이는 같음
        if (arrA.length == 1) {
            maxA = arrA[0];
            maxB = arrB[0];
        } else {
            maxA = gcd(arrA[0], arrA[1]);
            maxB = gcd(arrB[0], arrB[1]);
        }
        
        // 각 arr의 최대공약수 구함
        for (int i = 2; i < arrA.length; i++) {
            maxA = gcd(maxA, arrA[i]);
            maxB = gcd(maxB, arrB[i]);
        }

        ArrayList<Integer> agroup = new ArrayList<>();
        ArrayList<Integer> bgroup = new ArrayList<>();
        
        // 각 ARR의 약수를 구하면서 상대 배열의 값으로 나누어지는지 확인 후 최대 값 바로 리턴
        for (int i = maxA; i > 0; i--) {
            if (maxA % i == 0) {
                agroup.add(i);
                for (int j = 0; j < arrB.length; j++) {
                    // 나누어 떨어지지 않았으면
                    if (arrB[j] % i == 0) {
                        answerA = 0;
                        break;
                    }
                }
                if (answerA == 0) {
                    break;
                } else {
                    answerA = i;
                    break;
                }
            }
        }

        for (int i = maxB; i > 0; i--) {
            if (maxB % i == 0) {
                bgroup.add(i);
                for (int j = 0; j < arrA.length; j++) {
                    // 나누어 떨어지지 않았으면
                    if (arrA[j] % i == 0) {
                        answerB = 0;
                        break;
                    }
                }
                if (answerB == 0) {
                    break;
                } else {
                    answerB = i;
                    break;
                }
            }
        }
        return (answerA >= answerB) ? answerA : answerB;
    }

    /*
     * 유클리드 호제법(최대 공약수 구하기)
     * */
    public static int gcd(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = a;
            a = b;
            b = (tmp % a);
        }
        return a;
    }
}
