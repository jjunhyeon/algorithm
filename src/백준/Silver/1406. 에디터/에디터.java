
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기 문자열을 LinkedList로 변환
        String command = bf.readLine();
        int commandCount = Integer.parseInt(bf.readLine());
        LinkedList<Character> text = new LinkedList<>();
        for (char c : command.toCharArray()) {
            text.add(c);
        }

        // ListIterator를 사용하여 커서 위치 관리
        ListIterator<Character> cursor = text.listIterator(text.size());

        for (int i = 0; i < commandCount; i++) {
            String[] curCommand = bf.readLine().split(" ");
            switch (curCommand[0]) {
                case "P":
                    cursor.add(curCommand[1].charAt(0));
                    break;
                case "L":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case "D":
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
            }
        }

        // 결과를 BufferedWriter에 쓰기
        for (char c : text) {
            bw.write(c);
        }

        bf.close();
        bw.flush();
        bw.close();
    }
}