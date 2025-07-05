package src.year2024.study;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수찾기
 * 이분탐색 해결
 * 2023-06-09
 */
public class 수찾기_1920 {
    static int[] searchArray;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        searchArray = new int[N];

        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            searchArray[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());
        int[] numberArray = new int[M];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++){
            numberArray[i] = Integer.parseInt(st.nextToken());
        }
        bf.close();
        // 이분 탐색을 위한 searchArray 정렬
        Arrays.sort(searchArray);
        for(int findNum : numberArray){
            if(binarySearch(findNum)) bw.append("1");
            else bw.append("0");
            bw.append("\n");
        }
        bw.close();
    }

    public static boolean binarySearch(int target){
        int left = 0;
        int right = searchArray.length - 1;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            // 찾을값이 미드 값보다 크다면 범위를 미드보다 크게 좁힌다.
            // 찾을 값이 미드 값보다 작다면 right값의 범위를 미드 - 1 로 처리
            if(searchArray[mid] < target) left = mid + 1;
            else if(searchArray[mid] > target) right = mid - 1;
            else return true;
        }
        return false;
    }
}
