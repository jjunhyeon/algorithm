package year2024.dfs;

import java.util.Scanner;

/*
 * 합이 같은 부분집합
 * 배열의 원소에 대해 임의의 부분집합 2개를 뽑았을 때 합이 같은 케이스가 있으면 확인해서 Boolean Return
 * DFS를 활용한다.
 * 왜? 모든 케이스를 알아내기 위해
 * D(1)부터 D(N)까지의 케이스에 대해 값을 사용한다 사용하지 않는다로 분류해 이진트리를 그려나간다.
 *
 * */
public class SameSum_20230502 {
    static String answer = "NO";
    static int[] array;
    static int total;
    static boolean flag = false;

    static class Main {
        public void DFS(int L, int sum, int[] arr) {
            // total - sum = sum이 존재했을 때 flag true
            if(flag){
                return;
            }
            if(L == array.length){ // arr+1이 되었을 때
                // end;
                if(total - sum == sum){
                    answer = "YES";
                    flag = true;
                }
            } else {
                // 두갈래로 뻗기
                DFS(L+1,sum + array[L], array);
                DFS(L+1,sum , array);
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = kb.nextInt();
            total += array[i];
        }
        T.DFS(0,0,array);
        System.out.println(answer);
    }
}
