package year2025.month7;

/*
* 중복값이 존재하지 않는 오름차순 정렬된 배열에서 
* 타겟 정보의 값이 존재하면 인덱스를 반환하고 없으면 -1을 리턴해라.
* 0709 실패
* 0710 재도전 
*/
public class SearchInRotatedSortedArray_0709 {
	public static void main(String[] args) {
		int[] num = new int[] {1,3};
		solution(num, 3);
	}

	private static int solution(int[] num, int target) {
		
		int left =0;
		int right = num.length -1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			// 내가 찾는값보다 num[mid] 정보가 우측에 있으면 
			if(num[mid] == target) return mid;
			
			if(num[left] <= num[mid]) { // 왼쪽이 정렬상태
				if(num[left] <= target && target < num[mid]) {
					right = mid - 1;
				} else {
					left = mid +1;
				}
			} else { // 오른쪽 정렬상태
				if(num[mid] < target && target <= num[right]) {
					left = mid + 1;
				} else {
					right = mid -1;
				}
			}
		}
		return -1;
	}
}
