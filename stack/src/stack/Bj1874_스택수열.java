package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		// 구해야 할 수열
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		int i = 1;
		int k = 0; 
		
		while (i <= N+1 && k < N) {
			/*
			 * i <= N+1인 이유 -> N을 8로 예를 들면 1~8까지 push하고 9로 왔을 때 8을 pop할 수 있기 때문.
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
