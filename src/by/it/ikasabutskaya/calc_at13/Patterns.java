package by.it.ikasabutskaya.calc_at13;

public class Patterns {
    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{((-?[0-9]+(\\.[0-9]+)?),?)+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+(\\.[0-9]+)?),?)+},?)+}";
    static final String OPERATION = "(?<=[^{,=+*/-])([-+*/=])";
    static final String BRACES = "\\([-+*/0-9a-zA-Z.]+\\)";
}


