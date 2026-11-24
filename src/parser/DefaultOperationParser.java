//tranforma operatiile +, - etc in obiecte de tip Operation
package parser;

import domain.*;

public class DefaultOperationParser implements OperationParser {

    @Override
    public Operation parse(String symbol) {
        if (symbol.equals("+")) return new Addition();

        if (symbol.equals("-")) return new Subtraction();

        if (symbol.equals("*")) return new Multiplication();


        if (symbol.equals("/")) return new Division();

        throw new IllegalArgumentException("Operator invalid: " + symbol);
    }
}
