
package domain;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;

        this.imaginary = imaginary;


    }


    public double getReal() {
        return real;

    }

    public double getImaginary() {
        return imaginary;
    }



    @Override
    public String toString() {
        if (imaginary == 0) {
            return String.valueOf(real); // sau return real + "" concatenare
        }

        if (real == 0) {
            if (imaginary == 1) return "i";

            if (imaginary == -1) return "-i";
            return imaginary + "*i";
        }

        if (imaginary > 0 ){
           return real + " + " + imaginary + "i";
        }
        else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}
