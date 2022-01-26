package implementaion;

import java.io.*;

public class Bj1244_스위치켜고끄기 {

	private static int lights[];;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int light = Integer.parseInt(br.readLine());
		lights = new int[light + 1];
		String s[] = br.readLine().split(" ");
		for (int i = 0; i < s.length; i++) {
			lights[i + 1] = Integer.parseInt(s[i]);
		}

		int students = Integer.parseInt(br.readLine());

		for (int i = 0; i < students; i++) {
			String st[] = br.readLine().split(" ");
			int who = Integer.parseInt(st[0]);
			int num = Integer.parseInt(st[1]);

			if (who == 1) {
				boy(num);
			} else {
				girl(num);
			}
		}

		for (int i = 1; i < lights.length; i++) {
			System.out.print(lights[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

		br.close();
	}

	public static void boy(int num) {

		for (int i = 1; i < lights.length; i++) {
			if (i % num == 0) {
				zeroOrOne(i);
			}
		}

	}

	public static void girl(int num) {

		zeroOrOne(num);

		int k = 1;
		while (num + k <= lights.length - 1 && num - k >= 1) {

			if (lights[num - k] == lights[num + k]) {
				zeroOrOne(num - k);
				zeroOrOne(num + k);
			} else {
				break;
			}
			k++;

		}

	}

	public static void zeroOrOne(int point) {
		if (lights[point] == 1) {
			lights[point] = 0;
		} else {
			lights[point] = 1;
		}

	}

}
