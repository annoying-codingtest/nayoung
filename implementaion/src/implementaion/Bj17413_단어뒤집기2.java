package implementaion;

import java.util.*;
import java.io.*;

public class Bj17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '<') {
				if (!stack.isEmpty()) {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				sb.append(c);
				while (true) {
					i++;
					c = S.charAt(i);
					sb.append(c);
					if (c == '>')
						break;
				}
			} else if (c == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			} else if (i == S.length() - 1) {
				sb.append(S.charAt(i));
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			} else {
				stack.push(c);
			}
		}

		System.out.println(sb);

	}

}
