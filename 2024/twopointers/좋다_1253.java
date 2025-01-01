// N 개의 수 중에서 어떤 수가 다른 수 두개의 합으로 나타낼 수 있다면 그 수를 "쫗다" 라고 한다. GOOD 
package twopointers;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
	static int[] NUMBER_ARRAY;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int NUMBER_COUNT = Integer.parseInt(bf.readLine());
		NUMBER_ARRAY = new int[NUMBER_COUNT];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<NUMBER_COUNT; i++) {
			NUMBER_ARRAY[i] = Integer.parseInt(st.nextToken()); 
		}
	
		// 정렬한다.
		Arrays.sort(NUMBER_ARRAY);
		
        int arrLen = NUMBER_ARRAY.length;
        int count = 0;
        int tmp;

        int left, right;
        for (int i = 0; i < arrLen; i++) {
            tmp = 1;
            left = 0;
            right = arrLen - 1;

            while (left < right) {
                if (NUMBER_ARRAY[left] + NUMBER_ARRAY[right] < NUMBER_ARRAY[i]) left++;
                else if (NUMBER_ARRAY[left] + NUMBER_ARRAY[right] > NUMBER_ARRAY[i]) right--;
                else {
                	// 검사중인(자기 자신)값이 두 수에 포함되지 않기 위해서 일치할경우엔 left 또는 right를 움직여야한다.
                    if (left == i) left++;
                    else if (right == i) right--;
                    else {
                        count += tmp;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
	}
}
