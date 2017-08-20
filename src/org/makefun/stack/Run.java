package org.makefun.stack;

public class Run {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(16);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        stack.print();

        stack.pop();
        stack.pop();

        stack.push("17");

        stack.print();
    }
}
