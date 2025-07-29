package year2025.month7;

/**
* Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
* [4,5,6,7,0,1,2] if it was rotated 4 times.
* [0,1,2,4,5,6,7] if it was rotated 7 times.
* Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
* Given the sorted rotated array nums of unique elements, return the minimum element of this array.
* You must write an algorithm that runs in O(log n) time
 */
public class FindMinimuminRotatedSortedArray_0708 {

	public static void main(String[] args) {
		int[] nums2 = new int[] {4,5,6,7,0,1,2};
		//solution(nums2);
		solution(nums2);
	}

	private static int solution(int[] num) {
		// integer.MAX_VALUE시 num[0] 케이스 처리 못함, -> num[0] 변경
		int answer = num[0];
		int left = 0;
		int right = num.length - 1;

		while(left < right) {
			int mid = (left + right) / 2;
			
			// 생각한 중위값이 우측지점보다 오른쪽에 있으면
			if(num[mid] > num[right]) {
				// 가장 왼쪽 left를 중위값 오른쪽으로 옮기고
				left = mid + 1;
			} else {
				// 생각한 중위값이 왼쪽에 있으면 범위를 좁히기 위해
				right = mid;
			}
			
			answer = Math.min(answer, num[left]);
		}
		
		return answer;
	}
}
