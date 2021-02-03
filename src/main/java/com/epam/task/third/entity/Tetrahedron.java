package com.epam.task.third.entity;

import com.epam.task.third.logic.RegularTetrahedronLogic;

import java.util.Objects;

public class Tetrahedron {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;
    private final Double edgeLength;

    public Tetrahedron(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        RegularTetrahedronLogic logic = new RegularTetrahedronLogic();
        edgeLength = logic.calculateDistanceBetweenTwoPoints(a, b);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public Double getEdgeLength() {
        return edgeLength;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tetrahedron that = (Tetrahedron) o;
        return Objects.equals(a, that.a) &&
                Objects.equals(b, that.b) &&
                Objects.equals(c, that.c) &&
                Objects.equals(d, that.d) &&
                Objects.equals(edgeLength, that.edgeLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, edgeLength);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", edgeLength=" + edgeLength +
                '}';
    }
}
