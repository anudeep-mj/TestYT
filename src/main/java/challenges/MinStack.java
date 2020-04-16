package challenges;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    Integer minElement;
    Stack<Integer> holder;
    PriorityQueue<Integer> priorityQueue;

    public MinStack() {
        holder = new Stack<>();

    }

    public void push(int x) {
        holder.push(x);
        priorityQueue.add(x);
    }

    public int pop() {
        int poppedElement = holder.pop();
        priorityQueue.remove(poppedElement);
        return poppedElement;
    }

    public int top() {
        return holder.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}
