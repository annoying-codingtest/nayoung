package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj10818_Ω∫≈√ {
	static ArrayList<Integer> s = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] order = br.readLine().split(" ");

			switch (order[0]) {
			case "push":
				push(Integer.parseInt(order[1]));
				continue;

			case "pop":
				pop();
				continue;

			case "size":
				size();
				continue;

			case "empty":
				empty();
				continue;

			case "top":
				top();
				continue;

			}

		}

		System.out.println(sb);
	}

	static void push(int n) {
		s.add(n);

	}

	static void pop() {
		if (s.size() <= 0) {
			sb.append(-1 + "\n");

		} else {
			int topN = s.get(s.size() - 1);

			sb.append(topN + "\n");
			s.remove(s.size() - 1);
		}

	}

	static void size() {
		sb.append(s.size() + "\n");

	}

	static void empty() {
		if (s.size() <= 0) {
			sb.append(1 + "\n");
		} else {
			sb.append(0 + "\n");
		}
	}

	static void top() {
		if (s.size() > 0) {
			sb.append(s.get(s.size() - 1) + "\n");

		} else {
			sb.append(-1 + "\n");

		}
	}
}
