// Expression Parser organizeaza argumentel primite din linia de comanda intr o expresie.
package parser;

import domain.ComplexNumber;
import domain.Expression;
import domain.Operation;

public class ExpressionParser {
    private ComplexNumberParser complexNumberParser;
    private OperationParser operationParser;

    public ExpressionParser(ComplexNumberParser complexNumberParser,     OperationParser operationParser) {
        this.complexNumberParser = complexNumberParser;
        this.operationParser = operationParser;
    }

    public Expression parse(String[] args) {
//---------
        if (args == null ) {
            throw new IllegalArgumentException("Expresie invalida");
        }
        if(args.length < 3)
        {
            throw new IllegalArgumentException("Expresie invalida");
        }

        if(args.length % 2 == 0)
        {
            throw new IllegalArgumentException("Expresie invalida");
        }
//-------
        int n = (args.length + 1)/ 2;
        int m = args.length / 2;

        ComplexNumber[] numbers = new ComplexNumber[n];
        Operation[] operations = new Operation[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = complexNumberParser.parse(args[2 * i]);
        }

        for (int i = 0; i < m; i++) {
            operations[i] = operationParser.parse(args[2 * i + 1]);
        }

        return new Expression(numbers, operations);
    }
}
