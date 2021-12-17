package implementaion;

import java.util.*;
import java.io.*;

public class Bj11723_С§Че {

	private static ArrayList<Integer> S;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = new ArrayList<>();
		sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			switch (s[0]) {
			case "add":
				add(Integer.parseInt(s[1]));
				break;
			case "check":
				check(Integer.parseInt(s[1]));
				break;
			case "remove":
				remove(Integer.parseInt(s[1]));
				break;
			case "toggle":
				toggle(Integer.parseInt(s[1]));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;

			}
		}

		System.out.println(sb);

	}

	public static void add(int x) {
		if (S.contains(x)) {
			return;
		} else {
			S.add(x);
		}
	}

	public static void remove(int x) {
		if (S.contains(x)) {
			int i = S.indexOf(x);
			S.remove(i);
		} else {
			return;
		}
	}

	public static void check(int x) {
		if (S.contains(x)) {
			sb.append(1 + "\n");
		} else {
			sb.append(0 + "\n");
			return;
		}
	}

	public static void toggle(int x) {
		if (S.contains(x)) {
			int i = S.indexOf(x);
			S.remove(i);
		} else {
			S.add(x);
			return;
		}
	}

	public static void all() {
		S.clear();

		for (int i = 1; i <= 20; i++) {
			S.add(i);
		}
	}

	public static void empty() {
		S.clear();
	}

}
