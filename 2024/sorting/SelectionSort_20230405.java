package sorting;

import java.util.Scanner;
/*
* 선택정렬
* 입력받은 값을 반복문을 통해 탐색하며
* 가장 작은 값을 찾아 배열의 맨 앞에 위치시키는 방법으로 동작합니다. 이를 반복하여 전체 배열을 정렬합니다.
* 장점 : 구현이 간단하며 코드가 직관적입니다.
* 단점 : 시간 복잡도가 O(N^2)로 비효율적입니다.
* */
public class SelectionSort_20230405 {
    // 실제 Solution
    static class Main {
        public String solution(int n, int[] array) {
            String result = "";
            for(int i=0; i<array.length; i++){
                int tmp = i;
                for(int j=i+1; j<n; j++){
                    // 더 작은 idx값 저장 최종 tmp는 array[i]위치에 들어갈 값
                    if(array[tmp] > array[j]){
                        tmp = j;
                    }
                }
                // 값 위치 바꾸기
                int t = array[tmp];
                array[tmp] = array[i];
                array[i] = t;
                
                // 결과를 바로바로 result에 추가한다
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
        for(int i=0; i<n; i++){
            array[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,array));
    }
}
