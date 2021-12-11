package tree;

import java.util.*;
import java.io.*;

class Node {
	String data;
	String lt, rt;

	public Node(String val) {
		this.data = val;
		lt = rt = null;
	}

}

public class Bj1991_트리순회 {
	private static int N;
	private static Map<String, Node> tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		tree = new HashMap<String, Node>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			Node node = new Node(root);
			node.lt = left;
			node.rt = right;

			tree.put(node.data, node);

		}

		preOrder("A");
		System.out.println();
		inOrder("A");
		System.out.println();
		postOrder("A");

	}

	public static void preOrder(String data) {

		if (tree.get(data) == null || data == ".") {
			return;
		} else {
			System.out.print(tree.get(data).data);
			preOrder(tree.get(data).lt);
			preOrder(tree.get(data).rt);

		}

	}

	public static void inOrder(String data) {

		if (tree.get(data) == null || data == ".") {
			return;
		} else {
			inOrder(tree.get(data).lt);
			System.out.print(tree.get(data).data);
			inOrder(tree.get(data).rt);

		}

	}

	public static void postOrder(String data) {

		if (tree.get(data) == null || data == ".") {
			return;
		} else {
			postOrder(tree.get(data).lt);
			postOrder(tree.get(data).rt);
			System.out.print(tree.get(data).data);

		}

	}

}
