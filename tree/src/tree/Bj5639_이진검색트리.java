package tree;

import java.util.*;
import java.io.*;

public class Bj5639_이진검색트리 {

	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			int nextNode = Integer.parseInt(s);
			root.insert(nextNode);
		}
		postOrder(root);
		System.out.println(sb);
		
	}

	public static void postOrder(Node root) {
		if (root == null)
			return;
		else {
			postOrder(root.left);
			postOrder(root.right);
			sb.append(root.key + "\n");
		}
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}

		void insert(int key) {
			if (this.key > key) {
				if (this.left == null) {
					this.left = new Node(key);
				} else {
					this.left.insert(key);
				}

			} else {
				if (this.right == null) {
					this.right = new Node(key);
				} else {
					this.right.insert(key);
				}
			}
		}

	}

}
