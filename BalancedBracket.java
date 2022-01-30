// Java program for checking Balanced Brackets

import java.util.*;
import java.util.Scanner;

public class BalancedBracket {

	
	static boolean areBracketsBalanced(String expr)
	{
		
		Deque<Character> stack
			= new ArrayDeque<Character>();

		
		for (int i = 0; i < expr.length(); i++)
		{
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{')
			{
			
				stack.push(x);
				continue;
			}

			
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		
		return (stack.isEmpty());
	}

	
	public static void main(String[] args)
	{
		System.out.println("Enter the Brackets");
		try (Scanner obj = new Scanner(System.in)) {
			String expr = obj.nextLine();
			


			if (areBracketsBalanced(expr))
				System.out.println("The entered String has Balanced Brackets");
			else
				System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}
