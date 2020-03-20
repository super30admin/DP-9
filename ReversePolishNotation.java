package com.recommender;

import java.util.*;

/*
Time Complexity: O(N) for Stack Approach
Space Complexity: O(N) for Stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

/**
 * 
 * Stack is most relevant data structure for polish notation problems
 *  The alog working is explained below
 *  	1.) Maintain a stack for storing Numbers or Digit
 *  	2.)	Start iterating the string.Now following cases arise
 *  		a.) if we encountered character is digit or a number push it to stack
 *  		b.) If we encounter operator,pop out two numbers from stack and perform the operator function on 
 *  			popped numbers
 *  		c.) Store the result into stack
 *  	3.) Keep repeating until stack is empty or all characters are processed
 * */

public class ReversePolishNotation {
	private Stack<Integer> operand = new Stack<>();

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		int size = tokens.length;
		int output = 0;
		for (int i = 0; i < size; i++) {
			String ch = tokens[i];
			if ("+-*/".contains(ch)) {
				int top2 = operand.pop();
				int top1 = operand.pop();

				if ("+".equals(ch)) {
					output = top1 + top2;

				} else if ("-".equals(ch)) {
					output = top1 - top2;

				} else if ("*".equals(ch)) {
					output = top1 * top2;

				} else if ("/".equals(ch)) {
					output = top1 / top2;
				}
				operand.push(output);
			} else {
				operand.push(Integer.parseInt(ch));
			}
		}
		return operand.pop();
	}

	public static void main(String args[]) {
		String tokens[] = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		String tokens1[] = { "4", "13", "5", "/", "+" };
		String tokens2[] = { "2", "1", "+", "3", "*" };

		System.out.println(new ReversePolishNotation().evalRPN(tokens));

		System.out.println(new ReversePolishNotation().evalRPN(tokens1));
		System.out.println(new ReversePolishNotation().evalRPN(tokens2));
	}

}
