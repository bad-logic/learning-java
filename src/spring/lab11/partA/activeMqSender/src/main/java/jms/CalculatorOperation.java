package jms;

public class CalculatorOperation {
    private int operand;
    private String operation;

    public CalculatorOperation(String operation, int operand) {
        this.operation = operation;
        this.operand = operand;
    }

    public int getOperand() {
        return operand;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "CalculatorOperation{" +
                "operand=" + operand +
                ", operation='" + operation + '\'' +
                '}';
    }
}
