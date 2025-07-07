/*
*
* 7월 첫번째 문제
* 주식 팔기 문제
* output : 5 
* 12 : 00 ~ 12 : 15(solve)  
* 
 * - 주어진 배열은 하루 단위의 주식 가격이다.
 * - 단 한 번의 거래(1회 매수 후 1회 매도)로 얻을 수 있는 최대 이익을 구하라.
 * - 이익이 없을 경우 0을 반환한다.
 *
 * 예:
 * [7,1,5,3,6,4] → 5 (1에 사서 6에 팜)
 * [7,6,4,3,1] → 0 (계속 하락하므로 이익 없음)
 * 
 * 
 * 보완한 내용
 * 1) 변수명 모호함 
 * : target -> minPrice
 * 
 * 2) 예외처리
 * : 만약 리스트가 비어있거 길이가 1일때에 대한 처리
*/
package year2025.month7;



public class leetCode_BestTimeToBuyandSellStock_0703 {
	public static void main(String[] args) {
		//int[] prices1 = new int[] { 7, 1, 5, 3, 6, 4 };
		int[] prices2 = new int[] {7,6,4,3,1};
		int answer = solution(prices2);
	}

	private static int solution(int[] prices) {
		// 배열이 null이거나 길이가 1이라면 수익은 없다.
		if(prices == null || prices.length <= 1) {
			return  0;
		}
		// 예사 시간복잡도 for 루프를 통해 전체 탐색이므로 O{N}
		// 초기값 0시에 바로 주식을 샀다고 가정
		int minPrice  = prices[0];
		int maxProfit = 0; // 갱신할 최대 이익 
		int len = prices.length;
		
		for (int i = 1; i < len; i++) {
			if(minPrice > prices[i]) { 
				// 더 싼 가격이 나올경우, 최저 가격을 갱신한다.
				minPrice = prices[i];
			} else { 
				// 최저 가격과 지금 가격의 차익을 계속 최대값으로 갱신해준다.
				maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			}
		}
		return maxProfit > 0 ? maxProfit : 0;
	}
}
