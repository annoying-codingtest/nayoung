import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// ��ǥ �����ϱ�2
// �ܾ��� ������ �����Ͽ� ����
public class Bj11651 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		int[][] sortingArray = new int[n][2];

		// ��ǥ �Է¹ޱ�
		for (int i = 0; i < n; i++) {
			sortingArray[i][0] = scan.nextInt();
			sortingArray[i][1] = scan.nextInt();
		}

		// ��ǥ ����
		Arrays.sort(sortingArray, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if (p1[1] == p2[1]) { // y��ǥ�� ���� ��
					return p1[0] - p2[0]; // x��ǥ�� ���Ͽ� ����
				}
				return p1[1] - p2[1]; //y��ǥ �� ����
			}

		});

		// ���İ�� ���

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < n; i++) {
			bw.write(sortingArray[i][0] + " " + sortingArray[i][1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}
