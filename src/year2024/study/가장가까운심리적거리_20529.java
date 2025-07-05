package src.year2024.study;

import java.io.*;
import java.util.StringTokenizer;

public class 가장가까운심리적거리_20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            int min = 12;
            int N = Integer.parseInt(br.readLine());

            if(N > 32) {
                bw.append("0").append("\n");
                continue;
            }
            String[] arr = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = st.nextToken();
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int cnt = 0;
                    for (int k = j + 1; k < arr.length; k++) {
                        for(int m = 0; m < 4; m++) {
                            cnt += arr[i].charAt(m) != arr[j].charAt(m) ? 1 : 0;
                            cnt += arr[i].charAt(m) != arr[k].charAt(m) ? 1 : 0;
                            cnt += arr[j].charAt(m) != arr[k].charAt(m) ? 1 : 0;
                        }
                        min = Math.min(cnt, min);
                        if(min == 0) break;
                    }

                }
            }
            bw.append(Integer.toString(min)).append("\n");
        }
        br.close();
        bw.close();
    }
}
