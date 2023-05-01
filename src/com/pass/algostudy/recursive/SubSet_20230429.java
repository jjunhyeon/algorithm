package com.pass.algostudy.recursive;

public class SubSet_20230429 {
    static class Main{
        static int n;
        //부분 집합 체크용
        static int[] ch;
        public void DFS(int L){
            if(L == n+1){
                String tmp="";
                for(int i=0; i<=n; i++){
                    if(ch[i] == 1){
                        tmp += (i + " ");
                    }
                }
                if(tmp.length() > 0){
                    System.out.println(tmp);
                }
            } else {
                // 두갈래로 뻗기
                ch[L] = 1;
                DFS(L+1);
                ch[L] = 0;
                DFS(L+1);
            }
        }

        public static void main(String[] args){
            Main T = new Main();
            n = 3;
            ch = new int[n+1];
            T.DFS(1);
        }
    }
}
