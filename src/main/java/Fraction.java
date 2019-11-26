public class Fraction implements Comparable<Fraction> {
    int numerator;
    int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public int getNumerator() { return numerator; }

    public Fraction(int numerator, int denominator) {
        if (numerator >= Integer.MIN_VALUE && numerator <= Integer.MAX_VALUE && denominator >= Integer.MIN_VALUE && denominator <= Integer.MAX_VALUE) {
            this.numerator = Math.abs(numerator);
            if (denominator <= 0) {
                System.out.println("Invalid input: denominator cannot be <= 0");
                this.numerator = Math.abs(numerator);
                this.denominator = 1;
            }
            else {
                this.denominator = Math.abs(denominator);
            }
        }
        else {
            System.out.println("Invalid input: not in integer bounds");
            this.numerator = 0;
            this.denominator = 1;
        }
    }

    public double getRealValue() {
        double realValue = numerator / denominator;
        return realValue;
    }

    public Fraction add(Fraction fraction) {
        Fraction reducedFraction;
        int newNumerator = numerator + fraction.numerator;
        int newDenominator = denominator + fraction.denominator;
        while (fraction.denominator % fraction.numerator == 0) {
            newNumerator = newNumerator / newNumerator;
            newDenominator = newDenominator / newNumerator;
        }
        reducedFraction = new Fraction(newNumerator, newDenominator);
        return reducedFraction;
    }

    public boolean equals(Fraction fraction) {
        while (fraction.denominator % fraction.numerator == 0) {
            fraction.numerator = fraction.numerator / fraction.numerator;
            fraction.denominator = fraction.denominator / fraction.numerator;
        }
        Fraction reducedFraction = new Fraction(fraction.numerator, fraction.denominator);
        if (reducedFraction.numerator == numerator && reducedFraction.denominator == denominator) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(Fraction fraction) {
        while (fraction.denominator % fraction.numerator == 0) {
            fraction.numerator = fraction.numerator / fraction.numerator;
            fraction.denominator = fraction.denominator / fraction.numerator;
        }
        Fraction reducedFraction = new Fraction(fraction.numerator, fraction.denominator);

        if (this.getRealValue() < fraction.getRealValue()) {
            return -1;
        }
        if (this.getRealValue() > fraction.getRealValue()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}