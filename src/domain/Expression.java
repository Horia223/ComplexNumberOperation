package domain;

public class Expression {
    private ComplexNumber[] numbers;
    private Operation[] operations;

    public Expression(ComplexNumber[] numbers, Operation[] operations) {
        if (numbers == null || operations == null || numbers.length < 2 || operations.length != numbers.length - 1) {
            throw new IllegalArgumentException("Structura expresie invalid.");
        }

        this.numbers = numbers.clone();
        this.operations = operations.clone();
    }

    public ComplexNumber getNumber(int index) {

        return numbers[index];
    }

    public Operation getOperation(int index) {

        return operations[index];
    }

    public int getNumberCount() {

        return numbers.length;
    }

    public int getOperationCount() {

        return operations.length;
    }
}