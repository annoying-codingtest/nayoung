

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 수 정렬하기2
// Arrays.sort() 내장함수 이용하기.
public class Bj2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

		int n = Integer.parseInt(br.readLine());

		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < n; i++) {
			bw.write(array[i] + "\n");
		}

		bw.flush(); 
		bw.close();
		
	}

}
