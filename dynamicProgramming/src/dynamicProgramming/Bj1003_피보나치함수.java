package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�Ǻ���ġ �Լ�

public class Bj1003_�Ǻ���ġ�Լ� {

	public static int[][] memo = new int[41][2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		memo[0][0] = 1; // N=0�� �� 0�� ȣ�� Ƚ��
		memo[0][1] = 0; // N=0�� �� 1�� ȣ�� Ƚ��
		memo[1][0] = 0; // N=1�� �� ...
		memo[1][1] = 1;

		// fibonacci(n) = fibonacci(n-1) + fibonacci(n-2);
		// N�� i�� �� 0�� ȣ�� Ƚ���� 1�� ȣ�� Ƚ������ �̸� memo�� ����.
		for (int i = 2; i < 41; i++) {
			for (int j = 0; j < 2; j++) {
				memo[i][j] = memo[i - 1][j] + memo[i - 2][j];
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//�׽�Ʈ ���̽� ���� N
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			//fibonacchi(n)�� 0�� ȣ��Ƚ���� 1�� ȣ�� Ƚ��
			sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
		}

		System.out.println(sb);

	}

}
