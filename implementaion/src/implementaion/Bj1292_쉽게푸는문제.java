package implementaion;

import java.util.*;

public class Bj1292_쉽게푸는문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = new int[1001];

		Scanner scan = new Scanner(System.in);

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		int i = 0;
		int start = 0;
		int count = 1;
		boolean check = false;

		while (!check) {

			for (i = start; i < start + count; i++) {
				if (i < 1001) {
					numbers[i] = count;
				} else {
					check = true;
				}
			}
			start = start + count;
			count++;

		}

		int sum = 0;

		for (int h = num1 - 1; h <= num2 - 1; h++) {
			sum += numbers[h];
		}

		System.out.println(sum);

	}
}
