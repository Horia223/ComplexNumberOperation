package domain;

public interface Operation {
    ComplexNumber execute(ComplexNumber a, ComplexNumber b);

    int getPrecedence();
}