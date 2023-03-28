package model;

public class Monom {
    private int coeficient;
    private int exponent;

    public Monom(int coeficient, int exponent) {
        this.coeficient = coeficient;
        this.exponent = exponent;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        if (exponent == 0) {
            return coeficient + "1";
        } else if (exponent == 1) {
            return coeficient + "x";
        } else {
            return coeficient + "x^" + exponent;
        }
    }
}