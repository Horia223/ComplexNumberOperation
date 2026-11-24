package ui;

import domain.ComplexNumber;
import domain.Expression;
import parser.ComplexNumberParser;
import parser.DefaultOperationParser;
import parser.ExpressionParser;
import parser.OperationParser;
import service.ExpressionEvaluator;

public class Main {

    public static void main(String[] args) {
        try {
            ComplexNumberParser complexNumberParser =
                    new ComplexNumberParser();

            OperationParser operationParser =
                    new DefaultOperationParser();

            ExpressionParser expressionParser =
                    new ExpressionParser(
                            complexNumberParser,
                            operationParser
                    );

            Expression expression = expressionParser.parse(args);

            ExpressionEvaluator evaluator = new ExpressionEvaluator();

            ComplexNumber result = evaluator.evaluate(expression);

            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Eroarre: " + e.getMessage());gi
        }
    }
}