package year2025.month7;

/*
* 중복값이 존재하지 않는 오름차순 정렬된 배열에서 
* 타겟 정보의 값이 존재하면 인덱스를 반환하고 없으면 -1을 리턴해라. 
*/
public class SearchInRotatedSortedArray_0709 {
	public static void main(String[] args) {
		int[] num = new int[] {1,3};
		System.out.println(":::" + solution(num, 3));
	}

	private static int solution(int[] num, int target) {
		
		int left =0;
		int right = num.length -1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			// 내가 찾는값보다 num[mid] 정보가 우측에 있으면 
			if(num[right] < num[mid]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		if(target == num[left]) {
			return left;
		}
		
		// left가 다시 left인 지점
		int findLeft = 0;
		int findRight = 0;
		if(target > num[left]) {
			findLeft = left;
			findRight = num.length-1;
		} else {
			findLeft = 0;
			findRight = left;
		}
	
		while(findLeft < findRight) {
			int mid = (findLeft + findRight) / 2;
			// 내가 찾는값보다 num[mid] 정보가 우측에 있으면 
			if(target == num[mid]) {
				return mid;
			}
			
		    if (num[mid] < target) {
		        findLeft = mid + 1;
		    } else {
		        findRight = mid - 1;
		    }
		}

		return -1;
	}
}
