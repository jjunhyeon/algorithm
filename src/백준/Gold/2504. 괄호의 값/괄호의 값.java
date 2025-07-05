
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		Stack<Character> st = new Stack<>();
		int result = 0;
		int tmp = 1;

		for (int i = 0; i < len; i++) {
			char cur = s.charAt(i);

			switch (cur) {
			case '(':
				st.push('(');
				tmp *= 2;
				break;
			case '[':
				st.push('[');
				tmp *= 3;
				break;
			case ')':
				if (st.isEmpty() || st.peek() != '(') {
					st.push(')');
					result = 0;
					break;
				} else if (i > 0 && s.charAt(i - 1) == '(') {
					result += tmp;
				}
				st.pop();
				tmp /= 2;
				break;
			case ']':
				if (st.isEmpty() || st.peek() != '[') {
					st.push(']');
					result = 0;
					break;
				} else if (i > 0 && s.charAt(i - 1) == '[') {
					result += tmp;
				}
				st.pop();
				tmp /= 3;
				break;
			}
		}

		System.out.println(!st.isEmpty() ? 0 : result);
	}
}
