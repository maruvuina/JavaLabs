package by.bsu.lab10a.main;

import by.bsu.lab10a.logic.Logic;
import by.bsu.lab10a.print.Print;
import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int stackSize = 10;
        Stack<Integer> stack1 = createStackWithRandomElements(stackSize);
        Stack<Integer> stack2 = createStackWithRandomElements(stackSize);
        Print print = new Print();
        System.out.println("\nStack1");
        print.printStackElements(stack1);
        System.out.println("\nStack2");
        print.printStackElements(stack2);
        Logic logic = new Logic();
        logic.swapStackValues(stack1, stack2);
        System.out.println("Stacks after swap");
        System.out.println("\nStack1");
        print.printStackElements(stack1);
        System.out.println("\nStack2");
        print.printStackElements(stack2);
    }

    private static Stack<Integer> createStackWithRandomElements(int stackSize) {
        Stack<Integer> stack = new Stack<>();
        Random random = new Random();
        for (int i = 0; i < stackSize; i++) {
            stack.add(random.nextInt(100));
        }
        return stack;
    }
}
