package br.ufc.crateus.eda.utils;

public class ArrayTree {
	
	static class Node {
		int content;
		Node left, right;
		
		Node(int content) {
			this.content = content;
			right = left = null;
		}
	}
	
	public static Node arrayToTree(int[] array){
		return arrayToTree(array, 0, array.length - 1);
	}
	
	public static void inorder(Node r) {
		if (r != null) {
			System.out.print(r.content + " ");
			inorder(r.left);
			inorder(r.right);
		}
	}
	
	public static Node arrayToTree(int[] array, int l, int r){
		if (l > r) return null;
		int mid = (l + r) / 2;
		Node node = new Node(array[mid]);
		if (l < r) {
			node.left = arrayToTree(array, l, mid - 1);
			node.right = arrayToTree(array, mid + 1, r);
		}
		return node;
	}
	
	public static void main(String[] args) {
		int a[] = {2, 4, 5, 6, 7, 8, 10, 15};
		Node node = arrayToTree(a);
		inorder(node);
	}
}
