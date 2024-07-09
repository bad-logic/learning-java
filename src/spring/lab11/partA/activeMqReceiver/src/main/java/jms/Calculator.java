package jms;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private int value;

    public Calculator(){}

    public int operate(String operator,int operand) throws Exception {
        return switch (operator) {
            case "+" -> this.sum(operand);
            case "-" -> this.subtract(operand);
            case "*" -> this.product(operand);
            default -> throw new Exception("operator not defined in calculator");
        };
    }

    public  int sum(int n){
        this.value += n;
        return this.value;
    }

    public  int subtract(int n){
        this.value -= n;
        return this.value;
    }

    public  int product(int n){
        this.value *= n;
        return this.value;
    }

    public  int getValue(){
        return this.value;
    }
}
