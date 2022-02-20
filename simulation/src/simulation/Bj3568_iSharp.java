package simulation;

import java.util.*;

public class Bj3568_iSharp {

	private static String[] input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine().split(" ");

		for (int i = 1; i < input.length; i++) {
			System.out.println(transforming(i, input[0]));
		}

		scan.close();

	}

	public static String transforming(int k, String basic) {
		String s = basic;
		String ns = input[k]; // .substring(0, input[k].length() - 1); // , 혹은 ;지우기

		int index = 0;// 변수명 시작
		String vname = "";

		if (ns.length() > 2) {
			boolean flag = false;

			int i = 0;
			while (flag == false && i <= ns.length() - 1) {

				if (ns.charAt(i) == '[' || ns.charAt(i) == ']' || ns.charAt(i) == '&' || ns.charAt(i) == '*') {
					index = i; // 이름이 끝나고 변수 인덱스 찾기
					flag = true;
					continue;

				} else if (ns.charAt(i) == ';' || ns.charAt(i) == ',') {
					index = ns.length() - 1;
				}
				vname += ns.charAt(i++);
			}

			for (int j = ns.length() - 2; j >= index; j--) {
				char ch = ns.charAt(j);
				if (ch == ']' || ch == '[') {
					ch = ch == ']' ? '[' : ']';

				}

				s += ch;
			}
		} else {
			vname += ns.charAt(index);

		}

		return s += " " + vname + ";";

	}

}
