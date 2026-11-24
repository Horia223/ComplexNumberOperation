package parser;

import domain.Operation;

public interface OperationParser {
    Operation parse(String symbol);
}