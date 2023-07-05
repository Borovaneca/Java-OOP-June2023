package calculator;

import java.util.Deque;

public class MR implements Operation {
    private Deque<Integer> memory;

    public MR(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
