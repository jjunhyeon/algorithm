package com.pass.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
* 비밀번호 찾기
* */
public class Password_17219_20230612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] counts = br.readLine().split(" ");
        int infoCount = Integer.parseInt(counts[0]);
        int pCount =  Integer.parseInt(counts[1]);
        String[] passwordInfo = new String[pCount];

        HashMap<String, String> info = new HashMap<>();
        for (int i = 0; i < infoCount; i++) {
            String[] st = br.readLine().split(" ");
            info.put("domain", st[0]);
            info.put("password", st[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pCount; i++) {
            String p = br.readLine();
            if(p.equals(info.get("domain"))){
                sb.append(info.get("password")).append('\n');
            }
        }
    }
}
