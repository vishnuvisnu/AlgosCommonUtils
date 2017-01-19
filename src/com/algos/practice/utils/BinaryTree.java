package com.algos.practice.utils;

public class BinaryTree {
	// Root node pointer. Will be null for an empty tree.
	private Node root;

	/*
	 * --Node-- The binary tree is built using this nested node class. Each node
	 * stores one data element, and has left and right sub-tree pointer which
	 * may be null. The node is a "dumb" nested class -- we just use it for
	 * storage; it does not have any methods.
	 */
	private static class Node {
		Node left;
		Node right;
		String data;

		Node(String newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	/**
	 * Creates an empty binary tree -- a null root pointer.
	 */
	public BinaryTree() {
		root = null;
	}
	
	public void printPreOrder() {
		this.printPreOrder(root);
	}
	
	private void printPreOrder(Node node) {
		if(node == null) {
			return;
		}
		printPreOrder(node.left);
		System.out.println("Data : " + node.data);
		printPreOrder(node.right);
	}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public boolean lookup(String data) {
		return (lookup(root, data));
	}

	/**
	 * Recursive lookup -- given a node, recur down searching for the given
	 * data.
	 */
	private boolean lookup(Node node, String data) {
		if (node == null) {
			return (false);
		}

		if (data.equals(node.data)) {
			return (true);
		} else if (data.compareTo(node.data) < 0) {
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper.
	 */
	public void insert(String data) {
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node insert(Node node, String data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data.compareTo(node.data) <= 0) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}
}
