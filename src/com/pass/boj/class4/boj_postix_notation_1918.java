package com.pass.boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 후위표기식
public class boj_postix_notation_1918 {
	public static void main(String[] args) throws IOException {
		// Ex input Values
		// A*(B+C)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// N : 정점의 개수, M :
		String param = st.nextToken();
		System.out.println(solution(param));

	}

	public static String solution(String param) {
		StringBuilder sbResult = new StringBuilder();
		Stack<Character> resultStack = new Stack<Character>();
		for (int i = 0; i < param.length(); i++) {
			char nowChar = param.charAt(i);

			if (nowChar >= 'A' && nowChar <= 'Z') {
				sbResult.append(nowChar);
			}

			// (일대는 nowChar이 ) 나올때까지 우선순위를 두어 먼저 출력해야지
			else if (nowChar == '(') {
				resultStack.push('(');
			} else if (nowChar == ')') {
				while(!resultStack.isEmpty()) {
                    if(resultStack.peek() == '(') {
                        resultStack.pop();
                        break;
                    }
                    sbResult.append(resultStack.pop());
                }
			} else {
				while (!resultStack.isEmpty() && getPriorityOfChar(resultStack.peek()) >= getPriorityOfChar(nowChar)) {
					sbResult.append(resultStack.pop());
				}
				resultStack.push(nowChar);
			}
		}

		while (!resultStack.isEmpty())

		{
			sbResult.append(resultStack.pop());
		}

		return sbResult.toString();
	}

	public static int getPriorityOfChar(Character ch) {
		if(ch == '(') return 0;
		else if (ch == '-' || ch == '+') return 1;
		else return 2;
	}

}
