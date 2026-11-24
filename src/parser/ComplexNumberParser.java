//Tranforma textul unui numar complex (parseaza) in obiect ComplexNumber
package parser;

import domain.ComplexNumber;

public class ComplexNumberParser {

    public ComplexNumber parse(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Numar complex gol ");
        }

        String s = text.trim().replace(" ", "").replace("*", "");
        int i = s.indexOf('i');

        if (i == -1) {
            try {
                return new ComplexNumber(Double.parseDouble(s), 0);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Numar invalid" );
            }
        }



        String part = s.substring(0, s.length() - 1);
        int split = -1;

        for (int j = 1; j < part.length(); j++) {

            if (part.charAt(j) == '+' || part.charAt(j) == '-') {
                split = j;

                break;
            }
        }


        String real;
        String imaginary;
        if(split == -1) {
            real = "0";
            imaginary = part;
        }
        else {
            real = part.substring(0,split);
            imaginary = part.substring(split);
        }


        if (imaginary.isEmpty() || imaginary.equals("+"))     imaginary = "1";

        if (imaginary.equals("-"))       imaginary = "-1";

        try {

            return new ComplexNumber(Double.parseDouble(real), Double.parseDouble(imaginary));

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Numar invalid: " + text);

        }
    }
}
