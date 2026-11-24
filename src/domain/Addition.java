package domain;

public class Addition implements Operation {

    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary()
        );
    }

    @Override
    public int getPrecedence() {
        return 1;
    } //prioritate mai mica decat inmultirea si impartirea care are 2
}