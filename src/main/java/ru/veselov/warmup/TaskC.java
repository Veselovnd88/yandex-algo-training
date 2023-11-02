package ru.veselov.warmup;

import java.util.Scanner;

public class TaskC {

    Scanner sc = new Scanner(System.in);

    public String solution() {

        Point a = readPoint();
        Point b = readPoint();
        if (onOneLine(a, b)) {
            double sqrt = findDistanceLine(a, b);
            return String.valueOf(sqrt);
        } else if (onCircumference(a, b)) {
            return String.valueOf(findDistanceCircumference(a, b));
        }

        return "answer";
    }

    private Point readPoint() {
        return new Point(sc.nextDouble(), sc.nextDouble());
    }

    private static boolean onOneLine(Point a, Point b) {
        if (((-b.x) * (a.y - b.y)) == ((a.x - b.x) * (-b.y))) {
            System.out.println("Точки лежат на одной прямой.");
            return true;
        } else {
            System.out.println("Точки не лежат на одной прямой.");
            return false;
        }
    }

    private static boolean onCircumference(Point a, Point b) {
        System.out.println("On circumference");
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
        System.out.println(radius);
        return (angle / 180) * (2 * Math.PI * radius);
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
