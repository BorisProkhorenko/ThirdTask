package com.epam.task.third.validation;

import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.RegularTetrahedronLogic;

public class RegularTetrahedronValidator implements Validator<Tetrahedron> {

    private static final double THRESHOLD = 0.0001;

    @Override
    public boolean validate(Tetrahedron tetrahedron) {
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        RegularTetrahedronLogic logic = new RegularTetrahedronLogic();
        double ab = tetrahedron.getEdgeLength();
        double ac = logic.calculateDistanceBetweenTwoPoints(a, c);
        double ad = logic.calculateDistanceBetweenTwoPoints(a, d);
        double bc = logic.calculateDistanceBetweenTwoPoints(b, c);
        double bd = logic.calculateDistanceBetweenTwoPoints(b, d);
        double cd = logic.calculateDistanceBetweenTwoPoints(c, d);

        return (Math.abs(ab - ac) < THRESHOLD && Math.abs(ab - ac) < THRESHOLD && Math.abs(ab - ad) < THRESHOLD
                && Math.abs(ab - bc) < THRESHOLD && Math.abs(ab - bd) < THRESHOLD && Math.abs(ab - cd) < THRESHOLD);

    }
}
