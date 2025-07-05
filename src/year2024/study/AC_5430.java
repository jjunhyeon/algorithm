package src.year2024.study;


import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;


/*
 * AC
 * 정수배열에 연산을 하기 위해 만든 언어
 *
 * 두 가지 함수가 있다.
 * R(뒤집기), D(버리기)
 *
 * 값에 대핸 reverse를 자유롭게 처리하기 위해 deque를 사용한다.
 * */
public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (caseCount-- > 0) {
            boolean reverseStatus = false;
            String method = bf.readLine();
            int arrayLen = Integer.parseInt(bf.readLine());
            String input = bf.readLine();
            // [] 대괄호 삭제 , 배열로 저장
            input = input.substring(1, input.length() - 1);
            String[] array = input.split(",");

            int deleteCount = 0;
            for (int i = 0; i < method.length(); i++) {
                if (method.charAt(i) == 'D') deleteCount++;
            }

            if (deleteCount > arrayLen) {
                bw.write("error\n");
                continue;
            }

            // 애초에 array의 d가 arrayLen보다 많으면 그냥 break 가능
            Deque<String> deque = new ArrayDeque<>();
            for (int i = 0; i < array.length; i++) {
                deque.add(array[i]);
            }

            // 하나씩 처리
            for (int i = 0; i < method.length(); i++) {
                // 그냥 뒤집으면 시간초과 문제 발생
                // 전체 R의 개수를 파악한 뒤 , 홀수 짝수의 status만 맞추고 홀수일경우 한번만 뒤집는다.
                // R 이라면 뒤집기
                if (method.charAt(i) == 'R') {
                    // 뒤집어서 다시 자기 자신의 값을 업데이트
                    if (reverseStatus) reverseStatus = false;
                    else reverseStatus = true;
                } else { // 삭제처리
                    // 뒤집은 상태라면
                    if (reverseStatus) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            // 최종적으로 r의 개수가 홀수임을 의미
            if (reverseStatus) {
                Deque<String> tempDeque = new ArrayDeque<>();
                // 원래 deque에서 요소를 꺼내서 tempDeque에 역순으로 넣기
                while (!deque.isEmpty()) {
                    tempDeque.offerFirst(deque.pollFirst());
                }
                deque.addAll(tempDeque);
            }

            bw.write("[");
            while (!deque.isEmpty()) {
                if (deque.size() == 1) bw.write(deque.pollFirst());
                else bw.write(deque.pollFirst() + ",");
            }
            bw.write("]\n");
        }
        bw.close();
    }
}
