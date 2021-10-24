package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Bj10866_µ¦ {

	private static Deque<Integer> dq = new ArrayDeque<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 0;

		for (int i = 0; i < N; i++) {
			String[] order = br.readLine().split(" ");

			switch (order[0]) {

			case "push_front":
				num = Integer.parseInt(order[1]);
				push_front(num);
				continue;

			case "push_back":
				num = Integer.parseInt(order[1]);
				push_back(num);
				continue;

			case "pop_front":
				pop_front();
				continue;

			case "pop_back":
				pop_back();
				continue;

			case "size":
				size();
				continue;

			case "empty":
				empty();
				continue;

			case "front":
				front();
				continue;

			case "back":
				back();
				continue;

			}

		}

		System.out.println(sb);
	}

	public static void push_front(int n) {
		dq.addFirst(n);
	}

	public static void push_back(int n) {
		dq.addLast(n);
	}

	public static void pop_front() {
		if (dq.isEmpty()) {
			sb.append(-1 + "\n");
		} else {
			sb.append(dq.removeFirst() + "\n");
		}
	}

	public static void pop_back() {
		if (dq.isEmpty()) {
			sb.append(-1 + "\n");
		} else {
			sb.append(dq.removeLast() + "\n");
		}
	}

	public static void size() {
		sb.append(dq.size() + "\n");
	}

	public static void empty() {
		if (dq.isEmpty()) {
			sb.append(1 + "\n");
		} else {
			sb.append(0 + "\n");
		}
	}

	public static void front() {
		if (dq.isEmpty()) {
			sb.append(-1 + "\n");
		} else {
			sb.append(dq.getFirst() + "\n");
		}
	}

	public static void back() {
		if (dq.isEmpty()) {
			sb.append(-1 + "\n");
		} else {
			sb.append(dq.getLast() + "\n");
		}
	}
}
