package MinStack;

import java.util.Stack;

public class MinStack {

    private class Pair {
        private int minValueStack;
        private int valueStack;

        public Pair (int minValueStack, int valueStack) {
            this.minValueStack = minValueStack;
            this.valueStack = valueStack;
        }

        public int getMinValueStack() {
            return minValueStack;
        }

        public int getValueStack() {
            return valueStack;
        }

        public void setMinValueStack(int minValueStack) {
            this.minValueStack = minValueStack;
        }

        public void setValueStack(int valueStack) {
            this.valueStack = valueStack;
        }
    }

    private Stack<Pair> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        int minValue = val;

        if (!stack.isEmpty()) {
            minValue = stack.peek().minValueStack;
        }

        Pair pair = new Pair(Math.min(minValue, val), val);
        stack.push(pair);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().valueStack;
    }

    public int getMin() {
        return stack.peek().minValueStack;
    }

    public static void main(String[] args) {
         MinStack obj = new MinStack();
         obj.push(3);
         obj.push(2);
         obj.push(5);
    }
}
