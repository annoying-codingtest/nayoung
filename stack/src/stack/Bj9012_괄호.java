package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Bj9012_°ýÈ£ {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while (N > 0) {
			String brackets = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean finish = false;
			for (int i = 0; i < brackets.length(); i++) {
				char c = brackets.charAt(i);
				if (c == '(') {
					stack.push(c);
				} else {
					if (stack.empty()) {
						finish = true;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (!stack.empty() || finish) {
				sb.append("NO" + "\n");
			} else {
				sb.append("YES" + "\n");
			}
			N--;
		}
		
		System.out.println(sb);
	}

}
