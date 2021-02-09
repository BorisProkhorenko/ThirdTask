package com.epam.task.third.comparators;

import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;

import java.util.Comparator;

public class YCoordinateAPointComparator implements Comparator<Tetrahedron> {

    private static final double THRESHOLD = 0.0001;

    @Override
    public int compare(Tetrahedron tetrahedronFirst, Tetrahedron tetrahedronSecond) {
        Point firstAPoint = tetrahedronFirst.getA();
        Point secondAPoint = tetrahedronSecond.getA();
        if (Math.abs(firstAPoint.getY() - secondAPoint.getY()) < THRESHOLD) {
            return 0;
        } else if (firstAPoint.getY() - secondAPoint.getY() > 0) {
            return 1;
        }
        return -1;
    }
}
