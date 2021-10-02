import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

//시간초과
public class Bj18890_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] numList = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numList.length; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> subList = new ArrayList<Integer>();
		for (int i = 0; i < numList.length; i++) {
			if (!subList.contains(numList[i])) {
				subList.add(numList[i]);
			}
		}

		Collections.sort(subList);
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i = 0; i < numList.length; i++) {
			if (subList.contains(numList[i])) {
				index = subList.indexOf(numList[i]);
			}
			sb.append(index + " ");
		}

		System.out.println(sb);

	}

}
