package ru.veselov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskC taskC = new TaskC();
        System.out.println(taskC.solution());
    }
}

class TaskC {

    Scanner sc = new Scanner(System.in);

    public String solution() {

        Point a = readPoint();
        Point b = readPoint();
        if (onOneLine(a, b)) {
            //System.out.println("on straight line");
            double sqrt = findDistanceLine(a, b);
            return String.format("%.12f", sqrt);
        } else if (onCircumference(a, b)) {
            //System.out.println("om circumference");
            return String.format("%.12f", Math.min(findDistanceCircumference(a, b), distanceStraight(a, b)));
        } else {
            return String.format("%.12f", Math.min(distanceThroughCircumference(a, b), distanceStraight(a, b)));
        }

    }

    private Point readPoint() {
        return new Point(sc.nextDouble(), sc.nextDouble());
    }

    private static boolean onOneLine(Point a, Point b) {
        return ((-b.x) * (a.y - b.y)) == ((a.x - b.x) * (-b.y));
    }

    private static boolean onCircumference(Point a, Point b) {
        Point zeroPoint = new Point(0, 0);
        double distanceA = findDistanceLine(a, zeroPoint);
        double distanceB = findDistanceLine(b, zeroPoint);
        return distanceA == distanceB;
    }

    public static double findDistanceLine(Point a, Point b) {
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }

    public static double findDistanceCircumference(Point a, Point b) {
        double atan2 = Math.atan2(Math.abs(b.y - a.y), Math.abs(b.x - a.x));
        double angle = atan2 * (180 / Math.PI);
        double radius = findDistanceLine(a, new Point(0, 0));
        //System.out.println("RADIUS: " + radius);
        return (angle / 180) * (2 * Math.PI * radius);
    }

    public static double distanceStraight(Point a, Point b) {
        Point zero = new Point(0, 0);
        double dFromZeroA = findDistanceLine(a, zero);
        double dFromZeroB = findDistanceLine(b, zero);
        return dFromZeroA + dFromZeroB;
    }

    public static double distanceThroughCircumference(Point a, Point b) {
        Point zero = new Point(0, 0);
        double dFromZeroA = findDistanceLine(a, zero);
        double dFromZeroB = findDistanceLine(b, zero);
        double rC = dFromZeroA - dFromZeroB;
        double k = (dFromZeroA - rC) / dFromZeroA;
        double xC = Math.abs(a.x) * k;
        double yC = Math.abs(a.y) * k;
        Point pointCircum = new Point(xC, yC);
        double distanceCircumference = findDistanceCircumference(pointCircum, b);
        return distanceCircumference + Math.abs(dFromZeroA - dFromZeroB);
    }

}


class Point {

    double x;

    double y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

