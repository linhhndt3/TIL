package _75_questions;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinStack {
    // TODO enhance runtime
    private Stack<Integer> stack;
    private Queue<Integer> priorityQueue;
    public MinStack() {
        stack = new Stack<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        priorityQueue.add(val);
    }

    public void pop() {
        int e = stack.pop();
        priorityQueue.remove(e);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(1);
        minStack.push(3);

        System.out.println(minStack.getMin());
    }
}