package calculator;

import java.util.Deque;

public class MS implements Operation {
    private Deque<Integer> memory;

    public MS(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public int getResult() {
        return memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
