package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj4949_균형잡힌세상 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		char c;
		while (true) {
			//한 줄 끝나면 스택 비워주기
			stack.clear();
			
			String s = br.readLine();
			//종료조건
			if (s.equals(".")) {
				break;
			}

			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')' || c == ']') {
					if (stack.isEmpty() || (stack.peek() == '(' && c == ']') || (stack.peek() == '[' && c == ')')) {
						//empthy조건은 왜..?
						stack.push(c);
						break;
					}
					stack.pop();

				}
			}

			if (!stack.isEmpty())
				sb.append("no" + "\n");
			else
				sb.append("yes" + "\n");

		}
		
		System.out.println(sb);
	}

}
