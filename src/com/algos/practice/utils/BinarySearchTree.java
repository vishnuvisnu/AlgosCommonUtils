package com.algos.practice.utils;

import com.google.common.base.Preconditions;

public class BinarySearchTree {
    
    private Node root;
    private static class Node {
        Node left;
        Node right;
        int val;
        
        Node(final int val) {
            left = null;
            right = null;
            this.val = val;
        }
    }
    
    public BinarySearchTree() {
        root = null;
    }
    
    public void insert(final int val) {
       root = insert(val, root);
    }
    
    public Node lookup(final int val) {
        return lookup(root, val);
    }
    
    private Node lookup(final Node node, final int val) {
        if (node == null) {
            return null;
        }
        
        if (val == node.val) {
            return node;
        } else if (val < node.val) {
            return lookup(node.left, val);
        } else {
            return lookup(node.right, val);
        }
    }

    private Node insert(final int val, final Node node) {
        if (node == null) {
            return new Node(val);
        }
        if (val > node.val) {
            node.right = insert(val, node.right);
        } else {
            node.left = insert(val, node.left);
        }
        
        return node;
    }
    
    public void remove(final int val) {
        root = remove(val, root);
    }
    
    private Node remove(final int val, final Node node) {
        if(val == node.val) {
            if(node.right == null) {
                return node.left;
            } else if(node.left == null) {
                return node.right;
            } else {
                final Node leftMostNode = getLeftMostNode(node, node.right);
                node.val = leftMostNode.val;
                return node;
            }
        } else if (val < node.val) {
            node.left = remove(val, node.left);
        } else {
            node.right = remove(val, node.right);
        }
        
        return node;
    }
    
    public Node lowestCommonAncestor(final int val1, final int val2) {
        Preconditions.checkNotNull(lookup(val1), val1 + " does not exist in the binary search tree");
        Preconditions.checkNotNull(lookup(val2), val2 + " does not exist in the binary search tree");
        return lowestCommonAncestor(root, val1, val2);
    }
    
    private Node lowestCommonAncestor(final Node node, final int val1, final int val2) {
        if((val1 <= node.val) && (node.val <= val2)) {
            return node;
        } else if ((val1 < node.val) && (val2 < node.val)) {
            return lowestCommonAncestor(node.left, val1, val2);
        } else {
            return lowestCommonAncestor(node.right, val1, val2);
        }
        
    }
    
    private Node getLeftMostNode(Node parent, Node node) {
        Preconditions.checkNotNull(node);
        Preconditions.checkNotNull(parent);
        
        while (node.left != null) {
            parent = node;
            node = node.left;
        }
        parent.left = null;
        return node;
    }
    
    public void printInorder() {
        printInorder(root);
    }
    
    public void printInorder(final Node node) {
        if(node == null) return;
        printInorder(node.left);
        System.out.print(" " + node.val);
        printInorder(node.right);
    }
    
    public void printPreorder() {
        printPreorder(root);
    }
    
    private void printPreorder(final Node node) {
        if(node == null) return;
        System.out.print(" " + node.val);
        printPreorder(node.left);
        
        printPreorder(node.right);
    }
    
    public void printPostorder() {
        printPostorder(root);
    }
    
    private void printPostorder(final Node node) {
        if(node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(" " + node.val);
    }
    
    public static void main(String[] args) {
        final BinarySearchTree binSearchTree = new BinarySearchTree();
        int a[] = {30, 15, 45, 7, 22, 38, 52, 1, 12, 18, 27, 34, 42, 49, 60};
        for(int i:a) {
            binSearchTree.insert(i);
        }
        
        System.out.println("\nInorder");
        binSearchTree.printInorder();
        
        System.out.println("Lowest common ancestor is " + binSearchTree.lowestCommonAncestor(7, 89).val);
        
//        binSearchTree.remove(30);
//        System.out.println("\n After deleting");
//        binSearchTree.printInorder();
    }
}
