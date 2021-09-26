import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 좌표 정렬하기2
// 단어의 순서를 정의하여 정렬
public class Bj11651 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		int[][] sortingArray = new int[n][2];

		// 좌표 입력받기
		for (int i = 0; i < n; i++) {
			sortingArray[i][0] = scan.nextInt();
			sortingArray[i][1] = scan.nextInt();
		}

		// 좌표 정렬
		Arrays.sort(sortingArray, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if (p1[1] == p2[1]) { // y좌표가 같을 때
					return p1[0] - p2[0]; // x좌표를 비교하여 정렬
				}
				return p1[1] - p2[1]; //y좌표 비교 정렬
			}

		});

		// 정렬결과 출력

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < n; i++) {
			bw.write(sortingArray[i][0] + " " + sortingArray[i][1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}
