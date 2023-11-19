class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answerBuilder = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        // 0부터 시작
        answerBuilder.append(0);
        for(int i=1; answerBuilder.length() < t * m; i++){
            answerBuilder.append(changeNumberFormationByDecimal(n,i));
        }

        for(int i=0; i<answerBuilder.length(); i++){
            if(answer.length() == t) break;
            
            int validateNumber = i % m;
            if(validateNumber + 1 ==p) answer.append(answerBuilder.charAt(i));
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