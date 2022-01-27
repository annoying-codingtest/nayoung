package implementaion;

import java.util.*;
import java.io.*;

public class Bj5567_°áÈ¥½Ä {
	private static ArrayList<ArrayList<Integer>> list;
	private static boolean[] check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		list = new ArrayList<ArrayList<Integer>>();
		check = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int who = Integer.parseInt(st.nextToken());
			int friend = Integer.parseInt(st.nextToken());

			list.get(who).add(friend);
			list.get(friend).add(who);
		}

		System.out.println(marry());
	}

	public static int marry() {

		int count = 0;

		if (list.get(1).size() == 0) {
			return count;
		}

		check[1] = true;
		for (int i = 0; i < list.get(1).size(); i++) {
			int f = list.get(1).get(i);

			if (!check[f]) {
				check[f] = true;
				count++;
			}

			for (int j = 0; j < list.get(f).size(); j++) {
				int ff = list.get(f).get(j);
				if (check[ff])
					continue;
				else {
					check[ff] = true;
					count++;
				}
			}

		}

		return count;

	}

}
