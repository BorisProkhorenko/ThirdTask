package com.epam.task.third.creators;

import com.epam.task.third.data.DataException;
import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.parsing.TetrahedronPointsParser;

import java.util.List;

public class TetrahedronCreator {

    public Tetrahedron create(String line, TetrahedronPointsParser parser) throws DataException {
        List<Point> points = parser.parse(line);
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);
        Point pointD = points.get(3);

        return new Tetrahedron(pointA, pointB, pointC, pointD);
    }
}
