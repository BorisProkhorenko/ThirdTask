package com.epam.task.third.parsing;

import com.epam.task.third.data.DataException;
import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;

public class TetrahedronParser {

    private static final String DELIMITER = ",";

    public Tetrahedron parse(String line) throws DataException {
        line = line.trim();
        String[] stringDataArray = line.split(DELIMITER);
        try {
            Point a = parsePoint(stringDataArray[0]);
            Point b = parsePoint(stringDataArray[1]);
            Point c = parsePoint(stringDataArray[2]);
            Point d = parsePoint(stringDataArray[3]);
            return new Tetrahedron(a, b, c, d);
        } catch (Exception e) {
            throw new DataException("Incorrect input", e);
        }

    }

    private Point parsePoint(String pointData) {
        pointData = pointData.trim();
        String[] pointDataArray = pointData.split(" ");
        double x = Double.parseDouble(pointDataArray[0]);
        double y = Double.parseDouble(pointDataArray[1]);
        double z = Double.parseDouble(pointDataArray[2]);
        return new Point(x, y, z);
    }

}
