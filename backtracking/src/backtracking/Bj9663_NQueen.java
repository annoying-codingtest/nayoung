package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N-Queen
//���� �̵���ġ: �����¿� �밢�� ������� �� �������� �̵� ���� 
public class Bj9663_NQueen {
	
	private static int[] chess;
	public static int N;
	public static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];

		nQueen(0);
		System.out.println(count);
	}

	public static void nQueen(int d) {
		if (d == N) {
			count++;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				chess[d] = i;
				if (check(d)) { 
					nQueen(d + 1);
				}
			}
		}
	}

	public static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (chess[col] == chess[i]) // ���� ���� �࿡ �ְų�
				return false;
			else if (Math.abs(col - i) == Math.abs(chess[col] - chess[i])) // ���� �밢���� ������
				//���� �� == ���� ��
				return false;
		}
		return true; // 1���� ���� ��������
	}

}
