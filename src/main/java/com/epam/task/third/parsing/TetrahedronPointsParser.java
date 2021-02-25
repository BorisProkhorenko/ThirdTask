package com.epam.task.third.parsing;

import com.epam.task.third.entity.Point;

import java.util.Arrays;
import java.util.List;

public class TetrahedronPointsParser {

    private static final String DELIMITER = ",";
    private static final String SPLITTER = " ";

    public List<Point> parse(String line) {
        line = line.trim();
        String[] stringDataArray = line.split(DELIMITER);
        Point a = parsePoint(stringDataArray[0]);
        Point b = parsePoint(stringDataArray[1]);
        Point c = parsePoint(stringDataArray[2]);
        Point d = parsePoint(stringDataArray[3]);
        List<Point> pointList = Arrays.asList(a, b, c, d);
        return pointList;
    }

    private Point parsePoint(String pointData) {
        pointData = pointData.trim();
        String[] pointDataArray = pointData.split(SPLITTER);
        double x = Double.parseDouble(pointDataArray[0]);
        double y = Double.parseDouble(pointDataArray[1]);
        double z = Double.parseDouble(pointDataArray[2]);
        return new Point(x, y, z);
    }

}
