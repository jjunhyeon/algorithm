package src.year2024.sorting;

import java.util.Scanner;

/*
 * 버블정렬(Bubble Sort)
 * 버블 정렬은 인접한 두 값을 비교하여 큰 값을 오른쪽으로 이동시키는 방법으로 동작합니다. 이를 반복하여 전체 배열을 정렬합니다.
 * 장점 : 구현이 간단하며 코드가 직관적이다.
 * 단점 : 시간 복잡도가 O(N^2)로 비효율적이다.
 * 풀이 :
 * for문의 i가 증가하더라도 배열의 0번째부터 배열의 다음값과 다시 비교하기 위한 로직 처리를 해야한다.
 * 또한 i가 증가하면 배열의 마지막 자릿값은 값이 확정지어지므로,  비교 대상을 줄여나가면서 처리해야 효율을 최적화 할 수 있다.
 * */
public class BubbleSort_20230409 {
    // 실제 Solution
    static class Main {
        public String solution(int n, int[] array) {
            String result = "";
            for (int i = 0; i < array.length - 1; i++) {
                // i값이 증가하면 마지막 배열의 값은 확정되기 때문에 i값이 증가함에 따라 마지막 배열은 순회하지 않는다.
                int rt = array.length - 1 - i;
                int tmp = 0;
                while (tmp < rt) {
                    int next = array[tmp + 1];
                    if (array[tmp] > array[tmp + 1]) {
                        array[tmp + 1] = array[tmp];
                        array[tmp] = next;
                    }
                    tmp++;
                }
            }


            for (int i = 0; i < array.length; i++) {
                result += array[i] + " ";
            }

            return result;
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, array));
    }
}
