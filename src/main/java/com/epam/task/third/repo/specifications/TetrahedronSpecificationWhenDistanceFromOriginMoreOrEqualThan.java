package com.epam.task.third.repo.specifications;

import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan implements TetrahedronSpecification {


    private double distance;
    private static final TetrahedronCalculator CALCULATOR = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;
    private static final Point ORIGIN = new Point(0, 0, 0);

    public TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        for (Point point : points) {
            if (CALCULATOR.calculateDistanceBetweenTwoPoints(point, ORIGIN) - THRESHOLD >= distance) {
                return true;
            }
        }
        return false;
    }
}
