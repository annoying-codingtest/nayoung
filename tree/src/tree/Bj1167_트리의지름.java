package tree;

import java.util.*;
import java.io.*;

class Node2 {
	int nx;
	int info;

	public Node2(int nx, int info) {
		this.nx = nx;
		this.info = info;
	}
}

public class Bj1167_트리의지름 {

	private static ArrayList<Node2>[] tree;
	private static boolean[] ch;
	private static int dia = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];
		ch = new boolean[V + 1];

		for (int i = 0; i < V + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {
			String[] s = br.readLine().split(" ");

			for (int j = 1; j < s.length; j++) {
				if (Integer.parseInt(s[j]) == -1) {
					break;
				}
				int v = Integer.parseInt(s[0]);
				int v2 = Integer.parseInt(s[j]);
				int line = Integer.parseInt(s[j++]);

				tree[v].add(new Node2(v2, line));

			}

		}

		DFS(1,0);
		System.out.println(dia);

	}

	private static void DFS(int a, int w) {
		
		for (Node2 v : tree[a]) {
			if (ch[v.nx]) {
				continue;
			} else {
				ch[v.nx] = true;
				DFS(v.nx, w+v.info);
			}

		}
	}

}
