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

//시간초과나옴.
public class Bj18890_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정렬해야 할 숫자 리스트
		int N = Integer.parseInt(br.readLine());
		int[] numList = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numList.length; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}

		// 중복 원소 빼고 새롭게 리스트 만들어 정렬
		ArrayList<Integer> subList = new ArrayList<Integer>();
		for (int i = 0; i < numList.length; i++) {
			if (!subList.contains(numList[i])) {
				subList.add(numList[i]);
			}
		}
		Collections.sort(subList);
		
		// 해당 인덱스 
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
