package challenges;

import java.util.Stack;

/**
 * Implement buffer datastructure which is basically a queue using a stack.
 */
public class BufferQueue
{
    Stack<Integer> pushStack = null;
    Stack<Integer> popStack = null;

    public BufferQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void enqueue(int input) {
        pushStack.push(input);
    }

    public Integer dequeue() {
        if(!popStack.isEmpty()) {
            return popStack.pop();
        }

        if (pushStack.isEmpty()) {
            return null;
        }

        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }

        return popStack.pop();
    }
}
