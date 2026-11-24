//Primeste expresia structurata si calculeaza  rezultatul folosind operatiile.
package service;

import domain.ComplexNumber;
import domain.Expression;
import domain.Operation;

public class ExpressionEvaluator {

    public ComplexNumber evaluate(Expression expression) {
        int numberCount = expression.getNumberCount();


        int operationCount = expression.getOperationCount();

        ComplexNumber[] numbers = new ComplexNumber[numberCount];
        Operation[] operations = new Operation[operationCount];


        for (int i = 0; i < numberCount; i++) {
            numbers[i] = expression.getNumber(i);
        }



        for (int i = 0; i < operationCount; i++) {

            operations[i] = expression.getOperation(i);
        }


        int i = 0;

        while (i < operationCount) {

            if (operations[i].getPrecedence() == 2) {
                numbers[i] = operations[i].execute(numbers[i], numbers[i + 1]);



                for (int j = i + 1; j < numberCount - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }

                for (int j = i; j < operationCount - 1; j++) {
                    operations[j] = operations[j + 1];
                }

                numberCount--;
                operationCount--;
            } else {

                i++;
            }
        }

        ComplexNumber result = numbers[0];

        for (i = 0; i < operationCount; i++) {


            result = operations[i].execute(result, numbers[i + 1]);
        }

        return result;
    }
}