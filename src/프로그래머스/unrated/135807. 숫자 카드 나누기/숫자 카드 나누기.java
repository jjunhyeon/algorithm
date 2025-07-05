
import java.util.ArrayList;
class Solution {
    public int solution(int[] arrA, int[] arrB) {
int answerA = Integer.MIN_VALUE;
        int answerB = Integer.MIN_VALUE;

        int maxA = 0;
        int maxB = 0;
        if (arrA.length == 1) {
            maxA = arrA[0];
        } else {
            maxA = gcd(arrA[0], arrA[1]);
        }

        if (arrB.length == 1) {
            maxB = arrB[0];
        } else {
            maxB = gcd(arrB[0], arrB[1]);
        }

        for (int i = 2; i < arrA.length; i++) {
            maxA = gcd(maxA, arrA[i]);
            maxB = gcd(maxB, arrB[i]);
        }

        ArrayList<Integer> agroup = new ArrayList<>();
        ArrayList<Integer> bgroup = new ArrayList<>();

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
     * 유클리드 호제법
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