package com.epam.task.third.repo.specifications;

import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan implements TetrahedronSpecification {


    private double distance;
    private final TetrahedronCalculator calculator = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;
    private static final Point ORIGIN = new Point(0, 0, 0);

    public TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        List<Point> points = Arrays.asList(tetrahedron.getA(),tetrahedron.getB(),tetrahedron.getC(),tetrahedron.getD());
        for (Point point : points) {
            if (calculator.calculateDistanceBetweenTwoPoints(point, ORIGIN) - THRESHOLD >= distance) {
                return true;
            }
        }
        return false;
    }
}
