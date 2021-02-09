package com.epam.task.third.validation;

import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;

import java.util.Objects;

public class RegularTetrahedronValidator implements Validator {

    private static final double THRESHOLD = 0.0001;

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private final static TetrahedronCalculator CALCULATOR = new TetrahedronCalculator();

    public RegularTetrahedronValidator(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public RegularTetrahedronValidator(Tetrahedron tetrahedron) {
        a = tetrahedron.getA();
        b = tetrahedron.getB();
        c = tetrahedron.getC();
        d = tetrahedron.getD();
    }

    @Override
    public boolean validate() {
        double ab = CALCULATOR.calculateDistanceBetweenTwoPoints(a, b);
        double ac = CALCULATOR.calculateDistanceBetweenTwoPoints(a, c);
        double ad = CALCULATOR.calculateDistanceBetweenTwoPoints(a, d);
        double bc = CALCULATOR.calculateDistanceBetweenTwoPoints(b, c);
        double bd = CALCULATOR.calculateDistanceBetweenTwoPoints(b, d);
        double cd = CALCULATOR.calculateDistanceBetweenTwoPoints(c, d);

        return (Math.abs(ab - ac) < THRESHOLD && Math.abs(ab - ac) < THRESHOLD && Math.abs(ab - ad) < THRESHOLD
                && Math.abs(ab - bc) < THRESHOLD && Math.abs(ab - bd) < THRESHOLD && Math.abs(ab - cd) < THRESHOLD);

    }

    public static double getTHRESHOLD() {
        return THRESHOLD;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegularTetrahedronValidator that = (RegularTetrahedronValidator) o;
        return Objects.equals(a, that.a) &&
                Objects.equals(b, that.b) &&
                Objects.equals(c, that.c) &&
                Objects.equals(d, that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "RegularTetrahedronValidator{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
