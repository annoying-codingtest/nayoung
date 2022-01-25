package implementaion;

import java.util.*;
import java.io.*;

public class Bj17413_�ܾ������2 {

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
				 * �±׾ȿ� �� �ܾ�� �׳� sb�� append (�׳� ���) 
				 * ex) <open>
				 * �� ����, ���ÿ� �ܾ �� ���� �� �ֱ� ������ 
				 * ���ÿ� ����ִ� �ܾ �Ųٷ� pop�ؼ� ���
				 * ex) <open>tag<close> �� tag
				 */
				if (!stack.isEmpty()) {
					while (!stack.isEmpty()) {
						sb.append(stack.pop()); //�±� ���̿� �ִ� �ܾ�� ���� ����
					}
				}
				sb.append(c); // '<' �ٿ��ֱ�
				while (true) {
					i++;
					c = S.charAt(i);
					sb.append(c);
					if (c == '>')
						break;
				}
			} else if (c == ' ') {
				/*
				 * c�� �����̸� �ϳ��� �ܾ��̹Ƿ� ���ÿ� �ִ� ���� pop�� �� + ����
				 */
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			} else if (i == S.length() - 1) {
				/*
				 * ������ �ܾ��� ������ ���ڰ� ���� �ܾ���� (�ڿ� ������ ���⿡ ���� ���ǹ�)
				 */
				sb.append(S.charAt(i));
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			} else {
				// ������ ���ڴ� ���ÿ� Ǫ��
				stack.push(c);
			}
		}

		System.out.println(sb);

	}

}
