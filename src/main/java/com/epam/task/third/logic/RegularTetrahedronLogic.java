package com.epam.task.third.logic;

import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;

public class RegularTetrahedronLogic {

    public double calculateDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        double xFirstPoint = firstPoint.getX();
        double yFirstPoint = firstPoint.getY();
        double zFirstPoint = firstPoint.getZ();
        double xSecondPoint = secondPoint.getX();
        double ySecondPoint = secondPoint.getY();
        double zSecondPoint = secondPoint.getZ();

        return Math.sqrt(Math.pow(xSecondPoint - xFirstPoint, 2) + Math.pow(ySecondPoint - yFirstPoint, 2) +
                Math.pow(zSecondPoint - zFirstPoint, 2));
    }

}
