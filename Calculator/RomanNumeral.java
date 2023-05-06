package Calculator;

enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RomanNumeral fromString(String s) {
        if (s.equals("I")) return I;
        if (s.equals("II")) return II;
        if (s.equals("III")) return III;
        if (s.equals("IV")) return IV;
        if (s.equals("V")) return V;
        if (s.equals("VI")) return VI;
        if (s.equals("VII")) return VII;
        if (s.equals("VIII")) return VIII;
        if (s.equals("IX")) return IX;
        if (s.equals("X")) return X;
        throw new IllegalArgumentException("Недопустимая римская цифра: " + s);
    }
}
