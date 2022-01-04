package implementaion;

import java.util.*;

public class Bj1120_¹®ÀÚ¿­ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		String B = scan.next();
		int answer = A.length();

		for (int i = 0; i <= B.length() - A.length(); i++) {
			int count = 0;
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) != B.charAt(i + j))
					count++;
			}
			answer = Math.min(count, answer);
		}
		System.out.println(answer);

		scan.close();
	}

}
