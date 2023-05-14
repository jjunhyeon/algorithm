package com.pass.algostudy.dfs;

import java.util.Scanner;

/*
* 바둑이
* 최대 무게가 주어졌을 때
* 가장 최대 무게에 근접한 멍멍이를 데리고 나가는 값을 찾아 그 무게를 리턴해라.
* 1. 조합
* 2. 0번 인덱스의 값을 root로 하고 케이스를 그린다.
* 3. 만약 최대무게를 초과해버리면 return 한다
* 4. 그렇지 않는 케이스 중 최대값 리턴
* */
public class Badook_20230512 {

    static int[] value;
    static int result = 0;
    static int max =0;
    static class Main {
        public void BDFS(int sum, int L) {
            if(max < sum){
                return;
            }
            if(L == value.length){
                result = Math.max(sum,result);
            } else {
                BDFS(sum + value[L],L+1);
                BDFS(sum , L+1);
            }
        }
    }
    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        max = kb.nextInt();
        int s = kb.nextInt();
        value = new int[s];
        for(int i=0; i<s; i++){
            value[i] = kb.nextInt();
        }
        T.BDFS(0,0);
        System.out.println(result);
    }
}
