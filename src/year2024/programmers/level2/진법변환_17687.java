package src.year2024.programmers.level2;


/*
 * 진법 변환기
 * 1. 10진수의 값을 바탕으로 해당 진법의 수로 바꾸는 메서드를 생성한다.
 * 2. 미리 구할 숫자의 개수 값까지 진법 변환기를 사용해 FULL STRING을 만든다.
 * 3. FULL STRING을 인원이랑 순서에 맞춰 나눈 후 부분 STR을 정답에 더해서 리턴한다. 끝
 * */
public class 진법변환_17687 {
    public static void main(String[] args) {
        // 진법 
        int n = 2;
        // 구해야할 숫자
        int t = 4;
        // 게임에 참여하는 인원
        int m = 2;
        // 튜브의 순서
        int p = 1;
        solution(n, t, m, p);
    }

    /*
     * n : 바꿀 진법 정보
     * t : 구해야할 숫자
     * m : 인원
     * p : 순서
     * */
    private static String solution(int n, int t, int m, int p) {
        StringBuilder answerBuilder = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        // 0부터 시작
        answerBuilder.append(0);
        for (int i = 1; answerBuilder.length() < t * m; i++) {
            answerBuilder.append(changeNumberFormationByDecimal(n, i));
        }

        for (int i = 0; i < answerBuilder.length(); i++) {
            if (answer.length() == t) break;
            int validateNumber = i % m;
            if (validateNumber + 1 == p) answer.append(answerBuilder.charAt(i));
        }

        return answer.toString();
    }

    /*
     * n : 바꿀 진법 정보
     * target : 바꿀 10진법 수
     * */
    private static String changeNumberFormationByDecimal(int n, int target) {
        StringBuilder resultBuilder = new StringBuilder();
        while (target >= 1) {
            int remain = target % n;
            if (remain >= 10) {
                char hexChar = (char) ('A' + (remain - 10));
                resultBuilder.append(hexChar);
            } else {
                resultBuilder.append(remain);
            }
            target = target / n;
        }
        return resultBuilder.reverse().toString();
    }
}
