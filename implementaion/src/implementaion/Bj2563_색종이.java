package implementaion;

import java.io.*;
import java.util.*;

public class Bj2563_������ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101]; // ����ũ���� 2���� �迭

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			fillingMap(map, X, Y);
		}

		int area = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1) {
					area += map[i][j];
				}
			}
		}

		System.out.println(area);

	}

	public static void fillingMap(int[][] map, int x, int y) {
		/*
		 ���� ��ġ (x,y)���� ���簢�� ũ���� ��ǥ���� (newX,newY) 1�� ä���.
		 */
		int newX = x + 10;
		int newY = y + 10;

		for (int i = x; i < newX; i++) {
			for (int j = y; j < newY; j++) {
				map[i][j] = 1;
			}
		}
	}

}
