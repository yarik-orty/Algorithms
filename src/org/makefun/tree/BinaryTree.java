package org.makefun.tree;

import java.util.Stack;

public class BinaryTree {

    // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

    public static void main(String[] args) {
        Node root = new Node(99);

        Node left = new Node(22);
        Node right = new Node(88);

        root.left = left;
        root.right = right;

        Node left2 = new Node(11);
        Node right2 = new Node(12);

        left.left = left2;
        left.right = right2;

        BinaryTree tree = new BinaryTree(root);

        System.out.println("\n*******traversePreOrder**********");
        tree.traversePreOrder();
        System.out.println("\n********traversePostOrder*****");
        tree.traversePostOrder();
        System.out.println("\n*********traverseInorder****");
        tree.traverseInorder();
        System.out.println("\n*********traverseInorderITER****");
        tree.traverseInOrderIter(root);
    }

    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void traverseInorder() {
        traverseInorder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    // O(n), because you traverse each node once. Or rather - the amount of work you do for each node is constant (does not depend on the rest of the nodes).
    private void traverseInorder(Node node) {
        if (node == null) return;
        traverseInorder(node.left);
        System.out.print(" " + node.value);
        traverseInorder(node.right);
    }

    private void traverseInOrderIter(Node node) { // O(n) time | O(h) space , h is height of the tree, worst case h = n
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(" " + current.value);
                current = current.right;
            }
        }
    }

    private void traversePostOrder(Node node) {
        if (node == null) return;
        traverseInorder(node.left);
        traverseInorder(node.right);
        System.out.print(" " + node.value);
    }

    private void traversePreOrder(Node node) {
        if (node == null) return;
        System.out.print(" " + node.value);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }
}