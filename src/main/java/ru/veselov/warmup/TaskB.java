package ru.veselov.warmup;

import java.util.Scanner;

public class TaskB {

    Scanner sc = new Scanner(System.in);


    public String solution() {
        Fraction fr1 = readFraction();
        Fraction fr2 = readFraction();
        Fraction sum = sum(fr1, fr2);
        int gcd = findGcd(sum.numerator, sum.denominator);
        return sum.numerator/gcd + " " + sum.denominator/gcd;
    }


    private Fraction readFraction() {
        Fraction fraction = new Fraction();
        fraction.numerator = sc.nextInt();
        fraction.denominator = sc.nextInt();
        return fraction;
    }

    public Fraction sum(Fraction fr1, Fraction fr2) {
        int cDenom = leastCommonMultiple(fr1.denominator, fr2.denominator);
        int cNomin = fr1.numerator * (cDenom / fr1.denominator) + fr2.numerator * (cDenom / fr2.denominator);
        return new Fraction(cNomin, cDenom);
    }


    public static int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int leastCommonMultiple(int a, int b) {
        return a / findGcd(a, b) * b;
    }


}

class Fraction {

    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    public Fraction() {
    }

    int numerator;
    int denominator;
}
