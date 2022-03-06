package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1874_���ü��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		// ���ؾ� �� ����
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		int i = 1;
		int k = 0; 
		
		while (i <= N+1 && k < N) {
			/*
			 * i <= N+1�� ���� -> N�� 8�� ���� ��� 1~8���� push�ϰ� 9�� ���� �� 8�� pop�� �� �ֱ� ����.
			 */
			int num = array[k];

			if (stack.isEmpty() || stack.peek() != num) {
				if (!stack.isEmpty() && stack.peek() > num) {
					sb.setLength(0);
					sb.append("NO\n");
					break;
				}
				stack.push(i);
				sb.append("+\n");
				i++;

			}

			else {
				stack.pop();
				sb.append("-\n");
				k++;

			}
		}
		
		System.out.println(sb);
	}

}
