import java.util.*;
class Solution {
    public int solution(int[] citations) {
		Arrays.sort(citations);
		int len = citations.length;

        for (int i = 0; i < len; i++) {
            // 현재 논문이 인용된 횟수가 hIndex보다 크거나 같은지 확인
            int hIndex = len - i;
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }
		
		return 0;
    }
}