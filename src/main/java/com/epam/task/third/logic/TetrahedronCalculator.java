package com.epam.task.third.logic;

import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.enums.Plane;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TetrahedronCalculator {

    private static final double THRESHOLD = 0.0001;
    private static final Logger LOGGER = LogManager.getLogger();


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

    public double calculateRegularTetrahedronsEdgeLength(Tetrahedron tetrahedron) {
        Point pointA = tetrahedron.getA();
        Point pointB = tetrahedron.getB();
        return calculateDistanceBetweenTwoPoints(pointA, pointB);

    }

    public double calculateTetrahedronArea(Tetrahedron tetrahedron) {

        double edgeLength = calculateRegularTetrahedronsEdgeLength(tetrahedron);
        return Math.sqrt(3) * Math.pow(edgeLength, 2);

    }

    public double calculateTetrahedronVolume(Tetrahedron tetrahedron) {
        double edgeLength = calculateRegularTetrahedronsEdgeLength(tetrahedron);
        return (Math.pow(edgeLength, 3) * Math.sqrt(2)) / 12;
    }

    public boolean isTetrahedronsFoundationIsOnOneOfCoordinatePlanes(Tetrahedron tetrahedron) {
        LOGGER.log(Level.WARN, "You should check Tetrahedron for correctness before using this method");
        return isTetrahedronsFoundationIsOnXoyPlane(tetrahedron) || isTetrahedronsFoundationIsOnXozPlane(tetrahedron) ||
                isTetrahedronsFoundationIsOnYozPlane(tetrahedron);
    }

    public boolean isTetrahedronsFoundationIsOnYozPlane(Tetrahedron tetrahedron) {
        LOGGER.log(Level.WARN, "You should check Tetrahedron for correctness before using this method");
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        if ((a.getX() - 0 < THRESHOLD && b.getX() - 0 < THRESHOLD && c.getX() - 0 < THRESHOLD) ||
                (a.getX() - 0 < THRESHOLD && b.getX() - 0 < THRESHOLD && d.getX() - 0 < THRESHOLD) ||
                (a.getX() - 0 < THRESHOLD && d.getX() - 0 < THRESHOLD && c.getX() - 0 < THRESHOLD) ||
                (d.getX() - 0 < THRESHOLD && b.getX() - 0 < THRESHOLD && c.getX() - 0 < THRESHOLD)) {
            LOGGER.log(Level.INFO, "Tetrahedron foundation is on YOZ plane");
            return true;
        }
        return false;
    }

    public boolean isTetrahedronsFoundationIsOnXozPlane(Tetrahedron tetrahedron) {
        LOGGER.log(Level.WARN, "You should check Tetrahedron for correctness before using this method");
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        if ((a.getY() - 0 < THRESHOLD && b.getY() - 0 < THRESHOLD && c.getY() - 0 < THRESHOLD) ||
                (a.getY() - 0 < THRESHOLD && b.getY() - 0 < THRESHOLD && d.getY() - 0 < THRESHOLD) ||
                (a.getY() - 0 < THRESHOLD && d.getY() - 0 < THRESHOLD && c.getY() - 0 < THRESHOLD) ||
                (d.getY() - 0 < THRESHOLD && b.getY() - 0 < THRESHOLD && c.getY() - 0 < THRESHOLD)) {
            LOGGER.log(Level.INFO, "Tetrahedron foundation is on XOZ plane");
            return true;
        }
        return false;
    }

    public boolean isTetrahedronsFoundationIsOnXoyPlane(Tetrahedron tetrahedron) {
        LOGGER.log(Level.WARN, "You should check Tetrahedron for correctness before using this method");
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        if ((a.getZ() - 0 < THRESHOLD && b.getZ() - 0 < THRESHOLD && c.getZ() - 0 < THRESHOLD) ||
                (a.getZ() - 0 < THRESHOLD && b.getZ() - 0 < THRESHOLD && d.getZ() - 0 < THRESHOLD) ||
                (a.getZ() - 0 < THRESHOLD && d.getZ() - 0 < THRESHOLD && c.getZ() - 0 < THRESHOLD) ||
                (d.getZ() - 0 < THRESHOLD && b.getZ() - 0 < THRESHOLD && c.getZ() - 0 < THRESHOLD)) {
            LOGGER.log(Level.INFO, "Tetrahedron foundation is on XOY plane");
            return true;
        }
        return false;
    }

    public double calculateSectionalVolumeRatio(Tetrahedron tetrahedron, Plane plane) {
        try {
            Point lonelyPoint = findLonelyPoint(tetrahedron, plane);
            LOGGER.log(Level.DEBUG, "Search of point which is cut off by plane - success");
            double volumeOfTetrahedron = calculateTetrahedronVolume(tetrahedron);
            double volumeOfFirstCutOffPart = calculateSectionalVolumeFromHeight(lonelyPoint, plane);
            double volumeOfSecondCutOffPart = volumeOfTetrahedron - volumeOfFirstCutOffPart;
            return volumeOfFirstCutOffPart / volumeOfSecondCutOffPart;
        } catch (CalculationException e) {
            LOGGER.error(e.getMessage());
            return 0;
        }

    }

    private double calculateSectionalVolumeFromHeight(Point lonelyPoint, Plane plane) {
        LOGGER.log(Level.INFO, "Start calculating volume of cut off tetrahedron");
        double height = 0;
        switch (plane) {
            case XOY:
                height = lonelyPoint.getZ();
                break;
            case XOZ:
                height = lonelyPoint.getY();
                break;
            case YOZ:
                height = lonelyPoint.getX();
                break;
        }
        double edgeLength = height / Math.sqrt(2.0 / 3.0);
        return (Math.pow(edgeLength, 3) * Math.sqrt(2)) / 12;
    }

    private List<Double> fromTetrahedronToCoordinateList(Tetrahedron tetrahedron, Plane plane) {
        LOGGER.log(Level.INFO, "Start parsing coordinates from tetrahedron depends on secant plane");
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        switch (plane) {
            case XOY:
                return Arrays.asList(a.getZ(), b.getZ(), c.getZ(), d.getZ());
            case XOZ:
                return Arrays.asList(a.getY(), b.getY(), c.getY(), d.getY());
            case YOZ:
                return Arrays.asList(a.getX(), b.getX(), c.getX(), d.getX());
            default:
                return new ArrayList<>();
        }
    }

    private double findLonelyPointCoordinate(List<Double> pointsCoordinates)
            throws CalculationException {
        LOGGER.log(Level.INFO, "Start searching the coordinate of cut of point");
        int locationCounter = findLonelyPointPlaneLocation(pointsCoordinates);
        double coordinateOfLonelyPoint;
        switch (locationCounter) {
            case 1:
                coordinateOfLonelyPoint = findMin(pointsCoordinates);
                break;
            case -1:
                coordinateOfLonelyPoint = findMax(pointsCoordinates);
                break;
            default:
                throw new CalculationException("Tetrahedron should not be inclined");
        }
        return coordinateOfLonelyPoint;
    }

    private int findLonelyPointPlaneLocation(List<Double> pointsCoordinates) {
        int counter = 0;
        for (Double coordinate : pointsCoordinates) {
            if (coordinate > 0) {
                counter++;
            } else if (coordinate < 0) {
                counter--;
            }
        }
        return counter;
    }

    private Point fromCoordinateToPoint(Tetrahedron tetrahedron, Plane plane, double coordinate)
            throws CalculationException {
        LOGGER.log(Level.INFO, "Start parsing point from coordinates depends on secant plane");
        List<Point> points = Arrays.asList(tetrahedron.getA(), tetrahedron.getB(), tetrahedron.getC(), tetrahedron.getD());
        switch (plane) {
            case YOZ:
                return fromCoordinateToPointYoz(points, coordinate);
            case XOZ:
                return fromCoordinateToPointXoz(points, coordinate);
            case XOY:
                return fromCoordinateToPointXoy(points, coordinate);
        }
        throw new CalculationException("Not dissected by asserted plane");
    }

    private Point fromCoordinateToPointYoz(List<Point> points, double coordinate) throws CalculationException {
        for (Point point : points) {
            if (Math.abs(point.getX() - coordinate) < THRESHOLD) {
                return point;
            }
        }
        throw new CalculationException("Not dissected by YOZ plane");
    }

    private Point fromCoordinateToPointXoz(List<Point> points, double coordinate) throws CalculationException {
        for (Point point : points) {
            if (Math.abs(point.getY() - coordinate) < THRESHOLD) {
                return point;
            }
        }
        throw new CalculationException("Not dissected by XOZ plane");
    }

    private Point fromCoordinateToPointXoy(List<Point> points, double coordinate) throws CalculationException {
        for (Point point : points) {
            if (Math.abs(point.getZ() - coordinate) < THRESHOLD) {
                return point;
            }
        }
        throw new CalculationException("Not dissected by XOY plane");
    }

    private Point findLonelyPoint(Tetrahedron tetrahedron, Plane plane) throws CalculationException {
        List<Double> coordinateList = fromTetrahedronToCoordinateList(tetrahedron, plane);
        double coordinateOfLonelyPoint = findLonelyPointCoordinate(coordinateList);
        return fromCoordinateToPoint(tetrahedron, plane, coordinateOfLonelyPoint);
    }

    private double findMin(List<Double> coordinates) {
        double min = coordinates.get(0);
        for (double coordinate : coordinates) {
            if (coordinate < min) {
                min = coordinate;
            }
        }
        return min;
    }

    private double findMax(List<Double> coordinates) {
        double max = coordinates.get(0);
        for (double coordinate : coordinates) {
            if (coordinate > max) {
                max = coordinate;
            }
        }
        return max;
    }

}
