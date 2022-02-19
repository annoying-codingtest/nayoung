package simulation;

import java.util.*;
import java.io.*;

public class Bj16506_CPU {
	private static HashMap<String, String> opcode;
	private static HashMap<Integer, String> bits;
	private static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		opcode = new HashMap<>();

		opcode.put("ADD", "00000");
		opcode.put("ADDC", "00001");
		opcode.put("SUB", "00010");
		opcode.put("SUBC", "00011");
		opcode.put("MOV", "00100");
		opcode.put("MOVC", "00101");
		opcode.put("AND", "00110");
		opcode.put("ANDC", "00111");
		opcode.put("OR", "01000");
		opcode.put("ORC", "01001");
		opcode.put("NOT", "01010");
		opcode.put("MULT", "01100");
		opcode.put("MULTC", "01101");
		opcode.put("LSFTL", "01110");
		opcode.put("LSFTLC", "01111");
		opcode.put("LSFTR", "10000");
		opcode.put("LSFTRC", "10001");
		opcode.put("ASFTR", "10010");
		opcode.put("ASFTRC", "10011");
		opcode.put("RL", "10100");
		opcode.put("RLC", "10101");
		opcode.put("RR", "10110");
		opcode.put("RRC", "10111");

		bits = new HashMap<>();
		bits.put(0, "000");
		bits.put(1, "001");
		bits.put(2, "010");
		bits.put(3, "011");
		bits.put(4, "100");
		bits.put(5, "101");
		bits.put(6, "110");
		bits.put(7, "111");
		bits.put(8, "1000");
		bits.put(9, "1001");
		bits.put(10, "1010");
		bits.put(11, "1011");
		bits.put(12, "1100");
		bits.put(13, "1101");
		bits.put(14, "1110");
		bits.put(15, "1111");

		for (int i = 0; i < num; i++) {
			String[] input = br.readLine().split(" ");

			operation(opcode.get(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]),
					Integer.parseInt(input[3])); // 명령어 집어넣기
		}
		
		System.out.print(sb);

	}

	public static void operation(String opcode, int a, int b, int c) {
		String ans = ""; // 출력결과 비트
		ans += opcode + "0";

		ans += bits.get(a);
		ans += bits.get(b);
		
	
		if (ans.charAt(4)-'0' == 0) { //4번째 비트가 0이면 12~14 rb의 번호 넣고 마지막 비트 0
			ans += bits.get(c);
			ans += "0";
		}
		else { //4번째 비트가 1이면 12~15 상수 #C값
			if (c < 8) {
				ans += "0";
			}
			ans += bits.get(c);

		}
		
		sb.append(ans + "\n");
	}

}


