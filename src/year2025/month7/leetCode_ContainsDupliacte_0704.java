package year2025.month7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 주어진 배열을 바탕으로 모두 distinct 한 값을 가지고 있으면 false 중복된 값이 하나라도 있으면 true를 리턴해라.
 * -> 그냥 문제 그 그대로 구현하면 될 것같다. 12 : 25 시작 45 종료
 * 
 * 개선 )
 * Map -> HashSet을 활용한다.
 *          MAP            HASH SET 
 * 목적 : 키 값 저장 //    값의 유일성 판단
 * 연산 수 : GET + PUT  //  ADD 1번
 * 메모리 사용량 : Entry<Key, Value> 객체 다수 // 값 없는 단순 구조
 * 성능 기대 : 보토   // map 보다 우수
 */
public class leetCode_ContainsDupliacte_0704 {

	public static void main(String[] args) {
		// int[] nums1 = new int[] {1,2,3,1};
		// 모두 distinct 하므로 false
		int[] nums2 = new int[] { 1, 2, 3, 4 };
		//solution(nums2);
		solutionWithHashSet(nums2);
	}

	private static boolean solutionWithHashSet(int[] nums) {
		Set<Integer> hashSet = new HashSet<>();
		for(final int i : nums) {
			// HashSet의 add 메서드는 중복체크와 삽입을 동시에 한다.
			if(!hashSet.add(i)) {
				return true;
			}
		}
		return false;
	}

	private static boolean solution(int[] nums) {
		// map 활용해서 값에 대해서 체크하고 만약 존재한다면 바로 false 처리하면 될 것이다.
		Map<Integer, Integer> isDuplicatedMap = new HashMap<>();
		for (final int i : nums) {
			if (!Objects.isNull(isDuplicatedMap.get(i))) {
				return true;
			} else {
				isDuplicatedMap.put(i, isDuplicatedMap.getOrDefault(i, 0) + 1);
			}
		}
		return false;
	}
}
