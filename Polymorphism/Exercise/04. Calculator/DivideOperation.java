package calculator;

import java.util.ArrayList;
import java.util.List;

public class DivideOperation implements Operation {

    private List<Integer> operand;
    private int result;

    public DivideOperation() {
        this.operand = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operand.add(operand);

        if (this.isCompleted()) {
            this.result = this.operand.get(0) / this.operand.get(1);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operand.size() == 2;
    }
}
