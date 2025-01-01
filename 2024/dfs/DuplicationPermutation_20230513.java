package dfs;

import java.util.Scanner;

/*
*  중복순열
*
* */
public class DuplicationPermutation_20230513 {
    static int[] pm;
    static int n = 0;
    static int arraySize =0;
    static class Main {
        public void DFS(int L) {
            // 깊이가 끝에 도달했다면
            if(L == arraySize){
               for(int x: pm){ // 담겨있는 array 찍기
                   System.out.print(x + " ");
               }
                System.out.println();
            } else {
                // 이진 탐색이 아닌 n중 탐색이므로
                for(int i=1; i<=n; i++){
                    pm[L] =i; // pm[L]에 값을 담는다.
                    DFS(L+1);
                }
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arraySize = kb.nextInt();
        pm = new int[arraySize];
        T.DFS(0);
    }
}
