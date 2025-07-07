package year2024.dfs;

import java.util.Scanner;

/*
* 조합구하기
* 4 2
* -> 1 2
* -> 1 3
* -> 1 4
* -> 2 3 ... 등의 4C2의 값을 DFS를 활용해서 해결하면 된다.
*
* */
public class Combination_20230515 {
    static int n,m;
    static int[] result;
    static class Main{
        public void DFS(int L, int sum){
            if(L == m){
                for(int x : result){
                    System.out.print(x + " ");
                }
                System.out.println();
            } else {
                for(int i=sum; i<=n; i++){
                    result[L] = i;
                    DFS(L+1, i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        result = new int[m];
        T.DFS(0,1);
    }
}
