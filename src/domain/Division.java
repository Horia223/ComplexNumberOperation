package domain;

public class Division implements Operation {

    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        double c = b.getReal();
        double d = b.getImaginary();
        double denominator = c* c + d * d;

        if (denominator == 0) {
            throw new IllegalArgumentException(
                    "Impartirea la zero "
            );
        }

        double real = (a.getReal() * c + a.getImaginary() * d) / denominator;

        double imaginary = (a.getImaginary() * c - a.getReal() * d) / denominator;

        return new ComplexNumber(real, imaginary);
    }



    @Override
    public int getPrecedence() {
        return 2;
    }
}