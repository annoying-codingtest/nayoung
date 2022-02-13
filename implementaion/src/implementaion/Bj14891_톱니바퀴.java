package implementaion;

import java.util.*;
import java.io.*;

public class Bj14891_톱니바퀴 {

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
			dis[what] = d; // 회전시킬 바퀴에 회전시킬 방향 저장

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

		// what 기준, 좌측에 있는 톱니바퀴들 체크
		for (int i = what - 1; i >= 0; i--) {
			if (wheel[i][2] != wheel[i + 1][6]) {
				// 좌측이 우측의 톱니바퀴의 회전방향과 다르다면 방향값에 -1 곱해 저장.
				dis[i] = dis[i + 1] * -1;
			} else {
				// 같으면 회전 안 함.
				break;
			}
		}
		// what 기준, 우측에 있는 톱니바퀴들 체크
		for (int i = what + 1; i < 4; i++) {
			if (wheel[i][6] != wheel[i - 1][2]) {
				// 우측이 좌측의 톱니바퀴의 회전방향과 다르다면 방향값에 -1 곱해 저장.
				dis[i] = dis[i - 1] * -1;
			} else {
				// 같으면 회전 안 함.
				break;
			}
		}
	}

	public static void turnWheel() {
		// 밀려날 값을 저장할 변수
		int temp = 0;

		for (int i = 0; i < 4; i++) { // 모든 톱니에 대해서
			// 시계방향 회전
			if (dis[i] == 1) {
				temp = wheel[i][7];
				for (int j = 7; j > 0; j--) {
					wheel[i][j] = wheel[i][j - 1];
				}
				wheel[i][0] = temp;
			}
			// 반시계방향회전
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
