package by.bsu.lab10a.print;

import java.util.Stack;

public class Print {

    public void printStackElements(Stack<Integer> stack) {
        for (Integer integer : stack) {
            System.out.printf("%3d ", integer);
        }
    }
}
