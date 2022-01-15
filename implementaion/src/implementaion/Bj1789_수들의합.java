package implementaion;

import java.util.*;

public class Bj1789_수들의합 {
	private static long count = 0, sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long S = scan.nextInt();

		findN(S);
		System.out.println(count);

		scan.close();
	}

	public static void findN(long S) {
		boolean flag = false;
		long i = 1;
		while (flag == false) {
			sum += i;
			i++;
			count++;

			if (sum == S) {
				flag = true;
			} else if (sum > S) {
				count--;
				flag = true;
			}
		}

	}

}
