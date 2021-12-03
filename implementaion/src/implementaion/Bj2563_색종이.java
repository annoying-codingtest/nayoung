package implementaion;

import java.io.*;
import java.util.*;

public class Bj2563_색종이 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101]; // 종이크기의 2차원 배열

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
		 현재 위치 (x,y)에서 정사각형 크기의 좌표까지 (newX,newY) 1로 채운다.
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
