package main;

public class Fraction {

    private int numerator; // 分子
    private int denominator; // 分母

    public Fraction(int numerator, int denominator) {
        if (denominator == 0)throw new ArithmeticException("分母不能为0");
        if(numerator < 0 || denominator<0)  throw new ArithmeticException("不能出现负数");
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    private void reduce() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //加
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    //减
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        if(newNumerator<0)throw new ArithmeticException("产生负数");
        return new Fraction(newNumerator, newDenominator);
    }

    //乘
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    //除
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("无法除0");
        }
        return multiply(new Fraction(other.denominator, other.numerator));
    }

    //转字符串
    public String toMixedNumber() {
        if (this.numerator == 0) {
            return "0";
        }
        if (Math.abs(this.numerator) >= this.denominator) {
            int wholePart = this.numerator / this.denominator;
            Fraction fractionalPart = new Fraction(this.numerator % this.denominator, this.denominator);
            if(this.numerator % this.denominator == 0)return wholePart+ " ";
            else return wholePart + " ' " + fractionalPart;
        } else {
            return this.numerator + "/" + this.denominator;
        }
    }

    @Override
    public String toString() {
        return toMixedNumber();
    }
}
