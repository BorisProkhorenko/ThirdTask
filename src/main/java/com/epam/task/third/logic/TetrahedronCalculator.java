package com.epam.task.third.logic;

import com.epam.task.third.data.DataException;
import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.enums.Plane;
import com.epam.task.third.validation.RegularTetrahedronValidator;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
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

    public double calculateRegularTetrahedronsEdgeLength(Tetrahedron tetrahedron)
            throws TetrahedronIsNotRegularException {
        if (isRegular(tetrahedron)) {
            Point a = tetrahedron.getA();
            Point b = tetrahedron.getB();
            return calculateDistanceBetweenTwoPoints(a, b);
        } else {
            throw new TetrahedronIsNotRegularException("Not regular");
        }
    }


    public double calculateTetrahedronArea(Tetrahedron tetrahedron) throws TetrahedronIsNotRegularException {
        if (isRegular(tetrahedron)) {
            double edgeLength = calculateRegularTetrahedronsEdgeLength(tetrahedron);
            return Math.sqrt(3) * Math.pow(edgeLength, 2);
        } else {
            throw new TetrahedronIsNotRegularException("Not regular");
        }
    }

    public double calculateTetrahedronVolume(Tetrahedron tetrahedron) throws TetrahedronIsNotRegularException {
        if (isRegular(tetrahedron)) {
            double edgeLength = calculateRegularTetrahedronsEdgeLength(tetrahedron);
            return (Math.pow(edgeLength, 3) * Math.sqrt(2)) / 12;
        } else {
            throw new TetrahedronIsNotRegularException("Not regular");
        }
    }

    public boolean isTetrahedronsFoundationIsOnOneOfCoordinatePlanes(Tetrahedron tetrahedron) {
        LOGGER.log(Level.WARN, "You should check Tetrahedron for correctness before using this method");
        return isTetrahedronsFoundationIsOnXOYPlane(tetrahedron) || isTetrahedronsFoundationIsOnXOZPlane(tetrahedron) ||
                isTetrahedronsFoundationIsOnYOZPlane(tetrahedron);
    }

    public boolean isTetrahedronsFoundationIsOnYOZPlane(Tetrahedron tetrahedron) {
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

    public boolean isTetrahedronsFoundationIsOnXOZPlane(Tetrahedron tetrahedron) {
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

    public boolean isTetrahedronsFoundationIsOnXOYPlane(Tetrahedron tetrahedron) {
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

    public double calculateSectionalVolumeRatio(Tetrahedron tetrahedron, Plane plane)
            throws TetrahedronIsNotRegularException {
        if (isRegular(tetrahedron)) {
            try {
                Point lonelyPoint = findLonelyPoint(tetrahedron, plane);
                LOGGER.log(Level.DEBUG, "Search of point which is cut off by plane - success");
                double volumeOfTetrahedron = calculateTetrahedronVolume(tetrahedron);
                double volumeOfFirstCutOffPart = calculateSectionalVolumeFromHeight(lonelyPoint, plane);
                double volumeOfSecondCutOffPart = volumeOfTetrahedron - volumeOfFirstCutOffPart;
                return volumeOfFirstCutOffPart / volumeOfSecondCutOffPart;
            } catch (DataException e) {
                e.printStackTrace();
                return 0;
            }
        } else {
            throw new TetrahedronIsNotRegularException("");
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

    private ArrayList<Double> fromTetrahedronToCoordinateList(Tetrahedron tetrahedron, Plane plane) {
        LOGGER.log(Level.INFO, "Start parsing coordinates from tetrahedron depends on secant plane");
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        ArrayList<Double> pointsCoordinates = new ArrayList<>();
        switch (plane) {
            case XOY:
                double aZ = a.getZ();
                double bZ = b.getZ();
                double cZ = c.getZ();
                double dZ = d.getZ();
                pointsCoordinates.add(aZ);
                pointsCoordinates.add(bZ);
                pointsCoordinates.add(cZ);
                pointsCoordinates.add(dZ);
                break;
            case XOZ:
                double aY = a.getY();
                double bY = b.getY();
                double cY = c.getY();
                double dY = d.getY();
                pointsCoordinates.add(aY);
                pointsCoordinates.add(bY);
                pointsCoordinates.add(cY);
                pointsCoordinates.add(dY);
                break;
            case YOZ:
                double aX = a.getX();
                double bX = b.getX();
                double cX = c.getX();
                double dX = d.getX();
                pointsCoordinates.add(aX);
                pointsCoordinates.add(bX);
                pointsCoordinates.add(cX);
                pointsCoordinates.add(dX);
                break;
        }
        return pointsCoordinates;
    }

    private double findLonelyPointCoordinate(ArrayList<Double> pointsCoordinates) throws DataException {
        LOGGER.log(Level.INFO, "Start searching the coordinate of cut of point");
        int counter = 0;
        for (Double coordinate : pointsCoordinates) {
            if (coordinate > 0) {
                counter++;
            } else if (coordinate < 0) {
                counter--;
            }
        }
        double coordinateOfLonelyPoint = 0;
        switch (counter) {
            case 1:
                for (Double coordinate : pointsCoordinates) {
                    if (coordinate < 0) {
                        coordinateOfLonelyPoint = coordinate;
                        break;
                    }
                }
                break;
            case -1:
                for (Double coordinate : pointsCoordinates) {
                    if (coordinate > 0) {
                        coordinateOfLonelyPoint = coordinate;
                        break;
                    }
                }
                break;
            default:
                throw new DataException("Tetrahedron should not be inclined");
        }
        return coordinateOfLonelyPoint;
    }

    private Point fromCoordinateToPoint(Tetrahedron tetrahedron, Plane plane, double coordinate)
            throws DataException {
        LOGGER.log(Level.INFO, "Start parsing point from coordinates depends on secant plane");
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);

        switch (plane) {
            case YOZ:
                for (Point point : points) {
                    if (Math.abs(point.getX() - coordinate) < THRESHOLD) {
                        return point;
                    }
                }
                break;
            case XOZ:
                for (Point point : points) {
                    if (Math.abs(point.getY() - coordinate) < THRESHOLD) {
                        return point;
                    }
                }
                break;
            case XOY:
                for (Point point : points) {
                    if (Math.abs(point.getZ() - coordinate) < THRESHOLD) {
                        return point;
                    }
                }
                break;
        }

        throw new DataException("Not dissected by this plane");
    }

    private Point findLonelyPoint(Tetrahedron tetrahedron, Plane plane) throws DataException {
        ArrayList<Double> coordinateList = fromTetrahedronToCoordinateList(tetrahedron, plane);
        double coordinateOfLonelyPoint = findLonelyPointCoordinate(coordinateList);
        return fromCoordinateToPoint(tetrahedron, plane, coordinateOfLonelyPoint);
    }


    private boolean isRegular(Tetrahedron tetrahedron) {
        return new RegularTetrahedronValidator(tetrahedron).validate();
    }

}
