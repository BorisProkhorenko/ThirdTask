package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.parsing.TetrahedronPointsParser;
import com.epam.task.third.validation.InputLineValidator;
import com.epam.task.third.validation.RegularTetrahedronValidator;
import com.epam.task.third.validation.Validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RegularTetrahedronListCreator {

    private DataReader reader;
    private InputLineValidator lineValidator;
    private TetrahedronPointsParser parser;
    private static final Logger LOGGER = LogManager.getLogger();


    public RegularTetrahedronListCreator(DataReader reader, InputLineValidator lineValidator,
                                         TetrahedronPointsParser parser) {
        this.reader = reader;
        this.lineValidator = lineValidator;
        this.parser = parser;
    }

    public List<Tetrahedron> createList(String filePath) {
        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        try {
            List<String> data = reader.readData(filePath);
        LOGGER.log(Level.DEBUG,"Reading from resources - success");

            for (String line : data) {

                if (lineValidator.validate()) {
                    TetrahedronPointsParser parser = new TetrahedronPointsParser();
                    List<Point> tetrahedronData = parser.parse(line);
                    Point a = tetrahedronData.get(0);
                    Point b = tetrahedronData.get(1);
                    Point c = tetrahedronData.get(2);
                    Point d = tetrahedronData.get(3);

                    RegularTetrahedronValidator regularityValidator =
                            new RegularTetrahedronValidator(a, b, c, d);
                    LOGGER.log(Level.DEBUG,"Parsing - success");
                    if (regularityValidator.validate()) {
                        tetrahedronList.add(new Tetrahedron(a, b, c, d));
                        LOGGER.log(Level.DEBUG,"Tetrahedron is regular");
                    }
                }
            }

        } catch (DataException e) {
            e.printStackTrace();
        }

        return tetrahedronList;
    }

    public DataReader getReader() {
        return reader;
    }

    public void setReader(DataReader reader) {
        this.reader = reader;
    }

    public Validator getLineValidator() {
        return lineValidator;
    }

    public void setLineValidator(InputLineValidator lineValidator) {
        this.lineValidator = lineValidator;
    }


    public TetrahedronPointsParser getParser() {
        return parser;
    }

    public void setParser(TetrahedronPointsParser parser) {
        this.parser = parser;
    }

    @Override
    public String toString() {
        return "RegularTetrahedronListCreator{" +
                "reader=" + reader +
                ", lineValidator=" + lineValidator +
                ", parser=" + parser +
                '}';
    }
}
