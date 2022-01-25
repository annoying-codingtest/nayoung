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
				/*
				 * 태그안에 들어간 단어는 그냥 sb에 append (그냥 출력) 
				 * ex) <open>
				 * 그 전에, 스택에 단어가 들어가 있을 수 있기 때문에 
				 * 스택에 들어있는 단어를 거꾸로 pop해서 출력
				 * ex) <open>tag<close> 의 tag
				 */
				if (!stack.isEmpty()) {
					while (!stack.isEmpty()) {
						sb.append(stack.pop()); //태그 사이에 있는 단어는 공백 없음
					}
				}
				sb.append(c); // '<' 붙여주기
				while (true) {
					i++;
					c = S.charAt(i);
					sb.append(c);
					if (c == '>')
						break;
				}
			} else if (c == ' ') {
				/*
				 * c가 공백이면 하나의 단어이므로 스택에 있는 문자 pop한 후 + 공백
				 */
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			} else if (i == S.length() - 1) {
				/*
				 * 마지막 단어의 마지막 문자가 오면 단어출력 (뒤에 공백이 없기에 따로 조건문)
				 */
				sb.append(S.charAt(i));
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			} else {
				// 나머지 문자는 스택에 푸시
				stack.push(c);
			}
		}

		System.out.println(sb);

	}

}
