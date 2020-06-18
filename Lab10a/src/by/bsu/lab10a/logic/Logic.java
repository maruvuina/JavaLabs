package by.bsu.lab10a.logic;

import java.util.Stack;

public class Logic {
    private void moveStackValuesReverse(Stack<Integer> srcStack, Stack<Integer> destStack) {
        while (srcStack.size() > 0) {
            destStack.push(srcStack.pop());
        }
    }

    public void swapStackValues(Stack<Integer> stack1, Stack<Integer> stack2) {
        Stack<Integer> stack1Buff = new Stack<>();
        Stack<Integer> stack2Buff = new Stack<>();
        moveStackValuesReverse(stack1, stack1Buff);
        moveStackValuesReverse(stack2, stack2Buff);
        moveStackValuesReverse(stack2Buff, stack1);
        moveStackValuesReverse(stack1Buff, stack2);
    }
}
