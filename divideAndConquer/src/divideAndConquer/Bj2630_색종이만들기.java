package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2630_�����̸���� {

	private static int white = 0;
	private static int blue = 0;
	private static int[][] papers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		papers = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	public static void divide(int row, int col, int size) {

		if (colorCheck(row, col, size)) { // ���ҵ� ���� �簢���� ������ ��� ���� ��
			if (papers[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}

		int dividedSize = size / 2;
		divide(row, col + dividedSize, dividedSize); // 1��и�
		divide(row, col, dividedSize); // 2��и�
		divide(row + dividedSize, col, dividedSize); // 3��и�
		divide(row + dividedSize, col + dividedSize, dividedSize); // 4��и�

	}

	// ���ҵ� �簢���� ������ ��� ������ üũ.
	public static boolean colorCheck(int row, int col, int size) {

		int color = papers[row][col]; // ù ��° ���Ҹ� �������� �˻�

		for (int i = row; i < row + size; i++) { // ù���� ������ǥ ~ ���� �簢���� ������ ��ǥ����
			for (int j = col; j < col + size; j++) {
				// ������ ���� �ʴٸ� false�� ����
				if (papers[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
