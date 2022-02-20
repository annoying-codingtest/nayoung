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
		String ns = input[k]; // .substring(0, input[k].length() - 1); // , Ȥ�� ;�����

		int index = 0;// ������ ����
		String vname = "";

		if (ns.length() > 2) {
			boolean flag = false;

			int i = 0;
			while (flag == false && i <= ns.length() - 1) {

				if (ns.charAt(i) == '[' || ns.charAt(i) == ']' || ns.charAt(i) == '&' || ns.charAt(i) == '*') {
					index = i; // �̸��� ������ ���� �ε��� ã��
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
