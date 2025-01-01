package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 집합
* */
public class Set_11723_20230611 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21]; // 집합의 원소 범위: 1부터 20
        StringBuilder sb = new StringBuilder(); // 출력을 모아서 처리하기 위한 StringBuilder
        for(int i=1; i<=count; i++){
            String input = br.readLine().trim();
            String[] ds = input.split(" ");
            int num = 0;

            if(!(ds[0].equals("all") || ds[0].equals("empty"))){
                num = Integer.parseInt(ds[1]);
            }

            if(ds[0].equals("add")){
                set[num] = true;
            } else if(ds[0].equals("check")){
                sb.append(set[num] ? "1\n" : "0\n");
            } else if(ds[0].equals("remove")){
                set[num] = false;
            } else if(ds[0].equals("all")){
                for (int j = 1; j <= 20; j++) {
                    set[j] = true;
                }
            } else if(ds[0].equals("toggle")){
                set[num] = !set[num];
            } else if(ds[0].equals("empty")){
                for (int j = 1; j <= 20; j++) {
                    set[j] = false;
                }
            }
        }

        System.out.print(sb.toString()); // 모아둔 출력 결과를 한 번에 출력
    }
}
