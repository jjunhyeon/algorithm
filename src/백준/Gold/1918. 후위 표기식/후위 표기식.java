import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String inputText = st.nextToken();
        Stack<Character> resultStack = new Stack<>();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            char nowChar = inputText.charAt(i);

            if (nowChar >= 'A' && nowChar <= 'Z') {
                resultBuilder.append(nowChar);
            } else if (nowChar == '(') {
                resultStack.push('(');
            } else if(nowChar == ')'){
                while(!resultStack.isEmpty()) {
                    if(resultStack.peek() == '(') {
                        resultStack.pop();
                        break;
                    }
                    resultBuilder.append(resultStack.pop());
                }
            } else {
                while (!resultStack.isEmpty() && priority(resultStack.peek()) >= priority(nowChar)) {
                    resultBuilder.append(resultStack.pop());
                }
                resultStack.push(nowChar);
            }
        }

        while (!resultStack.isEmpty()) {
            resultBuilder.append(resultStack.pop());
        }

        System.out.println(resultBuilder);
    }

    static int priority(char c) {
        if( c == '(') return 0;
        else if( c == '+' ||  c == '-') return 1;
        else return 2;
    }
}
