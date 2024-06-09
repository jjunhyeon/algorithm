package com.pass.boj.study;

import java.io.*;

/**
 * 문자열 다루기
 */
public class 에디터_시간초과_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String command = bf.readLine();
        int commandCount = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder(command);
        int idx = command.length();
        for(int i=0; i<commandCount; i++){
            String[] curCommand = bf.readLine().split(" ");
            switch(curCommand[0]){
                case "P":
                    sb.insert(idx++,curCommand[1]);
                    break;
                case "L":
                    if(idx > 0 && idx <= sb.length()) idx--;
                    break;
                case "D":
                    if(idx >= 0 && idx < sb.length()) idx++;
                    break;
                case "B":
                    if(idx != 0 ) sb.deleteCharAt(--idx);
            }
        }
        bf.close();
        bw.append(sb);
        bw.close();
    }
}
