package br.ufc.crateus.eda.utils;

import java.util.Arrays;
import java.util.Stack;

public class ExprTree {
	
	static class Node {
		char ch;
		Node left, right;
		
		Node(char ch) {
			this.ch = ch;
			right = left = null;
		}
	}
	
	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/'; 
	}
	
	public static void inorder(Node r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.ch);
			inorder(r.right);
		}
	}
	
	private static Node posfixToTree(char[] posfix) {
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < posfix.length; i++) {
			char ch = posfix[i];
			if (!isOperator(ch)) 
				stack.push(new Node(ch));
			else {
				Node node = new Node(ch);
				node.right = stack.pop();
				node.left = stack.pop();
				stack.push(node);
			}
		}
		
		return stack.pop();
	}
	
	private static char[] infixToPosfix(char[] infix) {
		char[] stack = new char[infix.length];
		char[] posfix = new char[infix.length];
		
		int t = 0, j = 0; 
		stack[t++] = infix[0];
		
		for (int i = 1; i < infix.length; i++) {
			char ch = infix[i];
			if (ch == '(') stack[t++] = ch;
			else if (ch == ')') {
				while(stack[t - 1] != '(') posfix[j++] = stack[--t];
				t--;
			}
			else if (ch == '+' || ch == '-') {
				while (stack[t - 1] != '(') posfix[j++] = stack[--t];
				stack[t++] = ch;
			}
			else if (ch == '*' || ch == '/') {
				while (stack[t - 1] != '(' && stack[t - 1] != '+' && stack[t - 1] != '-') 
					posfix[j++] = stack[--t];
				stack[t++] = ch;
			}
			else posfix[j++] = ch;
		}
		
		return Arrays.copyOf(posfix, j);
	}
	
	public static void main(String[] args) {
		String strInfix = "(A+B*(C-D*(E-F)-G*H)-I*3)";
		char[] posfix = infixToPosfix(strInfix.toCharArray());
//		System.out.println(new String(posfix));
		inorder(posfixToTree(posfix));
	}
}
