package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1992_����Ʈ�� {

	private static int[][] quadTree;
	private static StringBuilder sb =  new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		quadTree = new int[N][N];


		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				quadTree[i][j] = st.charAt(j) - '0';
			}
		}

		
		divide(0,0,N);
		
		System.out.println(sb);

	}

	public static void divide(int row, int col, int size) {

		if (checkNumber(row, col, size)) {
			sb.append(quadTree[row][col]); // ������ �� ������ �ش� �簢�� ù ������ ������ ����
			return;
		}

		int dividedSize = size / 2;

		sb.append('(');	// �� ����(depth)���� ���°�ȣ�� ����.
		
		// ���Ҽ����� ���� ��, ������ ��, ���� �Ʒ�, ������ �Ʒ�.
		divide(row, col, dividedSize);
		divide(row, col + dividedSize, dividedSize);
		divide(row + dividedSize, col, dividedSize);
		divide(row + dividedSize, col + dividedSize, dividedSize);
		
		sb.append(')');	// �ش� ������ ������ �ݴ°�ȣ.


	}

	public static boolean checkNumber(int row, int col, int size) {
		int firstNum = quadTree[row][col]; // ù ��° ���Ҹ� �������� �˻�

		for (int i = row; i < row + size; i++) { // ù���� ������ǥ ~ ���� ����Ʈ���� ������ ��ǥ����
			for (int j = col; j < col + size; j++) {
				// ������ ���� �ʴٸ� false�� ����
				if (quadTree[i][j] != firstNum) {
					return false;
				}
			}
		}
		return true;

	}

}
