package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj18258_ť2 {

	private static StringBuilder sb = new StringBuilder();
	private static Queue<Integer> queue = new LinkedList<>();
	private static int lastNum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] order = br.readLine().split(" ");

			switch (order[0]) {
			case "push":
				lastNum = Integer.parseInt(order[1]);
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

	static void push(int n) {
		queue.offer(n);

	}

	static void pop() {
		if (!queue.isEmpty()) {
			sb.append(queue.peek() + "\n");
			queue.poll();
		} else {
			sb.append(-1 + "\n");
		}

	}

	static void size() {
		sb.append(queue.size() + "\n");
	}

	static void empty() {
		if (queue.isEmpty()) {
			sb.append(1 + "\n");
		} else {
			sb.append(0 + "\n");
		}
	}

	static void front() {
		if (!queue.isEmpty()) {
			sb.append(queue.peek() + "\n");
		} else {
			sb.append(-1 + "\n");
		}
	}

	static void back() {
		if (!queue.isEmpty()) {
			sb.append(lastNum + "\n");
		} else {
			sb.append(-1 + "\n");
		}
	}

}
