package year2024.programmers;

// while문 활용해 n이 1이 아니라면 n/2-> 절반값 +1
// n/2 보다 작은값에 대해서만 시작
// n-> 3부터 시작임
// 3이상일경우
// n -> (n + n+1)
// 연속한 자연수로 표현해야해
// i, i+1 ,i+2 ... = 0 값을 세팅
public class MathStudy_20230429 {

    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static int solution(int n) {
        int answer = 0;

        if (n < 3) {
            return 1;
        } else {
            for (int i = 1; i <= n / 2; i++) {
                int target = 0;
                int lt = i;
                while (lt <= n) {
                    if (target == n) {
                        answer += 1;
                        break;
                    } else if (target > n) {
                        break;
                    } else {
                        target += lt;
                    }
                    lt++;
                }
            }
        }
        return answer + 1;
    }
}
