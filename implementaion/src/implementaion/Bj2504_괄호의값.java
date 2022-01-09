package implementaion;

import java.util.*;

public class Bj2504_°ýÈ£ÀÇ°ª {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String in = scan.next();

		int mul = 1, result = 0; 
		Stack<Character> stack = new Stack<Character>(); 
		
		for (int i = 0; i < in.length(); i++) {
			switch (in.charAt(i)) { 

			case '(':
				stack.push('(');
				mul *= 2;
				break;

			case '[':
				stack.push('[');
				mul *= 3;
				break;
	
			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				}

				if (in.charAt(i - 1) == '(')
					result += mul;
				stack.pop();
				mul /= 2;
				break;
	
			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				}

				if (in.charAt(i - 1) == '[')
					result += mul;
				stack.pop();
				mul /= 3;
				break;
			}
		}


		System.out.println(!stack.isEmpty() ? 0 : result);
		
		scan.close();
	}

}
