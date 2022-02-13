package implementaion;

import java.util.*;
import java.io.*;

public class Bj14891_��Ϲ��� {

	private static int[] dis;
	private static int[][] wheel = new int[4][8];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = s.charAt(j) - '0';
			}

		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			String[] s = br.readLine().split(" ");
			int what = Integer.parseInt(s[0]) - 1;
			int d = Integer.parseInt(s[1]);

			dis = new int[4];
			dis[what] = d; // ȸ����ų ������ ȸ����ų ���� ����

			checkBothSide(what);
			turnWheel();

		}

		int answer = 0;
		if (wheel[0][0] == 1)
			answer += 1;
		if (wheel[1][0] == 1)
			answer += 2;
		if (wheel[2][0] == 1)
			answer += 4;
		if (wheel[3][0] == 1)
			answer += 8;
		System.out.println(answer);

	}

	public static void checkBothSide(int what) {

		// what ����, ������ �ִ� ��Ϲ����� üũ
		for (int i = what - 1; i >= 0; i--) {
			if (wheel[i][2] != wheel[i + 1][6]) {
				// ������ ������ ��Ϲ����� ȸ������� �ٸ��ٸ� ���Ⱚ�� -1 ���� ����.
				dis[i] = dis[i + 1] * -1;
			} else {
				// ������ ȸ�� �� ��.
				break;
			}
		}
		// what ����, ������ �ִ� ��Ϲ����� üũ
		for (int i = what + 1; i < 4; i++) {
			if (wheel[i][6] != wheel[i - 1][2]) {
				// ������ ������ ��Ϲ����� ȸ������� �ٸ��ٸ� ���Ⱚ�� -1 ���� ����.
				dis[i] = dis[i - 1] * -1;
			} else {
				// ������ ȸ�� �� ��.
				break;
			}
		}
	}

	public static void turnWheel() {
		// �з��� ���� ������ ����
		int temp = 0;

		for (int i = 0; i < 4; i++) { // ��� ��Ͽ� ���ؼ�
			// �ð���� ȸ��
			if (dis[i] == 1) {
				temp = wheel[i][7];
				for (int j = 7; j > 0; j--) {
					wheel[i][j] = wheel[i][j - 1];
				}
				wheel[i][0] = temp;
			}
			// �ݽð����ȸ��
			if (dis[i] == -1) {
				temp = wheel[i][0];
				for (int j = 0; j < 7; j++) {
					wheel[i][j] = wheel[i][j + 1];
				}
				wheel[i][7] = temp;
			}
		}
	}

}
